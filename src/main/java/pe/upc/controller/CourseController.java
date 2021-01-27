package pe.upc.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.upc.entity.Course;
import pe.upc.pagination.PageRender;
import pe.upc.service.CourseService;
import pe.upc.service.DayService;
import pe.upc.service.WeekService;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private DayService dayService;
    @Autowired
    private WeekService weekService;
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/schedule")
    public String getAllCustomers(@RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "day", defaultValue = "Miercoles") String day,
                                  @RequestParam(name = "week", defaultValue = "Semana 3") String week,
                                  Model model) {

        try {
            Pageable pageRequest = PageRequest.of(page, 6);

            Page<Course> courses = courseService.getAllCourses(pageRequest,day,week);

            PageRender<Course> pageRender = new PageRender<Course>("/courses/schedule", courses);

            model.addAttribute("title", "Cursos Semipresenciales");

            model.addAttribute("week", week);
            model.addAttribute("day", day);
            model.addAttribute("courses", courses);
            model.addAttribute("page", pageRender);

        } catch (Exception e) {

        }

        return "course/course";
    }

}
