package demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoFwSamplesJspApplicationTest {
	@Autowired
	TestRestTemplate restTemplate;

	//@Ignore("IDE上ではテストできるが、mvn testで動かない...")
	@Test
	public void contextLoads() {
		String foo = restTemplate.getForObject("/foo", String.class);
		assertThat(foo).contains("Demo Framework (JSP)");
		assertThat(foo).contains("Hello World!");
	}
}
