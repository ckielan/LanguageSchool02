package pl.school.languageschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.school.languageschool.domain.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>  {

    Group findByName(String string);
}
