package pe.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.entity.Day;

@Repository
public interface DayRepository extends JpaRepository<Day,Long> {
}
