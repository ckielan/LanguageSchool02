package pl.school.languageschool.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.school.languageschool.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String string);


}
