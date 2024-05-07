package TaskManagerApp;

import java.util.List;
import TaskManagerApp.TaskListDTO.TaskStatus;
import java.util.ArrayList;

public class TaskListDataHandler {
	private List<TaskListDTO> taskListDTOList;
	
	public TaskListDataHandler()
	{
		if (taskListDTOList == null) {
            taskListDTOList = new ArrayList<>();
        }
	}
	
	public void add(TaskListDTO taskListDTO)
	{
		this.taskListDTOList.add(taskListDTO);
	}
	
	public void remove(int taskId)
	{
		this.taskListDTOList.removeIf(task -> task.getTaskId() == taskId);
	}
	
	public void Update(TaskListDTO updateTaskListDTO)
	{
		for(TaskListDTO task : this.taskListDTOList)
		{
			if(updateTaskListDTO.getTaskId() == task.getTaskId())
			{
				if(!updateTaskListDTO.getTaskName().isBlank())
				{
					task.setTaskName(updateTaskListDTO.getTaskName());
				}
				
				if(!updateTaskListDTO.getStatus().toString().isBlank())
				{
					task.setStatus(updateTaskListDTO.getStatus());
				}
				if(!updateTaskListDTO.getDeadline().isBlank())
				{
					task.setDeadline(updateTaskListDTO.getDeadline());
				}
			}
		}
	}
	
	public List<TaskListDTO> display()
	{
		return this.taskListDTOList;
	}
	
	public TaskStatus[] displayStatus()
	{
		return TaskStatus.values();
				
	}
		
}
