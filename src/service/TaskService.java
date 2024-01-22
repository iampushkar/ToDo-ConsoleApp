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
    public List<Task> updateTask(Task task) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTask'");
    }

    @Override
    public List<Task> deleteTask(int taskId) {
        // TODO Auto-generated method stub
        //will be implemented by Anunoy
        throw new UnsupportedOperationException("Unimplemented method 'deleteTask'");
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.getTasks();
        // throw new UnsupportedOperationException("Unimplemented method 'showTasks'");
    }
    
}
