package dao;

import java.util.*;
import java.util.stream.IntStream;

import dto.Task;

public class TaskRepository {

    public static List<Task> taskDB = new ArrayList<>();

    public boolean addTask(Task task) {
        return taskDB.add(task);
    }

    public boolean updateTask(Task updatedTask){
        OptionalInt optionalInt = findTask(updatedTask);
       if(optionalInt.isPresent() && checkForChanges(updatedTask,taskDB.get(optionalInt.getAsInt()))){
               taskDB.set(optionalInt.getAsInt(),updatedTask);
       }
        return false;
    }

    private boolean checkForChanges(Task updatedTask,Task task) {
        return !updatedTask.getTaskName().equals(task.getTaskName()) || !updatedTask.getTaskDeadline().equals(task.getTaskDeadline()) || !updatedTask.getTaskStatus().equals(task.getTaskStatus());
    }

    public boolean delete(Task updatedTask){
        OptionalInt optionalInt = findTask(updatedTask);
        if(optionalInt.isPresent() && checkForChanges(updatedTask,taskDB.get(optionalInt.getAsInt()))){
            taskDB.remove(optionalInt.getAsInt());
        }
        return false;
    }

    public List<Task> getTasks() {
        return taskDB;
    }

    private OptionalInt findTask(Task updatedTask) {

        return IntStream.range(0, taskDB.size())
                .filter(i -> Objects.equals(taskDB.get(i).getTaskId(), updatedTask.getTaskId()))
                .findFirst();

    }
    
    
}
