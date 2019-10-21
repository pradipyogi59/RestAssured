package Learning;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Tutorial04_Get4 {
    public static void main(String[] args) {
        RestAssured.baseURI="https://gorest.co.in";

        given().
                // param("access-token","Ph_Uqh5jI62ACbljOkgA0Oboq7UAnCejDL7C").
                        queryParam("access-token","Ph_Uqh5jI62ACbljOkgA0Oboq7UAnCejDL7C").
                when().
                get("public-api/posts").
                then().
                assertThat().
                statusCode(200).
                and().
                //contentType("application/json");
                        contentType(ContentType.JSON).
                and().
                body("result[0].user_id",equalTo("680"));
    }
}

 /*
    * BaseUrl:

given()

Req. Header
Parameter
Req. cookie

when()

get(resource)
post(resource)
put(resource)


then()

here we get response
use assertion to check

extract()

pull out body req.



//After ? all values are parameter
    * */


/**
 *In json
 *
 * After Object name [] is array
 * like result[] then result is array
 * {} is 0index then id2 is 1st index
 *
 * "result": [
 *         {
 *             "id": "1",
 *             "user_id": "680",
 *             "title": "A vel commodi inventore occaecati enim. Atque corrupti quaerat et sit ut.",
 *
 *
 *         },
 *         {
 *             "id": "2",
 *             "user_id": "1047",
 *             "title": "Esse quas harum sed voluptatem autem cumque quidem. Tempora tenetur aut voluptatem ducimus modi.",
 *
 *         }
 */



