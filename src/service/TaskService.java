package service;

import java.util.List;

import dao.TaskRepository;
import dto.Task;

public class TaskService implements ITaskService {
    
    TaskRepository taskRepository;

    public TaskService() {
        this.taskRepository = new TaskRepository();
    }

    @Override
    public boolean addTask(Task task) {
        return taskRepository.addTask(task);
        // throw new UnsupportedOperationException("Unimplemented method 'addTask'");
    }

    @Override
    public Task updateTask(Task task, String[] taskUpdateQuery) {
        return taskRepository.updateTask(task, taskUpdateQuery);
    }

    @Override
    public void deleteTask(int taskId) {
        taskRepository.deleteTask(taskId);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.getTasks();
        // throw new UnsupportedOperationException("Unimplemented method 'showTasks'");
    }

    @Override
    public Task getTaskById(int taskId) {
        Task task = taskRepository.getTask(taskId);
        if(task == null)
            throw new UnsupportedOperationException("Task not found");
        return task;
    }

}
