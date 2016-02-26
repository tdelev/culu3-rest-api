package mk.ukim.finki.api;

import mk.ukim.finki.model.Application;
import mk.ukim.finki.service.ApplicationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

/**
 * Application REST endpoint
 */
@Path("/applications")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationEndpoint {

  @Context
  UriInfo uriInfo;

  @Inject
  ApplicationService service;

  @POST
  public Response save(@Valid Application application) {
    application = service.save(application);
    UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
    URI uri = uriBuilder.path(String.valueOf(application.getId())).build();
    return Response.created(uri).build();
  }

  @PUT
  @Path("/{id}")
  public Response update(@PathParam("id") Long id, @Valid Application application) {
    service.save(application);
    return Response.ok().build();
  }

  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") Long id) {
    service.delete(id);
    return Response.ok().build();
  }

  @GET
  @Path("/{id}")
  public Application get(@PathParam("id") Long id) {
    Application application = service.findOne(id);
    if (application == null) {
      throw new NotFoundException();
    }
    return application;
  }

  @GET
  public List<Application> getAll(@QueryParam("page") Integer page,
                                       @QueryParam("size") Integer size) {
    if (page != null && size != null) {
      Pageable pageable = new PageRequest(page, size);
      return service.findAll(pageable).getContent();
    }
    return service.findAll();
  }
}
