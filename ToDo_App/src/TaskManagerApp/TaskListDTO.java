package TaskManagerApp;
public class TaskListDTO {	
	public enum TaskStatus
	{
		INPROGRESS,
		PENDING,
		COMPLETED
	}
	
	private int taskId;
	private String taskName;
	private TaskStatus status;
	private String deadline;
	
	public TaskListDTO()
	{
		
	}
	
	public TaskListDTO(int taskId, String taskName, TaskStatus status, String deadline)
	{
		this.taskId = taskId;
		this.taskName = taskName;
		this.status = status;
		this.deadline = deadline;
	}
	
	public int getTaskId()
	{
		return this.taskId;
	}
	
	public void setTaskId(int taskId)
	{
		this.taskId = taskId;
	}
	
	public String getTaskName()
	{
		return this.taskName;
	}
	
	public void setTaskName(String taskName)
	{
		this.taskName = taskName;
	}
	
	public TaskStatus getStatus()
	{
		return this.status;
	}
	
	public void setStatus(TaskStatus status)
	{
		this.status = status;
	}
	
	public String getDeadline()
	{
		return this.deadline;
	}
	
	public void setDeadline(String deadline)
	{
		this.deadline = deadline;
	}
	
	public String toString()
	{
		return "[ TaskId: " + this.taskId + " || TaskName: " + this.taskName + " || TaskStatus: " +this.status + " || TaskDeadLine: " + this.deadline + " ]";
	}

}
