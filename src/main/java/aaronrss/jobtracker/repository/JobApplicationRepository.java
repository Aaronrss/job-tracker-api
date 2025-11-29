package aaronrss.jobtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aaronrss.jobtracker.entity.Job;

@Repository
public interface JobApplicationRepository extends JpaRepository<Job, Long> {

    List<Job> findByCompany(String company);

}
