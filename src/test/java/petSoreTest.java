import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class petSoreTest {

    @Test

    public void createUserTest() {

        RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"string\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);


    }

    @Test

    public void isInvalidRequestCreateUserTest() {

        RestAssured
                .given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": ,\n" +
                        "  \"username\": \"string\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test

    public void getUserByNameTest() {

        RestAssured
                .given()
                .log()
                .all()
                .when()
                .get("https://petstore.swagger.io/v2/user/string")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test

    public void getIsUserNotFoundTest() {

        RestAssured
                .given()
                .log()
                .all()
                .when()
                .get("https://petstore.swagger.io/v2/user/carlos")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
    @Test

    public void getNotAllowedUserTest() {

        RestAssured
                .given()
                .log()
                .all()
                .when()
                .get("https://petstore.swagger.io/v2/user/")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }


}
//....................................................................................................