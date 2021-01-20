package CommonResourse;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiSpecification {

  static ResponseSpecification responseSpec = new ResponseSpecBuilder()
          .log(LogDetail.ALL)
          .build();

  public static RequestSpecification requestSpec = new RequestSpecBuilder()
          .setBaseUri("https://jsonplaceholder.typicode.com")
          .setContentType("application/json")
          .log(LogDetail.ALL)
          .build();
}
