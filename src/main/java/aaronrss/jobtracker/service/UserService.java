package aaronrss.jobtracker.service;

import org.springframework.stereotype.Service;

import aaronrss.jobtracker.entity.User;
import aaronrss.jobtracker.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        // Validar campos obligatorios
        if (user.getEmail() == null || user.getEmail().isEmpty() || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        // Revisar email duplicado
        if (userRepository.findAll().stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
            throw new IllegalArgumentException("Email already exists");
        }

        // TODO: Hash password before saving (consider using BCryptPasswordEncoder)

        return userRepository.save(user);
    }

    public Boolean deleteUser(Long id) {
        // Implementation goes here
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
