package postItem.methods;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostMethods {
  public static Response getPost(){
    given().when().post();
    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/15")
            .header("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
            .header("Content-Type", "application/javascript; charset=UTF-8")
            .header("Cookie", "__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .body("")
            .asString();
    return response;
  }
  public static Response getPosts() {
    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts")
            .header("Cookie", "__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .body("")
            .asString();
    return response;
  }
  public static Response PostRequest() {
    Response response = RestAssured.post("https://jsonplaceholder.typicode.com/posts")
            .header("Content-Type", "application/json")
            .header("Cookie", "__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .body("{\n\t\"method\": \"POST\",\n    \"title\": \"fooo 556dhdd\",\n    \"body\": \"barscdcd44jjhhjffd\",\n    \"userId\": 1\n}")
            .asString();
    return response;
  }
  public static Response Put() {
    Response response = RestAssured.put("https://jsonplaceholder.typicode.com/posts/1")
            .header("Content-Type", "application/json; charset=UTF-8")
            .header("Cookie", "__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .body("{\n\t\"method\": \"PUT\",\n    \"id\": 1,\n    \"title\": \"foo\",\n    \"body\": \"bar\",\n    \"userId\": 1\n}")
            .asString();
    return response;
  }
  public static Response deletePost() {
    Response response = RestAssured.delete("https://jsonplaceholder.typicode.com/posts/15?accept=*/*")
            .header("Content-Type", "application/json")
            .header("Cookie", "__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .body("{\n\t\"method\": \"DELETE\"\n}")
            .asString();
    return response;
  }
}
