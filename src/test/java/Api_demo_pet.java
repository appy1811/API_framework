import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Api_demo_pet {
    @Test
    public void Verify_postcall(){
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://petstore.swagger.io/v2/pet");
        request.header("Content-Type", "application/json");
        String body = "{\"id\":1,\"name\":\"dogs\"}";
        request.body(body);
        request.body(body.toString());
        Response response = request.post();
        Assert.assertEquals(response.statusCode(),200);
        System.out.println(response.body().asString());
        Assert.assertEquals(response.body().jsonPath().getString("id"),"1");
        Assert.assertEquals(response.body().jsonPath().getString("name"),"dogs");
        String id = response.body().jsonPath().getString("id");
        Response response0 = request.get("https://petstore.swagger.io/v2/pet"+id);
        System.out.println(response0.body().asString());
    }

    @Test
    public void Verify_PutCall(){
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://petstore.swagger.io/v2/pet");
        request.header("Content-Type", "application/json");
        String body = "{\"id\":2,\"name\":\"cats\"}";
        request.body(body);
        request.body(body.toString());
        Response response = request.put();
        Assert.assertEquals(response.statusCode(),200);
        System.out.println(response.body().asString());
        Assert.assertEquals(response.body().jsonPath().getString("id"),"2");
        Assert.assertEquals(response.body().jsonPath().getString("name"),"cats");
        String id = response.body().jsonPath().getString("id");
        Response response0 = request.get("https://petstore.swagger.io/v2/pet"+id);
        System.out.println(response0.body().asString());

    }

    @Test
    public void Verify_DltCall(){
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://petstore.swagger.io/v2/pet/1");

        Response response = request.delete();
        Assert.assertEquals(response.statusCode(),404);
        System.out.println(response.body().asString());


    }
}
