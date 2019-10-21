package Learning;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static io.restassured.module.kotlin.extensions.RestAssuredKotlinExtensionsKt.Given;

public class Tutorial05_PostwithOuth2 {
    public static void main(String[] args) {

        JSONObject requestParams = new JSONObject();
        requestParams.put("email","pradip@two.com");
        requestParams.put("first_name","pradip2");
        requestParams.put("last_name","yogi2");
        requestParams.put("gender","male");
        // Store Data in Json


        RestAssured.baseURI="https://gorest.co.in";


                Response res=given()
                        .auth()
                        .oauth2("Ph_Uqh5jI62ACbljOkgA0Oboq7UAnCejDL7C")
                        .header("Content-Type","application/json")
                        .body(requestParams)
                        .when()
                        .post("/public-api/users").then().extract().response();

        System.out.println(res.asString());



    }
}
