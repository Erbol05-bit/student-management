package sorokin.dev.springbootguide.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeAuthRepository extends JpaRepository<EmployeeAuth, Long> {
    Optional<EmployeeAuth> findByUsername(String username);
} 