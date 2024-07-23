package service;

import java.util.List;

import dto.Task;

public interface ITaskService {

    public boolean addTask(Task task);

    public Task updateTask(Task task, String[] taskUpdateQuery);

    public void deleteTask(int taskId);

    public List<Task> getTasks();

    public Task getTaskById(int taskId);

}
