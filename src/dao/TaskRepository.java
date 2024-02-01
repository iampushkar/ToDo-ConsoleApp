package dao;

import java.util.*;
import java.util.stream.IntStream;

import dto.Task;
import exception.DeleteTaskException;
import exception.UpdateTaskException;

public class TaskRepository {

    public static List<Task> taskDB = new ArrayList<>();

    public boolean addTask(Task task) {
        return taskDB.add(task);
    }

    public List<Task> updateTask(Task updatedTask){
        OptionalInt optionalInt = findTask(updatedTask);
       if(optionalInt.isPresent() && checkForChanges(updatedTask,taskDB.get(optionalInt.getAsInt()))){
               taskDB.set(optionalInt.getAsInt(),updatedTask);
       }
       else{
           throw new UpdateTaskException("Failed to update the task check the Task data" + taskDB.toString());
       }
       return taskDB;
    }

    private boolean checkForChanges(Task updatedTask,Task task) {
        return !updatedTask.getTaskName().equals(task.getTaskName()) || !updatedTask.getTaskDeadline().equals(task.getTaskDeadline()) || !updatedTask.getTaskStatus().equals(task.getTaskStatus());
    }

    public List<Task> delete(Task updatedTask){
        OptionalInt optionalInt = findTask(updatedTask);
        if(optionalInt.isPresent()){
            taskDB.remove(optionalInt.getAsInt());
        }
        else{
            throw new DeleteTaskException("Unable to delete the Task" + updatedTask.toString());
        }
        return taskDB;
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
