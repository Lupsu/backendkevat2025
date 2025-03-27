package harjoitustyo.harjoitustyo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

import harjoitustyo.harjoitustyo.web.AppUserController;
import harjoitustyo.harjoitustyo.web.AppUserDetailServiceImpl;
import harjoitustyo.harjoitustyo.web.SubManAppController;
import harjoitustyo.harjoitustyo.web.SubManAppRestController;

@SpringBootTest
class HarjoitustyoApplicationTests {

	@Autowired
	private AppUserController appUserController;

	@Autowired 
	private SubManAppController subManAppController;

	@Autowired
	private SubManAppRestController subManAppRestController;

	@Autowired
	private AppUserDetailServiceImpl appUserDetailServiceImpl;

	@Test
	void contextLoads() throws Exception {
		assertThat(appUserController).isNotNull();
		assertThat(subManAppController).isNotNull();
		assertThat(subManAppRestController).isNotNull();
		assertThat(appUserDetailServiceImpl).isNotNull();
	}

}
