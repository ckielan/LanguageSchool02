package pl.school.languageschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.school.languageschool.domain.Parents;

public interface ParentsRepository extends JpaRepository <Parents,Long> {

}
