import com.benue.exercises.Scheduler;
import org.junit.Test;

import java.io.File;
import static org.assertj.core.api.Assertions.*;

public class TestScheduleConference {

    @Test
    public void testConference1() {

        // Parse input file and create conference
        Scheduler scheduler = new Scheduler();
        scheduler.schedule("./target/test-classes/talksinput1.txt");

        // Generate output file and write out results
        scheduler.writeOutSchedule("./target/test-classes/talksoutput1.test.txt");

        File actualFile = new File("./target/test-classes/talksoutput1.test.txt");
        File expectedFile = new File("./target/test-classes/talksoutput1.expected.txt");
        assertThat(actualFile).hasSameContentAs(expectedFile);
    }

    @Test
    public void testConference2() {

        // Parse input file and create conference
        Scheduler scheduler = new Scheduler();
        scheduler.schedule("./target/test-classes/talksinput2.txt");

        // Generate output file and write out results
        scheduler.writeOutSchedule("./target/test-classes/talksoutput2.test.txt");

        File actualFile = new File("./target/test-classes/talksoutput2.test.txt");
        File expectedFile = new File("./target/test-classes/talksoutput2.expected.txt");
        assertThat(actualFile).hasSameContentAs(expectedFile);
    }
}
