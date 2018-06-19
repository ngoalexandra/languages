package com.alexandra.mvc.repositories;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.alexandra.mvc.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
List<Language> findAll();
// optional means that if we can't find the Id it is ok - in other words it is optional to 
//return an id depending if it exists or not
Optional<Language> findById(Long id);
void deleteById(Long id);
}
