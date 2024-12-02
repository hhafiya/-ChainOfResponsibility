package com.stamping;

import java.util.List;

public class Group {
    private List<Signature> signatures;
    private String groupId;

    public Group(List<Signature> signatures, String groupId) {
        this.signatures = signatures;
        this.groupId = groupId;
    }

    public void apply() {
        System.out.println("Applying group stamp: " + groupId);
        for (Signature signature : signatures) {
            signature.setGroupId(this.groupId);
            signature.execute();
        }
    }

    public String getGroupId() {
        return groupId;
    }
}
