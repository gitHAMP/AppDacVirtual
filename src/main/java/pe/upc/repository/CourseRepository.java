package pe.upc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pe.upc.entity.Course;

import java.util.List;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course,Long> {

      @Query("SELECT c FROM Course c WHERE c.day.name=?1 AND c.week.name=?2 ORDER BY c.startTime")
      Page<Course> findAllCourses(Pageable pageable,String day, String week);

}