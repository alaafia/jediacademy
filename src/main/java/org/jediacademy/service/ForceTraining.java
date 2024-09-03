package org.jediacademy.service;

import com.jediacademy.model.Jedi;
import org.jediacademy.model.MissionTask;
import org.jediacademy.service.exception.ForceTrainingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class ForceTraining {

    private static final Logger logger = LoggerFactory.getLogger(ForceTraining.class);
    private final JediCouncil jediCouncil;

    public ForceTraining(JediCouncil jediCouncil) {
        this.jediCouncil = jediCouncil;
    }

    public void startTraining(Jedi jedi) {
        logger.info("Training initiated for Jedi: {} with mission: {}", jedi.getName(), jedi.getMission().getName());
        try {
            jediCouncil.reviewMission(jedi.getMission());
            jediCouncil.validateHolocron(jedi);
            completeTraining(jedi);
        } catch (ForceTrainingException e) {
            logger.error("Training failed for Jedi: {}. Cause: {}", jedi.getName(), e.getMessage());
        }
    }

    private void completeTraining(Jedi jedi) {
        logger.info("Completing training for Jedi {}", jedi.getName());

        int taskCount = jedi.getMission().getTasks().size();
        for (MissionTask task : jedi.getMission().getTasks()) {
            logger.debug("Training on task: {}", task.getDescription());
        }

        CompletableFuture.runAsync(() -> executeTask(jedi))
                .thenRun(() -> finalizeTraining(jedi))
                .exceptionally(ex -> {
                    logger.error("Training failed due to concurrency issue: {}", ex.getMessage());
                    return null;
                });
    }

    private void executeTask(Jedi jedi) {
        logger.debug("Executing task for Jedi {}", jedi.getName());
        // Simulate task execution
    }

    private void finalizeTraining(Jedi jedi) {
        logger.info("Jedi {} has successfully completed the training!", jedi.getName());
    }
}
