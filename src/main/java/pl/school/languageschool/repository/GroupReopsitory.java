package pl.school.languageschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.school.languageschool.domain.Role;

@Repository
public interface GroupReopsitory extends JpaRepository<Role, Long>  {

}
