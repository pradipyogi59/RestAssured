package Learning;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Tutorial01_SimpleGetReq {
    public static void main(String[] args) {

        RestAssured.baseURI="http://restapi.demoqa.com";
        SimpleTwo();


        /*
        *Given (I have this details with my base url)
        *Req. Header
        * Req. Parameter
        * Cookie
        * body(for post req.)
        *
        * When
        *
        * get(resource)
        * post(resource)
        *
        *
        * Then
        *
        * assertion to check response
        *
        * Extract
        *
        * Pull out body response
         */

    }

    public static void simpleOne(){
        Response res=given().get("/utilities/weather/city/Ahmedabad").then().extract().response();
        System.out.println(res.asString());
    }

    public static void SimpleTwo(){
        Response res=given().pathParam("city","Ahmedabad").log().all().get("/utilities/weather/city/{city}").then().extract().response();
    }
}
