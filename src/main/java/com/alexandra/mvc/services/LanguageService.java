package com.alexandra.mvc.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.alexandra.mvc.models.Language;
import com.alexandra.mvc.repositories.LanguageRepository;

@Service
public class LanguageService {
//	using the language repository as a dependency
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	
	//	returns all languages, uses findAll from LanguageRepository.java
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	
	//	creates a language. save() is pulled from crudRepository 
	public Language createLanguage(Language lang) {
		return languageRepository.save(lang);
	}
	
	
	//	here we find the language by their id
	public Language findLanguage(Long id) {
		// we create a new object thisLang. Depending on the id, if it is present then we get that language
		Optional<Language> thisLang = languageRepository.findById(id);
		if (thisLang.isPresent()) {
			return thisLang.get();
		} else {
			return null;
		}
		
	}
	
	
	// delete language by their id	
	public Language deleteLanguage(Long id) {
		Optional<Language> thisLang = languageRepository.findById(id);
		if (thisLang.isPresent()) {
			return thisLang.get();
		}
		else {
			return null;
		}
	}

}
