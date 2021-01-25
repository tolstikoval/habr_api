package ApiTest;

import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import postItem.response.PostResponse;

import static org.hamcrest.core.IsEqual.equalTo;

public class Put extends TestBase{


  @Test(description = "Проверка метода PutByIdRaw из класса PostMethods: код ответа, соответствие полей")
  public void putByIdTest() {
    Response response = postMethods.putByIdRaw(postRequest1, 5);
    response.then().log().all().statusCode(200)
            .body("userId", equalTo(12),
                    "id", equalTo(5),
                    "title", equalTo("123"),
                    "body", equalTo("123432"));
    postResponse = response.then().extract().as(PostResponse.class);
  }

  @AfterClass
  public void AfterTests() {
    postMethods.deleteById(postResponse.id);
  }
}
