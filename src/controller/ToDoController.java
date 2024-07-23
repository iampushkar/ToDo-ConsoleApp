package controller;

import java.util.List;
import java.util.Scanner;

import dto.Task;
import dto.TaskStatus;
import service.ITaskService;
import service.TaskService;

public class ToDoController {

  private ITaskService taskService = new TaskService();

  public void runToDoApp() {
    while (true) {
      showMenu();
      String userAction = getUserInput("Enter the Action Number : ");
      performAction(Integer.parseInt(userAction));
    }

  }

  private void showMenu() {
    System.out.println("Welcome to the ToDo App!");
    System.out.println("Action Menu: ");
    System.out.println("1. Add a new task");
    System.out.println("2. Update an existing task");
    System.out.println("3. Delete an existing task");
    System.out.println("4. List all Tasks");
    System.out.println("5. Exit");
    System.out.println();
  }

  private String getUserInput(String inputMessage) {
    Scanner in = new Scanner(System.in);
    System.out.println(inputMessage);
    String taskNumber = in.next();
    return taskNumber;
  }

  private void performAction(int action) {
    switch (action) {
      case 1:
        addTask();
        break;
      case 2:
        updateTask();
        break;
      case 3:
        deleteTask();
        break;
      case 4:
        getTasks();
        break;
      case 5:
        System.exit(200);
      default:
        System.out.println("Invalid Action");
    }
  }

  private boolean addTask() {
    String taskName = getUserInput("Enter the Task Name");
    String taskDeadline = getUserInput(
        "Enter the Task Deadline in format as 01-Jan-2024 [Optional, Press Enter to skip] ");

    Task task = new Task(Task.getTaskAutoId(), taskName, TaskStatus.PENDING, taskDeadline);
    return taskService.addTask(task);

  }

  private Task updateTask() {
    String taskId = getUserInput("Enter the Task ID to update : ");
    System.out.println("Task ID to update : " + taskId);

    System.out.println("Task Update options :");
    System.out.println("1. Status");
    System.out.println("2. Name");
    System.out.println("3. Deadline");

    String udpateQuery = getUserInput("What do you want to update in taskId ?"
            + taskId + " Enter in form of array : '(name), (status), (deadline)', leave blank if no update : Eg : ,done,");
    String[] updateQueryArray = udpateQuery.split(",");

    Task task = taskService.getTaskById(Integer.parseInt(taskId));
    return taskService.updateTask(task, updateQueryArray);
  }

  private void deleteTask() {
    String taskId = getUserInput("Enter the Task ID to delete : ");
    System.out.println("Task ID to delete : " + taskId);
    taskService.deleteTask(Integer.parseInt(taskId));
    System.out.println("Task " +taskId + " deleted successfully");
  }

  private void getTasks() {
    List<Task> tasks = taskService.getTasks();
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println("ID" + " | " + "TASK NAME" + " | " + "TASK STATUS" + " | " + "DEADLINE");
    System.out.println("-------------------------------------------------------------------------------");
    tasks.forEach(task -> {
      System.out.println(task.getTaskId() + " | " + task.getTaskName() + " | " + task.getTaskStatus() + " | "
          + task.getTaskDeadline());
    });
    System.out.println("-------------------------------------------------------------------------------");
  }

}
