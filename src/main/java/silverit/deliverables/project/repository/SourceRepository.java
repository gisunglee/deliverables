package silverit.deliverables.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Menu;
import silverit.deliverables.common.entity.Source;

public interface SourceRepository extends JpaRepository<Source, Long> {
}
