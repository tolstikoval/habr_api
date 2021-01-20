package postItem.methods;

import static io.restassured.RestAssured.given;

import CommonResourse.ApiSpecification;
import CommonResourse.EndPoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import postItem.request.PostRequest;
import postItem.response.PostResponse;


public class PostMethods {

  public Response getByIdRaw(long id) {
    Response response = given()
            .spec(ApiSpecification.requestSpec)
            .when()
            .log().all()
            .get(EndPoints.POSTS_ID, id);
    return response;
  }

  public PostResponse getById(long id) {
    Response response = getByIdRaw(id);
    PostResponse postResponse = response.then().log().all()
            .extract().as(PostResponse.class);
    return postResponse;
  }

  public Response getAllRaw() {
    Response response = given()
            .spec(ApiSpecification.requestSpec)
            .when()
            .log().all()
            .get(EndPoints.POSTS);
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
            .spec(ApiSpecification.requestSpec)
            .body(postRequest)
            .when()
            .log().all()
            .post(EndPoints.POSTS);
    return response;
  }

    public PostRequest post(PostRequest postRequest) {
    Response response = postRaw(postRequest);
    PostRequest postResponse = response.then()
            .extract().response().as(PostRequest.class);
    return postResponse;
  }

  public Response putByIdRaw(PostRequest postRequest, long id) {
    Response response = given()
            .spec(ApiSpecification.requestSpec)
            .body(postRequest)
            .when()
            .log().all()
            .put(EndPoints.POSTS_ID, id);
    return response;
  }

  public ValidatableResponse put(PostRequest postRequest, long id) {
    Response response = putByIdRaw(postRequest, id);
    ValidatableResponse validatableResponse = response.then()
            .log().all().statusCode(200);
    return validatableResponse;
  }

  public Response deleteByIdRaw(long id) {
    Response response = given()
            .spec(ApiSpecification.requestSpec)
            .when()
            .log().all()
            .delete(EndPoints.POSTS_ID, id);
    return response;
  }

  public ValidatableResponse deleteById(long id) {
    Response response = deleteByIdRaw(id);
    ValidatableResponse validatableResponse = response.then()
            .log().all().statusCode(200);
    return validatableResponse;
  }
}
