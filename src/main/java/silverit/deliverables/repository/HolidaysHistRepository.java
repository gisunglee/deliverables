package silverit.deliverables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silverit.deliverables.common.entity.HolidaysHist;

public interface HolidaysHistRepository extends JpaRepository<HolidaysHist, Long> {
}
