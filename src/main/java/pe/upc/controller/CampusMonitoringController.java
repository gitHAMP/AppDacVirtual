package pe.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.upc.entity.CampusMonitoring;
import pe.upc.entity.Course;
import pe.upc.entity.Week;
import pe.upc.pagination.PageRender;
import pe.upc.service.CampusMonitoringService;
import pe.upc.service.CourseService;
import pe.upc.service.WeekService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("campusMonitoring")
@RequestMapping("/campusmonitoring")
public class CampusMonitoringController {

    @Autowired
    private CampusMonitoringService campusMonitoringService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private WeekService weekService;

    @GetMapping(value = "/new/{id}")
    public String newCampusMonitoring(@PathVariable(value = "id") Long id, Model model,
                                      RedirectAttributes flash) {
        Optional<Course> course;
        try {

            course=courseService.getOne(id);
            if(course.isEmpty()){
                flash.addFlashAttribute("error", "El curso no existe");
                return "redirect:/courses/schedule";
            }else{
                CampusMonitoring campusMonitoring = new CampusMonitoring();
                campusMonitoring.setCourse(course.get());
                model.addAttribute("campusMonitoring", campusMonitoring);
                model.addAttribute("course", course.get());
                model.addAttribute("title", "Registrar");
            }
        }catch (Exception e){

        }
        return "campusmonitoring/form";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(CampusMonitoring campusMonitoring, Model model, RedirectAttributes flash, SessionStatus status, Principal principal) {
        Optional<Course> course;
        try {
                campusMonitoring.setPtcTeacher(principal.getName());
                if(campusMonitoring.getActionsDone().isEmpty()){
                    campusMonitoring.setActionsDone("ninguno");
                }
                if(campusMonitoring.getRecommendations().isEmpty()){
                    campusMonitoring.setRecommendations("ninguno");
                }

                campusMonitoringService.saveOrUpdate(campusMonitoring);
                status.setComplete();
        } catch (Exception e) {
            return "messages/messageerror";
        }
        return "messages/messageok";
    }

    @GetMapping(value = "/report")
    public String reportCampusMonitoring(Model model) {
        try {
            List<Week> weeks= weekService.getAll();
            List<Course> courses = courseService.getAllCoursesByWeek(1L);
            model.addAttribute("courses", courses);
            model.addAttribute("weeks", weeks);
        } catch (Exception e) {

        }
        return "campusmonitoring/campusmonitoring";
    }

    @GetMapping(value = "/courses/week/{id}")
    public String reportCoursesByWeek(Model model,@PathVariable(value = "id" ) Long id) {
        try {
            List<Course> courses = courseService.getAllCoursesByWeek(id);
            List<Week> weeks= weekService.getAll();
            model.addAttribute("weeks", weeks);
            model.addAttribute("courses", courses);

        } catch (Exception e) {

        }
        return "campusmonitoring/campusmonitoring";

    }

}
