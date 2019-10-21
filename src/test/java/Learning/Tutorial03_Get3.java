package Learning;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Tutorial03_Get3 {
    public static void main(String[] args) {

        RestAssured.baseURI="https://calendarific.com";

        Response res=given().
                queryParams("api_key","09f63decd5a0fb53abf41ca0ba77ab4cf50b9de5").
                param("country","in").param("year","2019").

                log().all().

                when().
                get("/api/v2/holidays").
                then().body("response.holidays[0].date.datetime.year",equalTo(2019)).and().extract().response();
                //inside boy there is json traverse

        System.out.println(res.getBody().asString());


        Headers allHeaders = res.getHeaders();
        List<Header> hear= allHeaders.asList();
        for(Header f:hear){
            System.out.println("Header is :"+f.getName()+ "and value is "+f.getValue());
        }
    }
}
