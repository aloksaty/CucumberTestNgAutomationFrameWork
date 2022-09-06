package com.alok.aut.StepDef;
import com.alok.aut.project.Util.JsonDataLoad;
import com.alok.aut.project.Util.Log;
import com.alok.aut.project.Util.MapUI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
public class BookingBus {
    @When("User login with {string} and {string}")
    public void userLoginWithAnd (String userName, String password) {
        System.out.println (userName + ": " + password);
    }
    @Given("User open the home page")
    public void userOpenTheHomePage (DataTable dataTable) {
        List<List<String>> data = dataTable.asLists ();
    }
    @Then("He should be able to login to booking application")
    public void heShouldBeAbleToLoginToBookingApplication () {
    }
    @Given(": User navigate to ticket booking page")
    public void userNavigateToTicketBookingPage (DataTable dateTable) {
        //System.out.println (doc);

        List<List<String>> data = dateTable.asLists ();
        Log.info (data.get (1).toString ());
    }
    @When("^He enter user details (.+), (.+)$")
    //@When("He enter the \"([]*)\", {int} and {char}$")
    public void heEnterUserDeatils (String countryCode, String id) {
        Log.info (countryCode + ": " + id);
        String dataFile = MapUI.jsonDataFile;
        HashMap<Object, List<JSONObject>> objectMap = JsonDataLoad.LoadData (dataFile);
        for (JSONObject jsonObject : objectMap.get (countryCode.trim ())) {
            if (jsonObject.get ("id").toString ().equals (id.trim ())) {
                Log.info (jsonObject.get ("id").toString ());
            }
        }
    }
    @When("^He enter the (.+), (.+) and (.+)$")
    public void heEnterTheNameAgeAndSex (String name, int age, String sex) {
        Log.info (name + ": " + age + " : " + sex);
    }
    @And(": click on submit button")
    public void clickOnSubmitButton () {
    }
    @Then(": He should be able to book the ticket")
    public void heShouldBeAbleToBookTheTicket () {
    }
    @When(": He enter the <name> , <age> and <sex>")
    public void heEnterTheNameAgeAndSex () {
    }
    @Given(": User navigate to flight ticket booking page")
    public void userNavigateToFlightTicketBookingPage () {
    }
    @Then(": User navigate to flight (.+) bookings page")
    public void userNavigateToFlightTicketBooking () {
    }
    @Given("^I am available on \"(.+)\"$")
    public void i_am_available_on (List<String> days) {
        System.out.println (days.size ());
    }

}
