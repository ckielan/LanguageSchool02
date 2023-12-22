package pl.school.languageschool.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.school.languageschool.domain.StudentGroup;

@Repository
@Transactional
public interface GroupRepository extends JpaRepository<StudentGroup, Long>  {

    StudentGroup findByName(String string);
}
