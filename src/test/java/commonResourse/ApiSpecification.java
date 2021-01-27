package commonResourse;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;


import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;

public class ApiSpecification  {

  public static TestConfig testConfig = ConfigFactory.create(TestConfig.class);
  public static String baseUrl = testConfig.baseUrl();

/* public static final String PATH_TO_PROPERTIES = "src/test/resources/config.properties";
 private final Properties prop = new Properties();*/

/*  public void init() throws IOException {

    FileInputStream fileInputStream;

    fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
    prop.load(fileInputStream);

  }*/
    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();

  public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseUrl)
            .setContentType("application/json")
            .log(LogDetail.ALL)
            .build();
  }
