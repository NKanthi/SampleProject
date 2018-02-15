import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

public class SearchUserStepDefs {
  private String username;
  private Response usersResponseRequestResult;


  @Given("^I have a user with the username (.*)$")
  public void anUserNamed(String username) {
    this.username = username;
  }


  @Then("^then the user should have a email address$")
  public void thenTheUserShouldHaveAEmailAddress() {
    usersResponseRequestResult.then().body("find { it.username == '"+ username +"'}.email", not(equalTo(null)));
  }

  @Given("^I have a list of users$")
  public void iHaveAListOfUsers()  {

  }

  @When("^I get all the users info$")
  public void iGetAllTheUsersInfo() {
    usersResponseRequestResult = get("https://jsonplaceholder.typicode.com/users");
  }

  @Then("^there is at least one user living in (.*)")
  public void thereIsAtLeastOneUserLivingInWisokyburgh(String placeName) {
    usersResponseRequestResult.then().body("findAll { it.address.city == '"+ placeName +"'}.size()", greaterThanOrEqualTo(1));
  }

  @Then("^the users email should match (.*)$")
  public void theUsersEmailShouldMatch(String email) {
    usersResponseRequestResult.then().body("find { it.username == '"+ username +"'}.email", equalTo(email));
  }

}
