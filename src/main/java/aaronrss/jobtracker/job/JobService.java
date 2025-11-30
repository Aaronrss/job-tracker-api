package aaronrss.jobtracker.job;

import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJobApplication(Job job) {
        // Implementation goes here
        return jobRepository.save(job);
    }

    public Job getJobApplicationById(Long id) {
        // Implementation goes here
        return jobRepository.findById(id).orElse(null);
    }

    public Job listJobApplications() {
        // Implementation goes here
        return null;
    }

    public Boolean deleteJobApplication(Long id) {
        // Implementation goes here
        return false;
    }
}
