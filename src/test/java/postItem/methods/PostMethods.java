package postItem.methods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import CommonResourse.ApiSpecification;
import CommonResourse.EndPoints;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import postItem.request.PostRequest;
import postItem.response.PostResponse;

import java.util.Arrays;


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
            .when().log().all()
            .get(EndPoints.POSTS);
    return response;
  }

  public PostResponse[] getAll() {
    Response response = getAllRaw();
    PostResponse[] listPostResponse = response.then()
            .extract().as(PostResponse[].class);
    return listPostResponse;
  }

  public PostResponse getObject(long id) {
/*    PostResponse[] listPost = getAllRaw().as(PostResponse[].class);
     Response response = getAllRaw();
    PostResponse p = Arrays.stream(listPost).filter(post -> id == (post.getId())).findFirst().orElse(null);*/
    // Arrays.stream(listPost).find//findFirst({ it.id == " + id + "});
    // PostResponse [] listPost = response.then().log().all().extract().jsonPath().getJsonObject("find { it.id == " + id + "}");
    //.then().log().all().extract().jsonPath().get("findAll {it.id == " + id + "}");
    //.then().log().all().extract().response().body().path("[id].first");
    //.path("find { it.id == 'id'}");
    Response response = getAllRaw();
    PostResponse p = response.then().extract().path("[0]");
    PostResponse p1 = response.then().extract().path("find {it.id == " + id + "}");
    return p1;
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
