package controller;

import java.util.List;
import java.util.Scanner;

import dto.Task;
import dto.TaskPriority;
import dto.TaskStatus;
import service.ITaskService;
import service.TaskService;

public class ToDoController {

  private ITaskService taskService = new TaskService();

  public void runToDoApp() {
    while (true) {
      showMenu();
      String userAction = getUserInput("Enter the Action Number");
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
    System.out.println("5. Search Task By ID");
    System.out.println("6. Exit");
  }

  private String getUserInput(String inputMessage) {
    System.out.print(inputMessage + " : ");
    return System.console().readLine();
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
        searchTaskById();
        break;
      case 6:
        System.exit(200);
      default:
        System.out.println("Invalid Action");
    }
  }

  private boolean addTask() {

    String taskName = getUserInput("Enter the Task Name");
    while(taskName == null || taskName.isEmpty()){
      System.out.println("Please provide task name, it is a mandatory field.");
      taskName = getUserInput("Enter the Task Name");
    }

    String taskDeadline = getUserInput(
            "Enter the Task Deadline in format as 01-Jan-2024 [Optional, Press Enter to skip] ");
    if(taskDeadline == null|| taskDeadline.isBlank()){
      taskDeadline = "Not provided";
    }
    TaskPriority taskPriority = null;
    while (taskPriority == null) {
      System.out.println("Available Task Priorities: LOW, MEDIUM, HIGH. Please choose from these");
      String taskPriorityInput = getUserInput("Enter the task Priority");

      try {
        taskPriority = TaskPriority.valueOf(taskPriorityInput.toUpperCase());
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid Task Priority entered. Please enter a valid priority.");
      }
    }

    Task task = new Task(Task.getTaskAutoId(), taskName, TaskStatus.PENDING, taskDeadline, taskPriority);
    return taskService.addTask(task);

  }

  private boolean updateTask() {
    return false;
  }

  private boolean deleteTask() {
    return false;
  }

  private void getTasks() {
    List<Task> tasks = taskService.getTasks();
    System.out.println("-------------------------------------------------------------------------------");
    System.out.println("TASK ID" + " | " + "TASK NAME" + " | " + "TASK STATUS" + " | " + "DEADLINE"  + " | " + "TASK PRIORITY");

    System.out.println("-------------------------------------------------------------------------------");
    tasks.forEach(task -> {
      System.out.println(task.getTaskId() + " | " + task.getTaskName() + " | " + task.getTaskStatus() + " | "
          + task.getTaskDeadline() + " | " + task.getTaskPriority());
    });
    System.out.println("---------------------------------------------------------------------------------");

  }

  private void searchTaskById() {
    String taskIdInput = getUserInput("Enter the Task ID to search");


      try {
        int taskId = Integer.parseInt(taskIdInput);
        Task task = taskService.getTaskById(taskId);
        if (task != null) {
          System.out.println("Task found!!");
          System.out.println("ID: " + task.getTaskId());
          System.out.println("Name: " + task.getTaskName());
          System.out.println("Priority: " + task.getTaskPriority());
          System.out.println("Status: " + task.getTaskStatus());
        } else {
          System.out.println("Task not found with ID: " + taskId);
        }
      }
      catch (NumberFormatException e) {
        System.out.println("Invalid Task ID format. Please enter a valid integer.");
      }

  }
}
