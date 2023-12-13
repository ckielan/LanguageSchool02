package pl.school.languageschool.repository;


import pl.school.languageschool.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
