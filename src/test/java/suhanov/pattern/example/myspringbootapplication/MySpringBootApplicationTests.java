package suhanov.pattern.example.myspringbootapplication;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MySpringBootApplicationTests {

	@LocalServerPort
	private String port;

	@Autowired
	private SimpleController simpleController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		assertThat(simpleController).isNotNull();
		assertThat(simpleController.index()).isEqualTo("index");
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/index",
				String.class)).contains("index");
	}

}
