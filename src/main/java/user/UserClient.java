package user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    static {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    }

    public static Response createUser(String email, String password, String name) {
        UserData newUserData = new UserData(email, password, name);
        return given()
                .contentType(ContentType.JSON)
                .body(newUserData)
                .when()
                .post("api/auth/register");
    }

    public static Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete("api/auth/user");
    }

    public static String getAccessToken(String email, String password) {
        return given()
                .header("Content-type", "application/json")
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .post("api/auth/login")
                .then()
                .extract()
                .path("accessToken");
    }
}
