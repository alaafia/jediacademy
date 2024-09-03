
import com.jediacademy.model.Jedi;
import org.jediacademy.model.*;
import org.jediacademy.service.ForceTraining;
import org.jediacademy.service.JediCouncil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.mockito.Mockito.mock;


public class ForceTrainingTest {

    private JediCouncil jediCouncil;
    private ForceTraining forceTraining;

    @BeforeEach
    public void setup() {
        jediCouncil = mock(JediCouncil.class);
        forceTraining = new ForceTraining(jediCouncil);
    }

    @Test
    public void testStartTraining() {
        Jedi jedi = new Jedi("Luke Skywalker", new Mission("Defeat the Empire", Arrays.asList(new MissionTask("Destroy the Death Star")), true));

        forceTraining.startTraining(jedi);

        Mockito.verify(jediCouncil).reviewMission(jedi.getMission());
    }
}
