package com.brendan.Repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.brendan.Models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	// Finds all the Languages
	List<Language> findAll();
	// Finds by id
	Optional<Language> findById(Long id);
	// Deletes a Language
	void deleteById(Long id);
}
