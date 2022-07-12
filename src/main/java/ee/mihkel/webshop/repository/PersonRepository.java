package ee.mihkel.webshop.repository;

import ee.mihkel.webshop.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//CrudRepo mozno
public interface PersonRepository extends JpaRepository<Person, String> {
}
