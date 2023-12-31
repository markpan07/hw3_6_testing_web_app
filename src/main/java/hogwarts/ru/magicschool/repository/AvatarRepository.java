package hogwarts.ru.magicschool.repository;

import hogwarts.ru.magicschool.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findByStudent_Id(Long studentId);

}
