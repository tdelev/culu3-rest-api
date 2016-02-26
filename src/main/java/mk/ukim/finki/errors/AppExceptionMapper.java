package mk.ukim.finki.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AppExceptionMapper implements ExceptionMapper<AppException> {

  Logger log = LoggerFactory.getLogger(AppExceptionMapper.class);

  public Response toResponse(AppException ex) {
    log.error("AppException", ex);
    return Response.status(ex.getStatus())
      .entity(new ErrorMessage(ex))
      .type(MediaType.APPLICATION_JSON).
        build();
  }

}
