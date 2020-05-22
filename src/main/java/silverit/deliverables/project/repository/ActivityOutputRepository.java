package silverit.deliverables.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.ActivityOutput;

public interface ActivityOutputRepository extends JpaRepository<ActivityOutput, Long> {
}
