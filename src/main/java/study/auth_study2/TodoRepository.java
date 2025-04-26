package study.auth_study2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    Optional<TodoEntity> findByCompleted(boolean completed);

    Optional<TodoEntity> findByTitle(String title);

    Optional<TodoEntity> findByDescription(String description);

}
