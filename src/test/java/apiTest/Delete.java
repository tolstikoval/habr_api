package apiTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import postItem.response.PostResponse;

public class Delete extends TestBase {

  @Test(description = "Проверка метода deleteByIdRaw из класса PostMethods: код ответа")
  public void deleteByIdTest () {
    Response response = postMethods.deleteByIdRaw(5);
    response.then().log().all().statusCode(200);
    postResponse = response.then().extract().as(PostResponse.class);
  }
}
