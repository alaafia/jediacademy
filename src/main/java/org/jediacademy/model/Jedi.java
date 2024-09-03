package com.jediacademy.model;

import org.jediacademy.model.Mission;

public class Jedi {
    private String name;
    private Mission mission;

    public Jedi(String name, Mission mission) {
        this.name = name;
        this.mission = mission;
    }

    public String getName() {
        return name;
    }

    public Mission getMission() {
        return mission;
    }
}
