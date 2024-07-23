package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Task;
import dto.TaskStatus;

public class TaskRepository {

    public static List<Task> taskDB = new ArrayList<>();

    public boolean addTask(Task task) {
        return taskDB.add(task);
    }

    public List<Task> getTasks() {
        return taskDB;
    }

    public Task getTask(int taskId) {
        for(Task task : taskDB) {
            if (task.getTaskId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public Task updateTask(Task task, String[] taskUpdateQuery){
        for(Task t : taskDB) {
            if (t.getTaskId() == task.getTaskId()) {
                if(taskUpdateQuery.length != 3)
                    System.out.println("Invalid number of arguments, so no update made to the task. Please try updating again.");
                else {
                    if (!taskUpdateQuery[0].isEmpty())
                        t.setTaskName(taskUpdateQuery[0]);
                    if (!taskUpdateQuery[1].isEmpty())
                        t.setTaskStatus(TaskStatus.valueOf(taskUpdateQuery[1].toUpperCase()));
                    if (!taskUpdateQuery[2].isEmpty())
                        t.setDeadline(taskUpdateQuery[2]);
                }
                return t;
            }
        }
        return task;
    }

    public void deleteTask(int taskId){
        int taskIndexToRemove = 0;
        for(Task task : taskDB) {
            if (task.getTaskId() == taskId)
                taskIndexToRemove = taskDB.indexOf(task);
        }
        taskDB.remove(taskIndexToRemove);
    }


    
    
}
