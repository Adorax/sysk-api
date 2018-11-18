package tech.maret.syskapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import tech.maret.syskapi.domain.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WebRepositoryTest {
	 @Autowired
	  private TestEntityManager entityManager;
	  
	  @Autowired
	  private CategoryRepository catRepository;	  
	  @Autowired
	  private CityRepository citRepository;
	  @Autowired
	  private CountryRepository countRepository;
	  @Autowired
	  private PicRepository picRepository;
	  @Autowired
	  private PlaceRepository plcRepository;
	  @Autowired
	  private PlaceCategoryRepository plCatRepository;
	  @Autowired
	  private RateRepository rateRepository;
	  @Autowired
	  private UserRepository usrRepo;
	  
	  
// --------- SAVE -----------------------------------------------------------------------------------------------------------
	  @Test
	  public void saveCategory() {
	    Category cat = new Category("TestCat");
	    entityManager.persistAndFlush(cat);
	    assertThat(cat.getIdCategory()).isNotNull();
	  }
	  @Test
	  public void saveCountry() {  
		Country country = new Country("AC", "aCountry");
	    entityManager.persistAndFlush(country);
	    assertThat(country.getIdCountry()).isNotNull();
	  }
	  @Test
	  public void saveCity() { 
		entityManager.persistAndFlush(new Country("DM", "foo"));
		City city = new City("Nyon", countRepository.findByNameCountry("foo"));
	    entityManager.persistAndFlush(city);
	    assertThat(city.getIdCity()).isNotNull();
	  }
	  @Test
	  public void savePic() {  
		entityManager.persistAndFlush(new Country("DM", "foo"));
		entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
		Place place = new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null);
		entityManager.persistAndFlush(place);
		Pic pic = new Pic("/pic/pic1.jpg", true, place);
		entityManager.persistAndFlush(pic);   
	    assertThat(pic.getIdPic()).isNotNull();
	  }
	  @Test
	  public void savePlace() { 
		entityManager.persistAndFlush(new Country("DM", "foo"));
		entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
		Place place = new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null);
	    entityManager.persistAndFlush(place);    
	    assertThat(place.getIdPlace()).isNotNull();
	  }
	  @Test
	  public void savePlaceCategory() {  
		entityManager.persistAndFlush(new Country("DM", "foo"));
	   	entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
		entityManager.persistAndFlush(new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null));
		entityManager.persistAndFlush(new Category("TestCat"));
		PlaceCategory plCat = new PlaceCategory(plcRepository.findByNamePlace("name").get(0), catRepository.findByCategoryName("TestCat").get(0));
		entityManager.persistAndFlush(plCat);    
	    assertThat(plCat.getIdPlaceCategory()).isNotNull();
	  }
	  @Test
	  public void saveRate() {  
		entityManager.persistAndFlush(new Country("DM", "foo"));
	    entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
        entityManager.persistAndFlush(new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null));
        entityManager.persistAndFlush(new User("user1", "jej@test.com", "pwdTest"));
		Rate rate = new Rate(plcRepository.findByNamePlace("name").get(0), usrRepo.findByUsername("user1"), true);
	    entityManager.persistAndFlush(rate);    
	    assertThat(rate.getIdRate()).isNotNull();
	  }
	  
// --------- DELETE ---------------------------------------------------------------------------------------------------
	  @Test
	  public void deleteRate() {
		entityManager.persistAndFlush(new Country("DM", "foo"));
		entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
	    entityManager.persistAndFlush(new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null));
	    entityManager.persistAndFlush(new User("user1", "jejgvh@test.com", "pwdTest"));
	    entityManager.persistAndFlush(new User("user2", "jej@test.com", "pwdTest"));
		Rate rate = new Rate(plcRepository.findByNamePlace("name").get(0), usrRepo.findByUsername("user1"), true);
	    entityManager.persistAndFlush(rate);
	    entityManager.persistAndFlush(new Rate(plcRepository.findByNamePlace("name").get(0), usrRepo.findByUsername("user2"), true));   
	    rateRepository.deleteAll();
	    assertThat(rateRepository.findAll()).isEmpty();
	  } 
	  @Test
	  public void deletePlcCat() {
		entityManager.persistAndFlush(new Country("DM", "foo"));
	   	entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
		entityManager.persistAndFlush(new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null));
		entityManager.persistAndFlush(new Category("TestCat"));
		PlaceCategory plCat = new PlaceCategory(plcRepository.findByNamePlace("name").get(0), catRepository.findByCategoryName("TestCat").get(0));
	    entityManager.persistAndFlush(plCat);	    
	    plCatRepository.deleteAll();
	    assertThat(plCatRepository.findAll()).isEmpty();
	  } 
	  @Test
	  public void deletePlc() {
		entityManager.persistAndFlush(new Country("DM", "foo"));
		entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
		entityManager.persistAndFlush(new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null));	    
	    plcRepository.deleteAll();
	    assertThat(plcRepository.findAll()).isEmpty();
	  }
	  @Test
	  public void deletePic() {
		entityManager.persistAndFlush(new Country("DM", "foo"));
		entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
		entityManager.persistAndFlush(new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null));
	    entityManager.persistAndFlush(new Pic("/pic/pic1.jpg", true, plcRepository.findByNamePlace("name").get(0))); 	    
	    picRepository.deleteAll();
	    assertThat(picRepository.findAll()).isEmpty();
	  }
	  @Test
	  public void deleteCountry() {
	    entityManager.persistAndFlush(new Country("ge","aCountry")); 
	    entityManager.persistAndFlush(new Country("dw","anotherCountry")); 
	    countRepository.deleteAll();
	    assertThat(countRepository.findAll()).isEmpty();
	  }	  
	  @Test
	  public void deleteCity() {
		entityManager.persistAndFlush(new Country("DM", "foo"));
	    entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo"))); 
	    entityManager.persistAndFlush(new City("Gland", countRepository.findByNameCountry("foo"))); 
	    citRepository.deleteAll();
	    assertThat(citRepository.findAll()).isEmpty();
	  }
	  @Test
	  public void deleteCategory() {
	    entityManager.persistAndFlush(new Category("aCategory")); 
	    entityManager.persistAndFlush(new Country("nh", "anotherCategory")); 
	    catRepository.deleteAll();
	    assertThat(catRepository.findAll()).isEmpty();
	  }	  

// --------- FIND ---------------------------------------------------------------------------------------------------	  	  
	  @Test
	  public void findByCategoryName() {	
		  Category cat = new Category("aCategory");
		  entityManager.persistAndFlush(cat);
		  assertThat(catRepository.findByCategoryName("aCategory")).isNotNull();
	  }
	  @Test
	  public void findByCountry() {	
		  entityManager.persistAndFlush(new Country("DM", "foo"));
		  City city = new City("cityInSwitzerland", countRepository.findByNameCountry("foo"));
		  entityManager.persistAndFlush(city);
		  assertThat(citRepository.findByCountry(countRepository.findByNameCountry("foo"))).isNotNull();
	  }
	  @Test
	  public void findByNameCountry() {	
		  Country ct = new Country("CH", "Switzerland");
		  entityManager.persistAndFlush(ct);
		  assertThat(countRepository.findByNameCountry("Switzerland")).isNotNull();
	  }
	  @Test
	  public void findByPlace() {
		  entityManager.persistAndFlush(new Country("DM", "foo"));
		  entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
		  Place place = new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null);
		  entityManager.persistAndFlush(place);
		  Pic pic = new Pic("/pic/pic1.jpg", true, place);
		  entityManager.persistAndFlush(pic);
		  assertThat(picRepository.findByPlace(plcRepository.findByNamePlace("name").get(0))).isNotNull();
	  }
	  @Test
	  public void findPlaceCategory() {	
		  entityManager.persistAndFlush(new Country("DM", "foo"));
	   	  entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
		  entityManager.persistAndFlush(new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null));
		  entityManager.persistAndFlush(new Category("TestCat"));
		  PlaceCategory plCat = new PlaceCategory(plcRepository.findByNamePlace("name").get(0), catRepository.findByCategoryName("TestCat").get(0));
		  entityManager.persistAndFlush(plCat);
		  assertThat(plCatRepository.findByPlace(plcRepository.findByNamePlace("name").get(0))).isNotNull();
		  assertThat(plCatRepository.findByCategory(catRepository.findByCategoryName("TestCat").get(0))).isNotNull();
	  }
	  @Test
	  public void findByUser() {	
		  entityManager.persistAndFlush(new Country("DM", "foo"));
		  entityManager.persistAndFlush(new City("Nyon", countRepository.findByNameCountry("foo")));
	      entityManager.persistAndFlush(new Place("name", "address", "descpr", citRepository.findAll().iterator().next(),null));
	      entityManager.persistAndFlush(new User("user1", "jej@test.com", "pwdTest"));
	      Rate rate = new Rate(plcRepository.findByNamePlace("name").get(0), usrRepo.findByUsername("user1"), true);
		  
		  entityManager.persistAndFlush(rate);
		  assertThat(rateRepository.findByUser(usrRepo.findByUsername("user1"))).isNotNull();
	  }
	  
}


