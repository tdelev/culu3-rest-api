package mk.ukim.finki.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataIntegrityViolationExceptionMapper implements ExceptionMapper<DataIntegrityViolationException> {
  Logger log = LoggerFactory.getLogger(DataIntegrityViolationExceptionMapper.class);

  public Response toResponse(DataIntegrityViolationException ex) {
    log.error("DataIntegrityViolationException", ex);
    ErrorMessage errorMessage = new ErrorMessage(ex);
    return Response.status(errorMessage.getStatus())
      .entity(errorMessage)
      .type(MediaType.APPLICATION_JSON)
      .build();
  }

}
