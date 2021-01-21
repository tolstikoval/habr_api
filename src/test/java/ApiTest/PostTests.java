package ApiTest;

import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import postItem.methods.PostMethods;
import postItem.response.PostResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class PostTests {
  PostMethods postMethods = new PostMethods();
  PostResponse postResponse;

  @BeforeClass
  public void testData() {

  }

Long i=1l;
  @Test
  @Description("Проверка метода getByIdRaw из класса PostMethods: код ответа, соответствие полей")
  public void getByIdRawTest() {

    Response response = postMethods.getAllRaw();
    response.then().log().all().statusCode(200)
    .body("[3].id", equalTo(4));

    PostResponse[] listPost = postMethods.getAll();

    //postResponse = response.then().extract().as(PostResponse.class);

   /* Response response1 = postMethods.getByIdRaw(10);
    response.then().log().all().statusCode(200)
            .body("userId", equalTo(1),
                    "id", equalTo(10),
                    "title", equalTo("optio molestias id quia eum"),
                    "body", equalTo("quo et expedita modi cum officia vel magni\ndoloribus qui "
                            + "repudiandae\nvero nisi sit\nquos veniam quod sed accusamus veritatis error"));

    postResponse = response1.then().extract().as(PostResponse.class);*/
  }

  @AfterTest
  public void someName() {
    //postMethods.deleteById(postResponse.id);
  }
}
