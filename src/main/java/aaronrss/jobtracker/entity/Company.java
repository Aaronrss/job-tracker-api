package aaronrss.jobtracker.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String website;
    private String location;
    private String industry;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    // constructor vacío requerido por JPA
    protected Company() {
    }
}
