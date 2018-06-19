package com.alexandra.mvc.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexandra.mvc.models.Language;
import com.alexandra.mvc.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	//	get map which displays all the languages in the database
	@GetMapping("")
	public String index(Model model) {
		List<Language> allLangs = languageService.allLanguages();
		Language thisLang = new Language();
		//	it is the same as context in python , where what we query is what we can used to be seen in the jsp	
		model.addAttribute("languages", allLangs);
		model.addAttribute(thisLang);	
		return "index.jsp";	
	}
	
	//	creates a new language and shows within our table
	//	the valid model attribute is used for validation to check errors
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result) {
		//	if there are errors we will render the index jsp with the error message else it will create that langauge 
		//	and redirect to the index page which will show the new language	
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			languageService.createLanguage(lang);
			return "redirect:";
		}	
		
	}
		//	we are using the get mapping because we want to GET that language and show it depending on the id in the url	
		@GetMapping("{id}")
		public String show(@PathVariable(value="id") Long id, Model model) {
			Language lang = languageService.findLanguage(id);
				model.addAttribute("language", lang);
			return "show.jsp";
		}
		
		
		//	we want to use get mapping again because we want to get the id in order to edit the information	
		@GetMapping("/edit/{id}")
		public String edit( @ModelAttribute("language") Language lang, @PathVariable(value="id") Long id, Model model) {
			Language lang1 = languageService.findLanguage(id);
			model.addAttribute("language", lang1);
			return "edit.jsp";
		}
		
		
		// we need to validate before updating that is why we use @valid
		@PostMapping("/update")
		public String update(@Valid @ModelAttribute("language") Language lang, BindingResult result, @RequestParam(value="id") Long id) {
			if(result.hasErrors()) {
				return "edit.jsp";
			} else {
				//	setId is what sets the id within our tables			
				lang.setId(id);
				// once we set the id we update the langauge. in the createLanguage method it has .save() which saves the update in DB		
				languageService.createLanguage(lang);
				return "redirect:";
			}
		}
		
		@PostMapping("/delete")
		// we will delete the language depending on the ID
		public String delete(@RequestParam(value= "id") Long id) {
			languageService.deleteLanguage(id);
			//	after deleting we will be redirected to the dashboard	
			return "redirect:";
		}
		
}
