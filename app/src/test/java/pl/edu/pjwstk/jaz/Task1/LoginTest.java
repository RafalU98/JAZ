package pl.edu.pjwstk.jaz.Task1;

import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pjwstk.jaz.Task2.LoginRequest;
import pl.edu.pjwstk.jaz.Task2.RegisterRequest;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@RunWith(SpringRunner.class)
@IntegrationTest
public class LoginTest {

    @BeforeClass
    public static void registering() {
        //@formatter:off
        given()
                .body(new RegisterRequest("Rafał", "Ubermanowicz","admin","admin"))
                .contentType(JSON)
        .when()
                .post("/api/register")
        .thenReturn();
        //@formatter:on

        //@formatter:off
        given()
                .body(new RegisterRequest("Basic", "User","user","user"))
                .contentType(JSON)
        .when()
                .post("/api/register")
        .thenReturn();
        //@formatter:on
    }

    @Test
    public void shouldRegisterSuccessfullyInSpringPath() {
        // @formatter:off
        given()
                .body(new RegisterRequest("Boom","boom","boom","boom"))
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then()
                .statusCode(HttpStatus.OK.value());
        // @formatter:on
    }


    @Test
    public void shouldLoginSuccessfullyInSpringPath() {
        //@formatter:off
        given()
                .body(new LoginRequest("admin", "admin"))
                .contentType(JSON)
                .post("/api/login")
        .then()
                .statusCode(HttpStatus.OK.value());
        //@formatter:on
    }

    @Test
    public void shouldNotLoginWithWrongData() {
        //@formatter:off
        given()
                .body(new LoginRequest("admin", "adfasgaerhgerah"))
                .contentType(JSON)
                .post("/api/login")
                .then()
                .statusCode(401);
        //@formatter:on
    }

    @Test
    public void shouldRespondWithOkayWhenAccessingSiteWithPermission() {
        //@formatter:off
        var response =given()
                .body(new LoginRequest("admin", "admin"))
                .contentType(ContentType.JSON)
                .post("/api/login")
                .thenReturn();
        given()
                .cookies(response.getCookies())
                .get("/api/admin")
                .then()
                .statusCode(HttpStatus.OK.value());
        //@formatter:on
    }

    @Test
    public void shouldRespondWithForbiddenWhenNoAuthorityToVisit() {
        //@formatter:off
        var response =given()
                .body(new LoginRequest("user", "user"))
                .contentType(ContentType.JSON)
                .post("/api/login")
                .thenReturn();
        given()
                .cookies(response.getCookies())
                .get("/api/admin")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
        //@formatter:on
    }

    @Test
    public void shouldLoginSuccessfullyViaAuth0Path() {
        // @formatter:off
        var response =given()
                .body(new LoginRequest("user","user"))
                .contentType(ContentType.JSON)
                .post("/api/login")
                .thenReturn();
        given()
                .cookies(response.getCookies())
                .get("/api/auth0/is-ready")
                .then()
                .statusCode(HttpStatus.OK.value());
        // @formatter:on
    }

    @Test
    public void noAccessForOpenAdminPage() {
        // @formatter:off
        given()
                .get("/api/admin")
                .then()
                .statusCode(HttpStatus.FORBIDDEN.value());
        // @formatter:on

    }

}






