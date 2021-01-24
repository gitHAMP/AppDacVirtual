package pe.upc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.upc.entity.Course;

public interface CourseService extends CrudService<Course> {
    Page<Course> getAllCourses(Pageable pageable, String day, String week)throws Exception;
}
