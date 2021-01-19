package postItem.methods;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import postItem.request.PostRequest;
import postItem.response.PostResponse;


public class PostMethods {
/*  public PostMethods Spec() {

    ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString("success"))
            .build();

    RestAssured.responseSpecification = responseSpec;
    static RequestSpecification yourSpec = new RequestSpecBuilder()
            .setBaseUri()
            .setPort()
            .setAccept()
            .setContentType()
            .addHeader()
            .build()
  }
  */

  public static final String YOUR_POINT_ID = "https://jsonplaceholder.typicode.com/posts/{id}";

  public Response getByIdRaw(long id) {
    Response response = given()
            .contentType("application/json")
            .header("Accept-Language", "ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
            .cookie("__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .when()
            .log().all()
            .get(YOUR_POINT_ID, id);
    return response;
  }

public ValidatableResponse getById(long id) {
    Response response = getByIdRaw(id);
    ValidatableResponse validatableResponse = response.then()
            .log().all().statusCode(200);
    return validatableResponse;
}

  public Response getAllRaw() {
    Response response = given()
            .contentType("application/json")
            .cookie("__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .when()
            .log().all()
            .get("https://jsonplaceholder.typicode.com/posts");
    return response;
  }

  public ValidatableResponse getAll() {
    Response response = getAllRaw();
    ValidatableResponse validatableResponse = response.then()
            .log().all().statusCode(200);
    return validatableResponse;
  }

  public Response postRaw(PostRequest postRequest) {
    Response response = given()
            .contentType("application/json")
            .cookie("__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .body(postRequest)
            .when()
            .log().all()
            .post("https://jsonplaceholder.typicode.com/posts");
    return response;
  }

  public PostResponse post(PostRequest postRequest) {
    Response response = postRaw(postRequest);
    PostResponse postResponse= response.then()
            .log().all().statusCode(201);
    return postResponse;
  }

  public Response putRaw() {
    Response response = given()
            .contentType("application/json; charset=UTF-8")
            .cookie("__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .body("{\n" +
                    "\t\"method\": \"PUT\",\n" +
                    "  \"id\": 1,\n  " +
                    "  \"title\": \"foo\",\n  " +
                    "  \"body\": \"bar\",\n  " +
                    "  \"userId\": 1\n}")
            .when()
            .log().all()
            .put("https://jsonplaceholder.typicode.com/posts/1");
    return response;
  }

  public ValidatableResponse put() {
    Response response = putRaw();
    ValidatableResponse validatableResponse = response.then()
            .log().all().statusCode(200);
    return validatableResponse;
  }
//Request URI:	https://jsonplaceholder.typicode.com/posts/15?accept=*%2F*
  public Response deleteRaw() {
    Response response = given()
            .contentType("application/json")
            .cookie("__cfduid=d251dc7412395e651ea7e6d6139bdaaf91610459685")
            .when()
            .log().all()
            .delete("https://jsonplaceholder.typicode.com/posts/15");
    return response;
  }

  public ValidatableResponse delete() {
    Response response = deleteRaw();
    ValidatableResponse validatableResponse = response.then()
            .log().all().statusCode(200);
    return validatableResponse;
  }
}
