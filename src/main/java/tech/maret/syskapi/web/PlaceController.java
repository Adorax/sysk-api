package tech.maret.syskapi.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tech.maret.syskapi.domain.CategoryRepository;
import tech.maret.syskapi.domain.CityRepository;
import tech.maret.syskapi.domain.PicRepository;
import tech.maret.syskapi.domain.Place;
import tech.maret.syskapi.domain.PlaceCategoryRepository;
import tech.maret.syskapi.domain.PlaceRepository;
import tech.maret.syskapi.domain.User;
import tech.maret.syskapi.domain.UserAPI;
import tech.maret.syskapi.domain.UserRepository;


@Controller
@RequestMapping("/admin/place")
public class PlaceController {
	
	@Autowired
	PlaceRepository placeRepo;
	@Autowired
	PicRepository picRepo;
	@Autowired
	PlaceCategoryRepository placeCatRepo;
	@Autowired
	CategoryRepository catRepo;
	@Autowired
	CityRepository cityRepo;
	//Bean entityManagerFactory;
	
	// --- Admin section -----------------------------------------------------------------------
	
	/**
	 * Show the place page
	 * @param model
	 * @return place page
	 */
	@GetMapping("")
	public String place(Model model) {
		model.addAttribute("places", placeRepo.findAll());
		return "place/place";
	}
	
	/**
	 * show page to add a user
	 * @param model
	 * @return addplace page
	 */
	@GetMapping("/create")
	public String addPlace(Model model) {
		model.addAttribute("place", new Place());
		model.addAttribute("city", cityRepo.findAll());
		return "place/addplace";
	}
	
	/**
	 * Save the new place receive in param
	 * @param place
	 * @return redirect to admin page
	 */
	@PostMapping("/save")
	public String savePlace(Place place){
		placeRepo.save(place);
		return "redirect:/admin/place";
	}
	
	/**
	 * delete place func
	 * @param id place in the path and Model
	 * @return redirect place page
	 */
	@GetMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deletePlace(@PathVariable("id") Long idPlace, Model model) {
		placeRepo.deleteById(idPlace);
		return "redirect:/admin/place";
	}
	
	/**
	 * go to page for updating place 
	 * @param id place in the path and Model
	 * @return  edit page
	 */	
	@GetMapping(value = "/edit/{id}")
	public String updatePlace(@PathVariable("id") Long idPlace, Model model) {
		Place place = placeRepo.findById(idPlace).orElse(null);
		if(place == null) { 
			System.out.println("user with id: "+idPlace+" not find");
			return "redirect:/admin/place";
		}
		model.addAttribute("place", place);
		model.addAttribute("city", cityRepo.findAll());
		return "place/editplace";
	}
	
	/**
	 * edit data of user 
	 * @param id user in the path and UserAPI
	 * @return redirect admin page
	 */
	@PostMapping("/edit/{id}")
	public String editPlace(@PathVariable("id") Long idPlace, Place newPlace){
		Place oldPlace = placeRepo.findById(idPlace).orElse(null) ;
		oldPlace.setNamePlace(newPlace.getNamePlace());
		oldPlace.setAddress(newPlace.getAddress());
		oldPlace.setDescription(newPlace.getDescription());
		oldPlace.setCity(newPlace.getCity());
		placeRepo.save(oldPlace);
		return "redirect:/admin/place";
	}
	
	
	// --- API ---------------------------------------------------------------------------------
	
	/**
	 * RESTful service to READ all places
	 * @param 
	 * @return all places
	 
	@GetMapping("/all")
	public @ResponseBody List<Place> getPlaceListRest() {
		return (List<Place>) placeRepo.findAll();
	}
	
	/**
	 * RESTful service to READ a place
	 * @param id in the link
	 * @return a place
	 *	
	@GetMapping("/{id}")
	public @ResponseBody Place getPlaceRest(@PathVariable("id") Long placeId) {
		return (Place) placeRepo.findById(placeId).orElse(null);
	}
	
	/**
	 * RESTful service to CREATE a place
	 * @param Place in RequestBody
	 * @return a place
	 *	
	@PostMapping("/")
	public ResponseEntity<Object> createPlace(@RequestBody Place place) {
		Place newPlace = placeRepo.save(place);
		//Go to the place that was just created
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPlace.getIdPlace()).toUri();	
		return ResponseEntity.created(location).build();	
	}
	
	/**
	 * RESTful service to PUT a place
	 * @param id in url and Place in RequestBody
	 * @return 
	 *
	@PutMapping("/{id}")
	public String updateAPlace(@PathVariable("id") Long placeId, @RequestBody Place place){
		Place newPlace = place;
		Place oldPlace = placeRepo.findById(placeId).orElse(null);
		if (oldPlace == null) { return "The place with Id : \"+ placeId + \"doesn't exist.";}
		
		return "redirect:../booklist";
	}
	//PUT replaces an entire record. Fields not supplied will be replaced with null. PATCH can be used to update a subset of items
	/**
	 * RESTful service to PATCH a place
	 * @param id in url and Place in RequestBody
	 * @return 
	 *
	@PatchMapping("/{id}")
	public String updatePlace(@PathVariable("id") Long bookId, @RequestBody Place place){

		return "redirect:../booklist";
	}
	
	@DeleteMapping("/{id}")
	//@PreAuthorize("hasRole('ADMIN')")
	public String deletePlace(@PathVariable("id") Long placeId) {
		placeRepo.deleteById(placeId);
		return "The place with Id : "+ placeId + "is deleted.";
	}
*/
}
