package mk.ukim.finki.service;

import mk.ukim.finki.model.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Application CRUD service
 */
public interface ApplicationService {

  Application save(Application application);

  List<Application> findAll();

  Page<Application> findAll(Pageable pageable);

  Application findOne(Long id);

  void delete(Long id);
}
