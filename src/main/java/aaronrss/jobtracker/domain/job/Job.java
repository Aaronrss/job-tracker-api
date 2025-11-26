package aaronrss.jobtracker.domain.job;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    // constructor vacío requerido por JPA
    protected Job() {
    }

    // Opcionales: constructores, getters y setters, vuilder, etc.
}