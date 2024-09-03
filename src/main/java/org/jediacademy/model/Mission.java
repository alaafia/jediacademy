package org.jediacademy.model;

import java.util.List;

public class Mission {
    private String name;
    private List<MissionTask> tasks;
    private boolean approved;

    public Mission(String name, List<MissionTask> tasks, boolean approved) {
        this.name = name;
        this.tasks = tasks;
        this.approved = approved;
    }

    public String getName() {
        return name;
    }

    public List<MissionTask> getTasks() {
        return tasks;
    }

    public boolean isApproved() {
        return approved;
    }
}
