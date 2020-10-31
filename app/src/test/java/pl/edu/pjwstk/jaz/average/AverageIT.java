package pl.edu.pjwstk.jaz.average;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pjwstk.jaz.IntegrationTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@RunWith(SpringRunner.class)
@IntegrationTest
public class AverageIT {

    @Test
    public void should_calculate_simple_average() {
        // @formatter:off
        given()
                .when()
                .param("numbers", "3,1,7,5")
                .get("/api/average")
                .then()
                .body("message",equalTo("Average equals: 4"));
        //formatter:on
    }
    @Test
    public void should_remove_trailing_zeros() {
        // @formatter:off
        given()
                .when()
                .param("numbers", "2,1")
                .get("/api/average")
                .then()
                .body("message",equalTo("Average equals: 1.5"));
        //formatter:on
    }
    @Test
    public void should_round_with_half_up() {
        // @formatter:off
        given()
                .when()
                .param("numbers", "2,1,1")
                .get("/api/average")
                .then()
                .body("message",equalTo("Average equals: 1.33"));
        //formatter:on
    }
    @Test
    public void when_no_parameter_supplied_should_print_a_message() {
        // @formatter:off
        given()
                .when()
                .get("/api/average")
                .then()
                .body("message",equalTo("Please put parameters."));
        //formatter:on
    }

}