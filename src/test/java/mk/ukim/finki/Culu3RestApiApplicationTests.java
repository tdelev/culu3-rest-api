package mk.ukim.finki;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import mk.ukim.finki.model.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.ws.rs.core.Response;

import static com.jayway.restassured.RestAssured.given;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Culu3RestApiApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0"})
@ActiveProfiles(profiles = "test")
public class Culu3RestApiApplicationTests {

  Logger log = LoggerFactory.getLogger(getClass());

  @Value("${local.server.port}")
  int port;

  ObjectMapper objectMapper;

  @Before
  public void setUp() throws Exception {
    RestAssured.port = port;
    objectMapper = new ObjectMapper();
  }

  @Test
  public void contextLoads() {
  }

  @Test
  public void testCreate() throws JsonProcessingException {
    Application application = new Application();
    application.setName("Test User");
    application.setEmail("some@someone.com");
    application.setMotivation("This is the motivation");
    String json = objectMapper.writeValueAsString(application);

    String locationHeader = given()
      .accept(ContentType.JSON)
      .contentType(ContentType.JSON)
      .body(json)
      .when().post("/api/applications")
      .then()
      .assertThat()
      .statusCode(Response.Status.CREATED.getStatusCode())
      .extract()
      .header("Location");

    log.debug("Location: {}", locationHeader);

  }

}
