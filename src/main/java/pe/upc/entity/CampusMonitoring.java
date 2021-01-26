package pe.upc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="campus_monitoring")
public class CampusMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ask_classes", length = 20, nullable = false)
    private String askClasses;
    @Column(name = "ask_security_protocol", length = 50, nullable = false)
    private String askSecurityProtocol;
    @Column(name = "ask_internet", length = 50, nullable = false)
    private String askInternet;
    @Column(name = "ask_electric_fluid", length = 50, nullable = false)
    private String askElectricFluid;
    @Column(name = "actions_done", length = 255, nullable = false)
    private String actionsDone;
    @Column(name = "recommendations", length = 255, nullable = false)
    private String recommendations;
    @Column(name = "ptc_teacher", length = 20, nullable = false)
    private String ptcTeacher;
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}
