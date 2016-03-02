package mk.ukim.finki.repository;

import mk.ukim.finki.model.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Basic CRUD Repository interface in MongoDB
 */
public interface ApplicationMongoRepository extends MongoRepository<Application, Long> {
}
