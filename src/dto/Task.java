package DTO;

import javax.print.DocFlavor.STRING;

public class Task {

    private enum TaskStatus {
        PENDING,
        INPROGRESS,
        DONE
    }

    private String taskId;
    private String taskName;
    private String assignedTo;
    private String deadline;
    private String taskStatus;

    public Task(String taskId, String taskName, String assignedTo, String deadline) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.assignedTo = assignedTo;
        this.deadline = deadline;
        this.taskStatus = TaskStatus.PENDING.toString();
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public boolean equals(Object obj) {
        Task task = (Task) obj;
        return taskId.equals(task.getTaskId());
    }

}
