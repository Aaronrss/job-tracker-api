package aaronrss.jobtracker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Disabled("Context load test disabled during development")
@ActiveProfiles("test")
class JobTrackerApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
