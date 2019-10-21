package Learning;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Tutorial02_Get2 {
    public static void main(String[] args) {

        RestAssured.baseURI="https://gorest.co.in/";

       Response rse= given().queryParam("access-token","Ph_Uqh5jI62ACbljOkgA0Oboq7UAnCejDL7C").get("/public-api/users").then().extract().response();
       //pass access token as a query parameter

        System.out.println(rse.asString());


        /**
         *
         * Multiple parameters : given.Param("","").Param("","").when
         */


    }
}
