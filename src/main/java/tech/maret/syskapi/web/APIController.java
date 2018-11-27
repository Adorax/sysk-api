package tech.maret.syskapi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tech.maret.syskapi.domain.Category;
import tech.maret.syskapi.domain.CategoryRepository;
import tech.maret.syskapi.domain.Place;
import tech.maret.syskapi.domain.PlaceRepository;




@Controller
@RequestMapping("/api")
public class APIController {
	

	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	PlaceRepository placeRepo;	
	//Bean entityManagerFactory;
	
	// --- Admin section -----------------------------------------------------------------------
	
	/**
	 * Get categories for a city
	 * @param city in url
	 * @return categoryNames for this city
	 */
	@GetMapping(value = "/categories/{city}")
	public @ResponseBody String[] category(@PathVariable("city") String city) {
		System.out.println(categoryRepo.findCat(city));
		return (String[]) categoryRepo.findCat(city);
	}
	
	/**
	 * Get Places for a city and a category
	 * @param city and category in url
	 * @return places for this city and category
	 */
	@RequestMapping(value="/place", method = RequestMethod.GET)
	public @ResponseBody List<Place> place(@RequestParam("city") String city,@RequestParam("category") String category) {
		System.out.println(placeRepo.findPlaces(city, category));
		return (List<Place>) placeRepo.findPlaces(city, category);
	}


}
