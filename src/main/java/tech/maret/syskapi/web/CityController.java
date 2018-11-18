package tech.maret.syskapi.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.maret.syskapi.domain.City;
import tech.maret.syskapi.domain.CityRepository;
import tech.maret.syskapi.domain.CountryRepository;
import tech.maret.syskapi.domain.PlaceRepository;



@Controller
@RequestMapping("/admin/city")
public class CityController {
	
	@Autowired
	PlaceRepository placeRepo;
	@Autowired
	CountryRepository conRepo;
	@Autowired
	CityRepository cityRepo;
	//Bean entityManagerFactory;
	
	// --- Admin section -----------------------------------------------------------------------
	
	/**
	 * Show the city page
	 * @param model
	 * @return city page
	 */
	@GetMapping("")
	public String city(Model model) {
		model.addAttribute("cities", cityRepo.findAll());
		return "city/city";
	}
	
	/**
	 * show page to add a user
	 * @param model
	 * @return addcity page
	 */
	@GetMapping("/create")
	public String addcity(Model model) {
		model.addAttribute("city", new City());
		model.addAttribute("country", conRepo.findAll());
		return "city/addcity";
	}
	
	/**
	 * Save the new city receive in param
	 * @param city
	 * @return redirect to city page
	 */
	@PostMapping("/save")
	public String saveCity(City city){
		cityRepo.save(city);
		return "redirect:/admin/city";
	}
	
	/**
	 * delete city func
	 * @param id city in the path and Model
	 * @return redirect city page
	 */
	@GetMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteCity(@PathVariable("id") Long idCity, Model model) {
		cityRepo.deleteById(idCity);
		return "redirect:/admin/city";
	}
	
	/**
	 * go to page for updating city 
	 * @param id city in the path and Model
	 * @return  edit page
	 */	
	@GetMapping(value = "/edit/{id}")
	public String updateCity(@PathVariable("id") Long idCity, Model model) {
		City city = cityRepo.findById(idCity).orElse(null);
		if(city == null) { 
			System.out.println("user with id: "+idCity+" not find");
			return "redirect:/admin/city";
		}
		model.addAttribute("city", city);
		model.addAttribute("country", conRepo.findAll());
		return "city/editcity";
	}
	
	/**
	 * edit data of user 
	 * @param id user in the path and UserAPI
	 * @return redirect city page
	 */
	@PostMapping("/edit/{id}")
	public String editUser(@PathVariable("id") Long idCity, City newCity){
		City oldCity = cityRepo.findById(idCity).orElse(null) ;
		oldCity.setNameCity(newCity.getNameCity());
		oldCity.setCountry(newCity.getCountry());
		cityRepo.save(oldCity);
		return "redirect:/admin/city";
	}
	
	
	// --- API ---------------------------------------------------------------------------------
	
	/**
	 * RESTful service to READ all citys
	 * @param 
	 * @return all citys
	 
	@GetMapping("/all")
	public @ResponseBody List<city> getcityListRest() {
		return (List<city>) cityRepo.findAll();
	}
	
	/**
	 * RESTful service to READ a city
	 * @param id in the link
	 * @return a city
	 *	
	@GetMapping("/{id}")
	public @ResponseBody city getcityRest(@PathVariable("id") Long cityId) {
		return (city) cityRepo.findById(cityId).orElse(null);
	}
	
	/**
	 * RESTful service to CREATE a city
	 * @param city in RequestBody
	 * @return a city
	 *	
	@PostMapping("/")
	public ResponseEntity<Object> createcity(@RequestBody city city) {
		city newcity = cityRepo.save(city);
		//Go to the city that was just created
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newcity.getIdcity()).toUri();	
		return ResponseEntity.created(location).build();	
	}
	
	/**
	 * RESTful service to PUT a city
	 * @param id in url and city in RequestBody
	 * @return 
	 *
	@PutMapping("/{id}")
	public String updateAcity(@PathVariable("id") Long cityId, @RequestBody city city){
		city newcity = city;
		city oldcity = cityRepo.findById(cityId).orElse(null);
		if (oldcity == null) { return "The city with Id : \"+ cityId + \"doesn't exist.";}
		
		return "redirect:../booklist";
	}
	//PUT recitys an entire record. Fields not supplied will be recityd with null. PATCH can be used to update a subset of items
	/**
	 * RESTful service to PATCH a city
	 * @param id in url and city in RequestBody
	 * @return 
	 *
	@PatchMapping("/{id}")
	public String updatecity(@PathVariable("id") Long bookId, @RequestBody city city){

		return "redirect:../booklist";
	}
	
	@DeleteMapping("/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public String deletecity(@PathVariable("id") Long cityId) {
		cityRepo.deleteById(cityId);
		return "The city with Id : "+ cityId + "is deleted.";
	}
*/
}
