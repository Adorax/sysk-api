package tech.maret.syskapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.maret.syskapi.domain.Category;
import tech.maret.syskapi.domain.CategoryRepository;




@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	

	@Autowired
	CategoryRepository categoryRepo;
	//Bean entityManagerFactory;
	
	// --- Admin section -----------------------------------------------------------------------
	
	/**
	 * Show the category page
	 * @param model
	 * @return category page
	 */
	@GetMapping("")
	public String category(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "category/category";
	}
	
	/**
	 * show page to add a user
	 * @param model
	 * @return addcategory page
	 */
	@GetMapping("/create")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "category/addcategory";
	}
	
	/**
	 * Save the new category receive in param
	 * @param category
	 * @return redirect to category page
	 */
	@PostMapping("/save")
	public String saveCategory(Category category){
		categoryRepo.save(category);
		return "redirect:/admin/category";
	}
	
	/**
	 * delete category func
	 * @param id category in the path and Model
	 * @return redirect category page
	 */
	@GetMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteCategory(@PathVariable("id") Long idcategory, Model model) {
		categoryRepo.deleteById(idcategory);
		return "redirect:/admin/category";
	}
	
	/**
	 * go to page for updating category 
	 * @param id category in the path and Model
	 * @return  edit page
	 */	
	@GetMapping(value = "/edit/{id}")
	public String updatecategory(@PathVariable("id") Long idcategory, Model model) {
		Category category = categoryRepo.findById(idcategory).orElse(null);
		if(category == null) { 
			System.out.println("user with id: "+idcategory+" not find");
			return "redirect:/admin/category";
		}
		model.addAttribute("category", category);
		return "category/editcategory";
	}
	
	/**
	 * edit data of user 
	 * @param id user in the path and UserAPI
	 * @return redirect category page
	 */
	@PostMapping("/edit/{id}")
	public String editUser(@PathVariable("id") Long idcategory, Category newcategory){
		Category oldcategory = categoryRepo.findById(idcategory).orElse(null) ;
		oldcategory.setCategoryName(newcategory.getCategoryName());
		categoryRepo.save(oldcategory);
		return "redirect:/admin/category";
	}
}
