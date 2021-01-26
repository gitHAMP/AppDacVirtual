package pe.upc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.upc.entity.Course;

import java.util.List;

public interface CourseService extends CrudService<Course> {
    Page<Course> getAllCourses(Pageable pageable, String day, String week)throws Exception;
    //Page<Course> getAllCoursesByWeek(Pageable pageable, String week)throws Exception;
    List<Course> getAllCoursesByWeek(Long id)throws Exception;
}
