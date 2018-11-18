package tech.maret.syskapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import tech.maret.syskapi.domain.User;
import tech.maret.syskapi.domain.UserAPI;
import tech.maret.syskapi.domain.UserAPIRepository;
import tech.maret.syskapi.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AdminRepositoryTest {
	 @Autowired
	  private TestEntityManager entityManager;
	  
	  @Autowired
	  private UserAPIRepository repository;
	  
	  @Autowired
	  private UserRepository uRepository;
	  
	  @Test
	  public void saveUserAPI() {
	    UserAPI uAPI = new UserAPI("TestUser", "1234Pwn", "ADMIN");
	    entityManager.persistAndFlush(uAPI);
	    assertThat(uAPI.getIdUser()).isNotNull();
	  }
	  @Test
	  public void saveUser() {
	    User usr = new User("user1", "jej@test.com", "pwdTest");
	    entityManager.persistAndFlush(usr);
	    
	    assertThat(usr.getIdUser()).isNotNull();
	  }
	  
	  @Test
	  public void deleteUserAPI() {
	    entityManager.persistAndFlush(new UserAPI("TestUser3", "ffebwgwe", "ADMIN"));
	    entityManager.persistAndFlush(new UserAPI("TestUser2", "12341545", "ADMIN"));
	    
	    repository.deleteAll();
	    assertThat(repository.findAll()).isEmpty();
	  } 
	  @Test
	  public void deleteUser() {
	    entityManager.persistAndFlush(new User("user2", "jefhwehj@gmail.com", "12345678"));
	    entityManager.persistAndFlush(new User("user3", "usr3@test.com", "test"));
	    
	    uRepository.deleteAll();
	    assertThat(uRepository.findAll()).isEmpty();
	  } 
	  
	  @Test
	  public void findUserAPIByUsername() {	
		  UserAPI uAPI = new UserAPI("TestUser", "1234Pwn", "ADMIN");
		  entityManager.persistAndFlush(uAPI);
		  assertThat(repository.findByUsername("TestUser")).isNotNull();
	  }
	  @Test
	  public void findUserByUsername() {	
		  User usr = new User("user3", "usr3@test.com", "test");
		  entityManager.persistAndFlush(usr);
		  assertThat(uRepository.findByUsername("user3")).isNotNull();
	  }
	  
}


