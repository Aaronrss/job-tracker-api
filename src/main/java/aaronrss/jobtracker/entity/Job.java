package aaronrss.jobtracker.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; /* FK */

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company; /* FK */

    @OneToMany(mappedBy = "job")
    private List<ApplicationNote> applicationNotes;

    private LocalDateTime appliedAt;

    private LocalDateTime updatedAt;

    private Long salaryExpected;

    private String source;

    // constructor vacío requerido por JPA
    protected Job() {
    }

    // Opcionales: constructores, getters y setters, vuilder, etc.
}