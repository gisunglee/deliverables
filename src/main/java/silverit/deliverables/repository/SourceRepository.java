package silverit.deliverables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Source;

public interface SourceRepository extends JpaRepository<Source, Long> {
}
