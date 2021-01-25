package ApiTest;

import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import postItem.methods.PostMethods;
import postItem.response.PostResponse;

import static org.hamcrest.core.IsEqual.equalTo;

public class Get {
  PostMethods postMethods = new PostMethods();
  PostResponse postResponse;

  @Test(description = "Проверка метода getAllRaw из класса PostMethods: код ответа, количество записей, ссответствие id")
  public void getAllTest() {

    Response response = postMethods.getAllRaw();
    response.then().log().all().statusCode(200)
            .body("[3].id", equalTo(4),
                    "[3].userId", equalTo(1),
                    "[3].title", equalTo("eum et est occaecati"),
                    "[3].body", equalTo("ullam et saepe reiciendis voluptatem adipisci\n" +
                            "sit amet autem assumenda provident rerum culpa\n" +
                            "quis hic commodi nesciunt rem tenetur doloremque ipsam iure\n" +
                            "quis sunt voluptatem rerum illo velit"),
                    "size()", equalTo(100));

  }

  @Test(description = "Проверка метода getByIdRaw из класса PostMethods: код ответа, соответствие полей")
  public void getByIdRawTest() {

    Response response1 = postMethods.getByIdRaw(10);
    response1.then().log().all().statusCode(200)
            .body("userId", equalTo(1),
                    "id", equalTo(10),
                    "title", equalTo("optio molestias id quia eum"),
                    "body", equalTo("quo et expedita modi cum officia vel magni\ndoloribus qui "
                            + "repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error"));

    postResponse = response1.then().extract().as(PostResponse.class);
  }

  @AfterClass
  public void AfterTests() {
    postMethods.deleteById(postResponse.id);
  }

}
