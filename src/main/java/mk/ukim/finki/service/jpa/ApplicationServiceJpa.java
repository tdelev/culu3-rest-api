package mk.ukim.finki.service.jpa;

import mk.ukim.finki.model.Application;
import mk.ukim.finki.repository.ApplicationJpaRepository;
import mk.ukim.finki.service.ApplicationService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Application service JPA implementation
 */
@Primary
@Profile("dev")
@Service
public class ApplicationServiceJpa implements ApplicationService {

  @Inject
  ApplicationJpaRepository repository;

  @Override
  public Application save(Application application) {
    if (application.getDateCreated() == null) {
      application.setDateCreated(LocalDateTime.now());
    }
    return repository.save(application);
  }

  @Override
  public List<Application> findAll() {
    return repository.findAll();
  }

  @Override
  public Page<Application> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public Application findOne(Long id) {
    return repository.findOne(id);
  }

  @Override
  public void delete(Long id) {
    repository.delete(id);
  }
}
