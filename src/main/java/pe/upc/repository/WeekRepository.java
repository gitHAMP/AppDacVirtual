package pe.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.entity.Week;

@Repository
public interface WeekRepository extends JpaRepository<Week,Long> {
}
