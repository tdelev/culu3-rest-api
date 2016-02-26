package mk.ukim.finki.config;


import mk.ukim.finki.api.ApplicationEndpoint;
import mk.ukim.finki.errors.AppExceptionMapper;
import mk.ukim.finki.errors.DataIntegrityViolationExceptionMapper;
import mk.ukim.finki.errors.GenericExceptionMapper;
import mk.ukim.finki.errors.NotFoundExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    register(ApplicationEndpoint.class);

    // exceptions
    register(NotFoundExceptionMapper.class);
    register(DataIntegrityViolationExceptionMapper.class);
    register(AppExceptionMapper.class);
    register(GenericExceptionMapper.class);

    // filter
    register(CORSResponseFilter.class);

    property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
  }
}
