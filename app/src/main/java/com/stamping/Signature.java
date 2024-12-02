package com.stamping;

public class Signature {
    private Task task;
    private String groupId;

    public Signature(Task task) {
        this.task = task;
    }

    public void execute() {
        task.execute();
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }
}

