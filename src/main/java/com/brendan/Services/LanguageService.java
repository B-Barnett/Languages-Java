package com.brendan.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.brendan.Models.Language;
import com.brendan.Repositories.LanguageRepository;

@Service
public class LanguageService {
	// adding the Language repository as a dependency
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	// returns all languages
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	// updates a language
	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
	}
	// deletes a book
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
	}
	// creates a language
	public Language createLanguage(Language lang) {
		return languageRepository.save(lang);
	}
	// retrieves a single language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLang = languageRepository.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
}
