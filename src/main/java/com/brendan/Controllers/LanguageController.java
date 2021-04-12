package com.brendan.Controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.brendan.Models.Language;
import com.brendan.Services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService langService;
	public LanguageController(LanguageService langService) {
		this.langService = langService;
	}
	// if there is a form on the same page as the languages use the ModelAttribute to add language from the form.
	@RequestMapping("/languages")
	public String index(@ModelAttribute("language") Language language, Model model) {
		List<Language> allLang = langService.allLanguages();
		model.addAttribute("languages", allLang);
		return "index.jsp";
	}
	
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language thisLang = langService.findLanguage(id);
		model.addAttribute("language", thisLang);
		return "show.jsp";
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLanguage(id);
		model.addAttribute("language", lang);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			langService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			langService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping(value="/api/languages", method = RequestMethod.POST)
	public Language create(
			@RequestParam(value="name") String name,
			@RequestParam(value="creator") String creator,
			@RequestParam(value="version") String version
			) {
		Language language = new Language(name, creator, version);
		return langService.createLanguage(language);
	}
	
	@RequestMapping("/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		Language language = langService.findLanguage(id);
		return language;
	}
}
