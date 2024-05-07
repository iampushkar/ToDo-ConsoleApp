package TaskManagerApp;

import TaskManagerApp.TaskListDTO.TaskStatus;

public class TaskListBL {
	private TaskListDataHandler takListDataHandler = null;
	
	public TaskListBL()
	{
		takListDataHandler = new TaskListDataHandler();
	}
	
	public void addTask(TaskListDTO taskListDTO) 
	{
		try
		{
			takListDataHandler.add(taskListDTO);
		}
		catch(Exception ex)
		{
			System.out.println("Exception occured : " +  ex);
		}
	}
	
	public void updateTask(TaskListDTO taskListDTO) 
	{
		try
		{
			takListDataHandler.Update(taskListDTO);
		}
		catch(Exception ex)
		{
			System.out.println("Error occured: " + ex);
		}
	}
	
	public void removeTask(int taskId) 
	{
		try
		{
			takListDataHandler.remove(taskId);
		}
		catch(Exception ex)
		{
			System.out.println("Error occured: " + ex);
		}
	}
	
	public void displayTask() 
	{
		try
		{
			if(takListDataHandler.display().size() == 0)
			{
				System.out.println("\nNo task found...");
			}
			for(TaskListDTO task: takListDataHandler.display())
			{
				System.out.println(task);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error occured: " + ex);
		}
	}
	
	public void displayEnum()
	{
		for (TaskStatus status: takListDataHandler.displayStatus())
	    {
		      System.out.println(status);
		}
	}
}
