package pl.school.languageschool.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.school.languageschool.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String string);
}
