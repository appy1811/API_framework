package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class APIStepdefs {
    Response response;
    @When("User sends {string} request with {string} endpoint")
    public void userSendsRequestWithEndpoint(String method, String endpoint) {
        RequestSpecification request = RestAssured.given();
        String BaseUri = "https://reqres.in ";
        request.contentType(ContentType.JSON);
        //Response response = request.get("https://reqres.in/api/users/2");
        if (method.equalsIgnoreCase("GET"))
            response = request.get(BaseUri+endpoint);
        else if (method.equalsIgnoreCase("POST"))
            response = request.get(BaseUri+endpoint);



    }

    @Then("User verifies the status ccode is {string}")
    public void userVerifiesTheStatusCcodeIs(int status_code) {
        Assert.assertEquals(response.statusCode(),status_code);

    }

    @And("User verifies the response contains following details")
    public void userVerifiesTheResponseContainsFollowingDetails(DataTable table) {
        Assert.assertEquals(response.body().jsonPath().getString("data"+table.cell(0,0)),table.cell(1,0));
        Assert.assertEquals(response.body().jsonPath().getString("data"+table.cell(0,1)),table.cell(1,1));
        Assert.assertEquals(response.body().jsonPath().getString("data"+table.cell(0,2)),table.cell(1,2));
        Assert.assertEquals(response.body().jsonPath().getString("data"+table.cell(0,3)),table.cell(1,3));
    }
}
