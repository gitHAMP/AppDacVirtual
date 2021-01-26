package pe.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.entity.CampusMonitoring;

@Repository
public interface CampusMonitoringRepository extends JpaRepository<CampusMonitoring,Long> {
}
