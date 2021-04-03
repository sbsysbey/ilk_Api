package team3;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBaseJsonPlaceHolder;
import testData.JsonPlaceHolderTestData;
import utilities.JSonUtil;

import java.util.Map;

import static io.restassured.RestAssured.*;
public class GetRequestJson01 extends TestBaseJsonPlaceHolder {
    /*
                      1)When I send a GET request to REST API URL
                  https://jsonplaceholder.typicode.com/todos/123
                   Then HTTP Status Code should be 200
                   And "Server" in Headers should be "cloudflare"
                   And response content type is "application/JSON"
                   And "userId" should be 7,
                   And "title" should be "esse et quis iste est earum aut impedit"
                  And "completed" should be false
    */
    @Test
    public void get01(){
        //Url
        spec01.pathParams("todosPath","todos","id",123);
        //Expected Data
        JsonPlaceHolderTestData expectedObj=new JsonPlaceHolderTestData();
        Map<String,Object> expectedDataMap=expectedObj.setUpDataMap();
        System.out.println(expectedDataMap);
        //Request
        Response response=given().
                spec(spec01).
                contentType(ContentType.JSON).
                when().
                get("/{todosPath}/{id}");
        // response.prettyPrint();
        //Assertion
        //1.yol Jsonpath
        JsonPath json=response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),expectedDataMap.get("Status Code"));
        softAssert.assertEquals(response.header("Server"),expectedDataMap.get("Server"));
        softAssert.assertEquals(json.getInt("id"),expectedDataMap.get("id"));
        softAssert.assertEquals(json.getBoolean("completed"),expectedDataMap.get("completed"));
        softAssert.assertEquals(json.getString("title"),expectedDataMap.get("title"));
        softAssert.assertEquals(json.getInt("userId"),expectedDataMap.get("userId"));
        softAssert.assertAll();
    }
    //ObjectMapper
    @Test
    public void get02(){
        //Url
        spec01.pathParams("todosPath","todos","id",123);
        //Expected data
        JsonPlaceHolderTestData expectedObj=new JsonPlaceHolderTestData();
        Map<String,Object> expectedMap = JSonUtil.convertJsonToJava(expectedObj.setUpObjectMapper(),Map.class);
        System.out.println(expectedMap);
        //Request Gonder
        Response response=given().
                spec(spec01).
                contentType(ContentType.JSON).
                when().
                get("/{todosPath}/{id}");
        //Assert
        Map<String,Object> actualDataMap =JSonUtil.convertJsonToJava(response.asString(),Map.class);
        System.out.println(actualDataMap);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),expectedMap.get("Status Code"));
        softAssert.assertEquals(response.header("Server"),expectedMap.get("Server"));
        softAssert.assertEquals(actualDataMap.get("userId"),expectedMap.get("userId"));
        softAssert.assertEquals(actualDataMap.get("id"),expectedMap.get("id"));
        softAssert.assertEquals(actualDataMap.get("title"),expectedMap.get("title"));
        softAssert.assertEquals(actualDataMap.get("completed"),expectedMap.get("completed"));
        softAssert.assertAll();
    }  }