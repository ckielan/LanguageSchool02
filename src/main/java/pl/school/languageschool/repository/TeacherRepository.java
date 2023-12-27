package pl.school.languageschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.school.languageschool.domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
