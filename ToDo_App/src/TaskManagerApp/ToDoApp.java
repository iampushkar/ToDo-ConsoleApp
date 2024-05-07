package TaskManagerApp;

import java.util.Scanner;

import TaskManagerApp.TaskListDTO.TaskStatus;


public class ToDoApp {
	public static void main(String args[])
	{
		TaskListDTO taskListDTO = null;
		TaskListBL taskListBL = new TaskListBL();
		Scanner sc = new Scanner(System.in);
		int taskId = 0;
		int input = 0;
		
		while(input != 5)
		{
			System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\n1. Add Task\n2. Update Task\n3. Delete Task\n4. Dispaly all Task\n5. Exit");
			System.out.print("Please choose from the following: ");
		    input = sc.nextInt();
		    boolean isStatusValid = false;
		    
			switch(input)
			{
				case 1 : System.out.print("\nEnter task name: ");
						 String taskName = sc.next();
						 System.out.println("\nChoose task status: ");
						 taskListBL.displayEnum();
						 TaskStatus taskStatus = null;
						 while(!isStatusValid)
						 {
							 try {

								 	String status = sc.next();
								    taskStatus = TaskStatus.valueOf(status.toUpperCase());
									isStatusValid = true;
								} catch (IllegalArgumentException e) {
								    System.out.println("Invalid status string: " + e);
								    System.out.println("Please choose the valid status: ");
							}
						 }
						 
						 System.out.print("\nEnter deadine date: ");
						 String dateTaskDeadline = sc.next(); 
							  
						 taskListDTO = new TaskListDTO(taskId+=1,taskName, taskStatus,dateTaskDeadline);
						 taskListBL.addTask(taskListDTO);
						 break;
				case 2: System.out.print("\nEnter taskId:");
						int updateTask = sc.nextInt();
						System.out.println("\nEnter new Task Name: ");
						String updateTaskName = sc.next();
						System.out.println("\nChoose task status: ");
						 taskListBL.displayEnum();
						 TaskStatus updateTaskStatus = null;
						 isStatusValid = false;
						 while(!isStatusValid)
						 {
							 try {

								 	String status = sc.next();
								 	updateTaskStatus = TaskStatus.valueOf(status.toUpperCase());
									isStatusValid = true;
								} catch (IllegalArgumentException e) {
								    System.out.println("Invalid status string: " + e);
								    System.out.println("Please choose the valid status: ");
							}
						 }
						 
						 System.out.print("\nEnter deadine date: ");
						 String updateDateTaskDeadline = sc.next(); 
							  
						 taskListDTO = new TaskListDTO(updateTask,updateTaskName, updateTaskStatus,updateDateTaskDeadline);
						 taskListBL.updateTask(taskListDTO);
						 break;
				case 3: System.out.print("\nPlease enter the taskId: ");
						int deleteTaskId = sc.nextInt();
						taskListBL.removeTask(deleteTaskId);
						break;
				case 4: taskListBL.displayTask();
						break;
				case 5 : System.out.println("\nExisting.....");
						break;
				default : System.out.println("\nInvalid input");
						  break;
				
			}
		}
	}
}
