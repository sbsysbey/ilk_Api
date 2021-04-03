package team3;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.Data;
import pojos.EmployeesExpectedPojo;
import testBase.TestBaseDummy;

import static io.restassured.RestAssured.*;

public class GetRequestPojo01 extends TestBaseDummy {

@Test
public void get01(){
        //Url
        spec03.pathParams("employeePath","employee",
        "id",1);
        //Expected
        Data data = new Data(1,"Tiger Nixon",320800,61,"");
        EmployeesExpectedPojo expectedPojo = new EmployeesExpectedPojo("success",data,"Successfully! Record has been fetched.");
        //Request gonder
        Response response =given().
        spec(spec03).
        contentType(ContentType.JSON).
        when().
        get("/{employeePath}/{id}");
        response.prettyPrint();
        //Assertion
        //JsonPath
        JsonPath json = response.jsonPath();
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(json.getString("status"),expectedPojo.getStatus());
        softAssert.assertEquals(json.getInt("data.id"),expectedPojo.getData().getId());
        softAssert.assertEquals(json.getString("data.employee_name"),expectedPojo.getData().getEmployee_name());
        softAssert.assertEquals(json.getInt("data.employee_salary"),expectedPojo.getData().getEmployee_salary());
        softAssert.assertEquals(json.getInt("data.employee_age"),expectedPojo.getData().getEmployee_age());
        softAssert.assertEquals(json.getString("data.profile_image"),expectedPojo.getData().getProfile_image());
        softAssert.assertEquals(json.getString("message"),expectedPojo.getMessage());
        softAssert.assertAll();
        }
        }