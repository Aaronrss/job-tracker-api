package aaronrss.jobtracker.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

        // Hashear la contraseña antes de guardar
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    public void deleteUser(Long userId, Long requesterId) {
        if (!userId.equals(requesterId)) {
            throw new RuntimeException("Unauthorized");
        }
        userRepository.deleteById(userId);
    }

}
