package RestTest;


import com.google.gson.Gson;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredTest {


    @Test
    public void getSms() {
        String response = given()
                .parameters("loginName", "Test1")
                .when()
                .get("http://sm-svc-dev-dbo:8081/api/sms/test")
                .then()
                .statusCode(200)
                .defaultParser(Parser.JSON)
                .log()
                .all().extract().path("code").toString();

        System.out.println(response);
        Gson parser = new Gson();
        HashMap list = parser.fromJson(response, HashMap.class);
        Object map = list.get(0);
        System.out.println(map);
    }

    @Test
    public void getNews() {
        Response response = given()
                .parameters("title","string","description","string","pubDate","2019-08-26T07:13:53.722Z","link","string")
                .contentType("application/json")
                .when()
                .get("http://10.10.111.79:1213/api/v1/news")
                .then()
                .statusCode(200)
                .defaultParser(Parser.JSON)
                .log()
                .all().extract().response();
    }

    @Test
    public void postChangePassword() {

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("login", "Eev");
        jsonAsMap.put("password", "1");

        String response = given().
                        accept(ContentType.JSON).
                        contentType(ContentType.JSON)
                .body(jsonAsMap)
                .contentType("application/json")
                        .post("https://sm-web2-dev:97/api/v1/Token")
                        .then().log().headers().extract().response().path("Authorization");

        System.out.println(response);

            Map<String, Object> jsonAsMap1 = new HashMap<>();
            jsonAsMap1.put("login", "Eev");
            jsonAsMap1.put("password", "1");
            jsonAsMap1.put("confirmPassword","1");


                given().baseUri("https://sm-web2-dev:97/api/v1/Token").auth().basic("Eev","1").
                    accept(ContentType.JSON).
                    contentType(ContentType.JSON)
                    .header("Authorization",response)
                    .body(jsonAsMap1)
                    .contentType("application/json")
                    .post("https://sm-web2-dev:97/api/v1/Token/changePassword")
                    .then().statusCode(200).log()
                    .body();
        }

    @Test
    public void postAutorization() {

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("login", "Eev");
        jsonAsMap.put("password", "1");

        String response = given().
                accept(ContentType.JSON).
                contentType(ContentType.JSON)
                .body(jsonAsMap)
                .contentType("application/json")
                .post("https://sm-web2-dev:97/api/v1/Token")
                .then().statusCode(200).log()
                .body().extract().response().path("token").toString();

        System.out.println(response);}

    }





