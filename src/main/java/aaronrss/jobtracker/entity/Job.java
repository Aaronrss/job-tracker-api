package aaronrss.jobtracker.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;

    @JoinColumn(name = "company_id")
    private Company company; /* FK */

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    private Date appliedAt;

    private Date updatedAt;

    private Long salaryExpected;

    private String source;

    // constructor vacío requerido por JPA
    protected Job() {
    }

    // Opcionales: constructores, getters y setters, vuilder, etc.
}