package DAO;

import DTO.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepo {
    private enum TaskStatus {
        PENDING,
        INPROGRESS,
        DONE
    }

    private List<Task> taskDB = new ArrayList<>();

    public void addTaskToDB(Task task) {
        taskDB.add(task);
        System.out.println("Added task to List");
    }

    public List<Task> listTasks() {
        return taskDB;
    }

    public Task updateTask(Task task) {
        for (Task currTask : taskDB) {
            if (currTask.getTaskId().equals(task.getTaskId())) {

                currTask.setTaskName(task.getTaskName());
                currTask.setAssignedTo(task.getAssignedTo());
                currTask.setDeadline(task.getDeadline());
                System.out.println("TASK UPDATED SUCCESSFULLY");
                System.out.println("");
                break;
            }
        }

        return task;
    }

    public void updateTaskStatus(String taskId, String taskStatus) {
        for (Task currTask : taskDB) {
            if (currTask.getTaskId().equals(taskId)) {

                currTask.setTaskStatus(TaskStatus.valueOf(taskStatus).toString());
                System.out.println("TASK UPDATED SUCCESSFULLY");
                System.out.println("");
                break;
            }
        }
    }

    public void removeTask(String taskId) {
        for (Task curr : taskDB) {
            if (curr.getTaskId().equals(taskId)) {
                taskDB.remove(curr);
                break;
            }
        }
        System.out.println("TASK REMOVED SUCCESSFULLY");
    }
}
