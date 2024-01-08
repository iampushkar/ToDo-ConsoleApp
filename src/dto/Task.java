package dto;

public class Task {
    private int taskId;
    private String taskName;
    private TaskStatus taskStatus;
    private String deadline;

    private TaskPriority taskPriority;

    private static int taskAutoId = 0;

    public Task(int taskId, String taskName, TaskStatus taskStatus, String deadline,TaskPriority taskPriority) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
        this.deadline = deadline;
        this.taskPriority = taskPriority;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskStatus() {
        return String.valueOf(taskStatus);
    }

    public String getTaskDeadline() {
        return deadline;
    }

    public static int getTaskAutoId() {
        taskAutoId++;
        return taskAutoId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public static void setTaskAutoId(int taskAutoId) {
        Task.taskAutoId = taskAutoId;
    }
}
