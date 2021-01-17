package postItem.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PostMethods {
  public static Response getThePost() {
    Response response = RestAssured.given()
            .contentType("application/json")
            .log().all()
            .header("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
            .header("Cookie", "__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/15");
    return response;
  }

  public static Response getPosts() {
    Response response = RestAssured.given()
            .contentType("application/json")
            .log().all()
            .header("Cookie", "__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .when()
            .get("https://jsonplaceholder.typicode.com/posts");
    return response;
  }

  public static Response postNewPost() {
    Response response = RestAssured.given()
            .contentType("application/json")
            .log().all()
            .header("Cookie", "__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .body("{\n" +
                    "\t\"method\": \"POST\",\n   " +
                    " \"title\": \"fooo 556dhdd\",\n  " +
                    " \"body\": \"barscdcd44jjhhjffd\",\n  " +
                    " \"userId\": 1\n}")
            .when()
            .post("https://jsonplaceholder.typicode.com/posts");
    return response;
  }

  public static Response changeThePost() {
    Response response = RestAssured.given()
            .contentType("application/json; charset=UTF-8")
            .log().all()
            .header("Cookie", "__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .body("{\n" +
                    "\t\"method\": \"PUT\",\n" +
                    "  \"id\": 1,\n  " +
                    "  \"title\": \"foo\",\n  " +
                    "  \"body\": \"bar\",\n  " +
                    "  \"userId\": 1\n}")
            .when()
            .put("https://jsonplaceholder.typicode.com/posts/1");
    return response;
  }

  public static Response deleteThePost() {
    Response response = RestAssured.given()
            .contentType("application/json")
            .log().all()
            .header("Cookie", "__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .when()
            .delete("https://jsonplaceholder.typicode.com/posts/15?accept=*/*");
    return response;
  }
}
