package com.alexandra.mvc.controllers;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alexandra.mvc.models.Language;
import com.alexandra.mvc.services.LanguageService;

@RestController
public class LanguageApi {
// using the language service as a dependency in our controllers
	private final LanguageService languageService;
	
	public LanguageApi(LanguageService languageService) {
		this.languageService = languageService;
	}
	//	returns all languages. We need to use getmapping when we want to GET all languages and have them displayed in our views. 
	//	We use .allLanguages method that is within our LanguageService file which finds all methods
	@GetMapping("api/languages")
	public List<Language> index(){
		return languageService.allLanguages();
	}
	
	@PostMapping("api/languages")
	public Language create(@RequestParam(value = "name") String name, @RequestParam(value = "creator") String creator, @RequestParam(value = "version") String version) {
		Language language = new Language(name, creator, version);
		return languageService.createLanguage(language);
	}
	
	
}
