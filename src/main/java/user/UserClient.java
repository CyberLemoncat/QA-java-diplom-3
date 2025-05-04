package user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static user.Endpoints.*;

public class UserClient {
    static {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    }

    public static Response createNewUser(UserData user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(CREATE_USER);
    }

    public static Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_USER);
    }

    public static String getAccessToken(UserData user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user) // передаем объект
                .when()
                .post(USER_LOGIN)
                .then()
                .extract()
                .path("accessToken");
    }
}
