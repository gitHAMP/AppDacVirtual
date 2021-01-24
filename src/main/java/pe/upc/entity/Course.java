package pe.upc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 80, nullable = false)
    private String name;

    @Column(name="code_course",length = 80,nullable = false)
    private String codeCourse;

    @Column(name="section",length = 80,nullable = false)
    private String section;

    @Column(name="group_course",length = 80,nullable = false)
    private String groupCourse;

    @Column(name="ambient_type",length = 80,nullable = false)
    private String ambientType;

    @Column(name="start_time",length = 80,nullable = false)
    private String startTime;

    @Column(name="end_time",length = 80,nullable = false)
    private String endTime;

    @Column(name="classroom",length = 80,nullable = false)
    private String classroom;

    @Column(name="session_date",length = 80,nullable = false)
    private String sessionDate;

    @Column(name="academic_semester",length = 80,nullable = false)
    private String academicSemester;


    @ManyToOne
    @JoinColumn(name = "week_id", nullable = false)
    private Week week;

    @ManyToOne
    @JoinColumn(name = "campus_id", nullable = false)
    private Campus campus;


    @ManyToOne
    @JoinColumn(name = "course_type_id", nullable = false)
    private CourseType courseType;

    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
    private Day day;
}
