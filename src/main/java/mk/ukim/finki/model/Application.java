package mk.ukim.finki.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import mk.ukim.finki.json.LocalDateTimeSerializer;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Application domain entity
 */
@Entity
@Table(name = "applications")
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, updatable = false)
  protected Long id;

  @NotEmpty
  @Column(name = "name", nullable = false)
  private String name;

  @NotEmpty
  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @NotEmpty
  @Column(name = "motivation")
  private String motivation;

  @Column(name = "accepted")
  private boolean accepted;

  @Column(name = "date_created")
  @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  private LocalDateTime dateCreated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMotivation() {
    return motivation;
  }

  public void setMotivation(String motivation) {
    this.motivation = motivation;
  }

  public boolean isAccepted() {
    return accepted;
  }

  public void setAccepted(boolean accepted) {
    this.accepted = accepted;
  }

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }
}
