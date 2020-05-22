package silverit.deliverables.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.ActivityOutput;
import silverit.deliverables.common.entity.HolidaysHist;

public interface HolidaysHistRepository extends JpaRepository<HolidaysHist, Long> {
}
