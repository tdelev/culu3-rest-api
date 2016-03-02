package mk.ukim.finki.repository;

import mk.ukim.finki.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Basic CRUD Repository interface
 */
public interface ApplicationJpaRepository extends JpaRepository<Application, Long> {
}
