package aaronrss.jobtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aaronrss.jobtracker.domain.job.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
