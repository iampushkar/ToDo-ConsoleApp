package Services;

import java.util.List;

import DAO.TaskRepo;
import DTO.Task;

public class TaskService {
    static TaskRepo repo = new TaskRepo();

    public static void addTask(Task task) {
        repo.addTaskToDB(task);
    }

    public static List<Task> listTasks() {
        return repo.listTasks();
    }

    public static Task updateTask(Task task) {
        return repo.updateTask(task);
    }

    public static void updateTaskStaus(String taskId, String taskStatus) {
        repo.updateTaskStatus(taskId, taskStatus);
    }

    public static void removeTask(String taskId) {
        repo.removeTask(taskId);
    }
}
