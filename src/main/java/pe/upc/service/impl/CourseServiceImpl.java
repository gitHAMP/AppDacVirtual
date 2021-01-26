package pe.upc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.upc.entity.Course;
import pe.upc.repository.CourseRepository;
import pe.upc.service.CourseService;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAll() throws Exception {
        return (List<Course>)courseRepository.findAll();
    }

    @Override
    public Page<Course> getAll(Pageable pageable) throws Exception {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Page<Course> getAllCourses(Pageable pageable,String day, String week) throws Exception {
        return courseRepository.findAllCourses(pageable,day,week);
    }

    @Override
    public List<Course> getAllCoursesByWeek(Long id) throws Exception {
        return courseRepository.findAllCoursesByWeek(id);
    }

    @Override
    public Course saveOrUpdate(Course entity) throws Exception {
        return courseRepository.save(entity);
    }

    @Override
    public Optional<Course> getOne(Long id) throws Exception {
        return courseRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        courseRepository.deleteById(id);
    }


}
