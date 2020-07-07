package silverit.deliverables.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
