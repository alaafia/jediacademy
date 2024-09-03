package org.jediacademy.service;

import com.jediacademy.model.Jedi;
import org.jediacademy.model.Mission;
import org.jediacademy.service.exception.HolocronNotFoundException;

import java.util.Objects;

public class JediCouncil {

    public void reviewMission(Mission mission) {
        Objects.requireNonNull(mission, "Mission cannot be null—every mission is crucial!");
        if (mission.getTasks().isEmpty()) {
            throw new IllegalArgumentException("A mission must have objectives to succeed!");
        }
        if (!mission.isApproved()) {
            throw new IllegalStateException("Mission must be approved by the Jedi Council before proceeding.");
        }
    }

    public void validateHolocron(Jedi jedi) throws HolocronNotFoundException {
        // Simulate holocron validation
        if (!holocronExists(jedi)) {
            throw new HolocronNotFoundException("Holocron for " + jedi.getName() + " not found.");
        }
    }

    private boolean holocronExists(Jedi jedi) {
        // Placeholder for actual validation logic
        return Math.random() > 0.5;
    }
}
