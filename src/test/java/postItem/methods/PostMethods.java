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
            .get(EndPoints.POSTS);
    return response;
  }

  //�� ��������
  public PostResponse getAll() {
    Response response = getAllRaw();
    PostResponse postResponse = response.then()
            .extract().as(PostResponse.class);
    ;
    return postResponse;
  }

  public Response postRaw(PostRequest postRequest) {
    Response response = given()
            .spec(ApiSpecification.requestSpec)
            .body(postRequest)
            .when()
            .post(EndPoints.POSTS);
    return response;
  }

  public PostResponse post(PostRequest postRequest) {
    Response response = postRaw(postRequest);
    PostResponse postResponse = response.then()
            .extract().as(PostResponse.class);
    return postResponse;
  }

  public Response putByIdRaw(PostRequest postRequest, long id) {
    Response response = given()
            .spec(ApiSpecification.requestSpec)
            .body(postRequest)
            .when()
            .put(EndPoints.POSTS_ID, id);
    return response;
  }

  public PostResponse putById(PostRequest postRequest, long id) {
    Response response = putByIdRaw(postRequest, id);
    PostResponse postResponse = response.then().log().all()
            .extract().as(PostResponse.class);
    return postResponse;
  }

  public Response deleteByIdRaw(long id) {
    Response response = given()
            .spec(ApiSpecification.requestSpec)
            .when()
            .delete(EndPoints.POSTS_ID, id);
    return response;
  }

  public ValidatableResponse deleteById(long id) {
    Response response = deleteByIdRaw(id);
    ValidatableResponse validatableResponse = response.then()
            .statusCode(200);
    return validatableResponse;
  }
}
