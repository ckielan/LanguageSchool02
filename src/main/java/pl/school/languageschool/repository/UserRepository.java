package pl.school.languageschool.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.school.languageschool.domain.Users;


@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String string);
}
