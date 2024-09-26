package service;

import java.util.List;

import dto.Task;

public interface ITaskService {

    public boolean addTask(Task task);

    public List<Task> updateTask(Task task);

    public List<Task> deleteTask(int taskId);

    public List<Task> getTasks();

    public Task getTaskById(int taskId);
}
