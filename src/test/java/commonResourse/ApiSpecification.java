package commonResourse;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;

public class ApiSpecification  {

  //public static void init() {
/*    final Properties properties;
    properties = new Properties();
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/$s.properties", target))));*/

 // }
 public static final String PATH_TO_PROPERTIES = "src/test/resources/config.properties";
 public static Properties prop = new Properties();

  public static void init() throws IOException {

    FileInputStream fileInputStream;

    fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
    prop.load(fileInputStream);

  }
    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();

  public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(prop.getProperty("web.baseUrl"))
            .setContentType("application/json")
            .log(LogDetail.ALL)
            .build();
  }
