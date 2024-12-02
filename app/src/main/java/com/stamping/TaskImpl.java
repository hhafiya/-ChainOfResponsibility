package com.stamping;

public class TaskImpl implements Task {
    private String taskName;

    public TaskImpl(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void execute() {
        System.out.println("Executing task: " + taskName);
    }

    @Override
    public String toString() {
        return taskName;
    }
}
