package tech.maret.syskapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tech.maret.syskapi.web.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SyskApiApplicationTests {

	@Autowired
	private AdminController adC;
	@Autowired
	private CategoryController catC;	
	@Autowired
	private CityController citC;
	@Autowired
	private PlaceController plC;
	@Autowired
	private UserController usrC;
	@Autowired
	private SyskController syskC;
	
	@Test
	public void contextLoads() {
		assertThat(adC).isNotNull();
		assertThat(catC).isNotNull();
		assertThat(citC).isNotNull();
		assertThat(plC).isNotNull();
		assertThat(usrC).isNotNull();
		assertThat(syskC).isNotNull();
	}

}
