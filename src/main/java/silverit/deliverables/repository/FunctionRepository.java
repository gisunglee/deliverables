package silverit.deliverables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.Function;

public interface FunctionRepository extends JpaRepository<Function, Long> {
}
