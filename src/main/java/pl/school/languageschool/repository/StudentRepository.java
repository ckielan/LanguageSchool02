package pl.school.languageschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.school.languageschool.domain.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students,Long> {
}
