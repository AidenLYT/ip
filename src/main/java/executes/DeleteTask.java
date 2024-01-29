package executes;

import java.util.List;

import exceptions.TaylorException;
import tasks.Task;

/**
 * To delete a task
 */
public class DeleteTask {
    /**
     * No constructor needed
     */
    private DeleteTask() {
        throw new AssertionError("Constructor is not allowed");
    }

    /**
     * Execute Deleting tasks
     * @param input : User input
     * @param taskList
     * @throws TaylorException
     */
    public static void execDeleteTask(String input, List<Task> taskList) throws TaylorException {
        try {
            // Input will be 'delete x', where x is an int
            // Then split to get x
            String[] parts = input.split(" ", 2);
            int pos = Integer.parseInt(parts[1]);
            // If x is negative or x is less than total no. of Task, throw error
            if (pos > taskList.size() || pos <= 0) {
                throw new TaylorException("Invalid task number");
            }

            System.out.println("Noted. I've removed this tasks:");
            System.out.println(taskList.get(pos - 1));
            taskList.remove(pos - 1);
            System.out.println("Now you have " + taskList.size() + " tasks in the list.");

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException err) {
            throw new TaylorException("Please include index of task to be removed");
        }
    }
}