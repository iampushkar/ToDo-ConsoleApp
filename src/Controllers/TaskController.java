package Controllers;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import DTO.Task;
import Services.TaskService;

public class TaskController {
    private static Scanner sc = new Scanner(System.in);

    public static void runTodoApp() {
        char option = Character.MIN_VALUE;

        System.out.print("TODO APP! Please Select your desired option.\n" +
                "To add a task. Type a.\n" +
                "to update a task. Type b.\n" +
                "To print all tasks. Type c.\n" +
                "To remove a task. Type d\n");

        option = sc.nextLine().charAt(0);

        performAction(option);

    }

    public static void performAction(char option) {
        switch (option) {
            case 'a':
                addTask();
                break;

            case 'b':
                System.out.println("Please enter task Id to update");
                String taskId = sc.nextLine();
                updateTask(taskId);
                break;
            case 'c':
                listTasks();
                break;

            case 'd':
                System.out.println("Please enter task Id to remove status");
                String __taskId = sc.nextLine();
                removeTask(__taskId);
                break;
            case 'f':
                System.out.println("Please enter task Id to update task status");
                String _taskId = sc.nextLine();
                updateTaskStatus(_taskId);
                break;
            default:
                System.out.println("Invalid option selected. Please try again!");
                break;
        }

        runTodoApp();
    }

    public static void addTask() {
        System.out.println("Please Enter task Name");
        String taskName = sc.nextLine();

        System.out.println("Please enter task's deadline");
        String deadline = sc.nextLine();

        System.out.println("Who would you like to assign this task?");
        String assignedTo = sc.nextLine();

        String id = UUID.randomUUID().toString();

        Task currentTask = new Task(id, taskName, assignedTo, deadline);
        TaskService.addTask(currentTask);
    }

    public static void listTasks() {
        List<Task> tasklist = TaskService.listTasks();

        for (Task element : tasklist) {
            System.out.println("-----TASKS-START------");
            System.out.println(element.getTaskId());
            System.out.println(element.getDeadline());
            System.out.println(element.getTaskName());
            System.out.println(element.getTaskStatus());
            System.out.println(element.getAssignedTo());
            System.out.println("-----TASKS-END------");
        }

        System.out.println("All tasks printed successfully.");
    }

    public static void updateTask(String taskId) {
        System.out.println("Redefine task name");
        String taskName = sc.nextLine();

        System.out.println("Redefine task deadline");
        String deadline = sc.nextLine();

        System.out.println("Reassign task");
        String assignedTo = sc.nextLine();

        Task updatedTask = new Task(taskId, taskName, assignedTo, deadline);
        TaskService.updateTask(updatedTask);

        System.out.println("UPDATED TASK LIST");
        listTasks();
    }

    public static void updateTaskStatus(String taskId) {

        System.out.println("Enter your desired status");
        System.out.println("INPROCESS, DONE, PENDING");
        String taskStatus = sc.nextLine();

        TaskService.updateTaskStaus(taskId, taskStatus);
        System.out.println("TASK STATUS UPDATED SUCCESSFULLY");
        listTasks();
    }

    public static void removeTask(String taskId) {
        TaskService.removeTask(taskId);
        listTasks();
    }
}
