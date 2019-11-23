package steps;

import client.HttpSpringClient;
import constants.ChangeValues;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runtime.CucumberException;
import enums.HttpParameterLocationEnum;
import enums.TestContextKeyEnum;
import objects.Booking;
import objects.Bookings;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import utils.TestContext;
import utils.Utils;
import java.util.List;

/**
 * Created by Rinat on 22.11.2019.
 */
public class BookingSteps {

    private static Logger log = LoggerFactory.getLogger(BookingSteps.class);

    @Given("^user send \"([^\"]*)\" http request to the endpoint \"([^\"]*)\"$")
    public void sendHttpReq(String httpMethod, String endpoint) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        log.debug("HTTP request: " + entity.getHeaders());
        if (endpoint.contains(ChangeValues.BOOKING_ID)){
            Booking booking = TestContext.get(TestContextKeyEnum.booking.name());
            endpoint = endpoint.replace(ChangeValues.BOOKING_ID, booking.getBookingid()+"");
        }
        ResponseEntity<String> response = HttpSpringClient
                .sendHttpRequest(
                        HttpSpringClient.getUri(endpoint),
                        HttpMethod.valueOf(httpMethod),
                        entity,
                        String.class);
        if(response == null){
            throw new CucumberException("No response was received");
        }
        TestContext.put(TestContextKeyEnum.responseStatus.name(), response.getStatusCodeValue());
        if(response.getStatusCode().equals(HttpStatus.OK)) {
            TestContext.put(TestContextKeyEnum.reponseBody.name(), response.getBody());
        }
    }

    @Given("^user send \"([^\"]*)\" http request with parameters to the endpoint \"([^\"]*)\"$")
    public void sendHttpReqWithParameters(String httpMethod, String endpoint, DataTable inputTable) {
        List<List<String>> list = inputTable.raw();
        log.info("data table: " + list);
        HttpHeaders headers = new HttpHeaders();
        String value = "";
        for(List<String> params: list) {

            if (params.get(0).equals(HttpParameterLocationEnum.body.name())) {
                value = params.get(2);
            }
        }
        HttpEntity entity = new HttpEntity(headers);
        if(!value.equals("")) {
            entity = new HttpEntity(value, headers);
        }
        log.debug("HTTP request: " + entity.getHeaders());
        ResponseEntity<String> response = HttpSpringClient
                .sendHttpRequest(
                        HttpSpringClient.getUri(endpoint),
                        HttpMethod.valueOf(httpMethod),
                        entity,
                        String.class);
        if(response == null){
            throw new CucumberException("No response was received");
        }
        TestContext.put(TestContextKeyEnum.responseStatus.name(), response.getStatusCodeValue());
        if(response.getStatusCode().equals(HttpStatus.OK)) {
            TestContext.put(TestContextKeyEnum.reponseBody.name(), response.getBody());
        }
    }

    @Then("^response is received with status code \"([^\"]*)\"$")
    public void checkResponseStatusCode(String statusCode){
        Assert.assertNotNull("Http response code is absent in Text context"
                , TestContext.get(TestContextKeyEnum.responseStatus.name()));
        int responseCode = TestContext.get(TestContextKeyEnum.responseStatus.name());
        log.debug("Response code: " + responseCode);
        Assert.assertTrue("Response code is different from the entered one",
                responseCode == Integer.valueOf(statusCode));
    }

    @And("^response amount of bookings is more than \"([^\"]*)\"$")
    public void checkResponseBookingAmountIsMore(String input){
        int amount = Integer.valueOf(input);
        Assert.assertNotNull("Http response body is absent in Text context"
                ,TestContext.get(TestContextKeyEnum.reponseBody.name()));
        Bookings bookings = Utils.convertJSONtoObject(TestContext.get(TestContextKeyEnum.reponseBody.name()),Bookings.class);
        Assert.assertTrue("Response amount of bookings is not more than " + amount,
                bookings.getBookings().size() > amount);
    }

    @And("^response amount of bookings is equal to \"([^\"]*)\"$")
    public void checkResponseBookingAmountIsEqual(String input){
        int amount = Integer.valueOf(input);
        Assert.assertNotNull("Http response body is absent in Text context"
                ,TestContext.get(TestContextKeyEnum.reponseBody.name()));
        Bookings bookings = Utils.convertJSONtoObject(TestContext.get(TestContextKeyEnum.reponseBody.name()),Bookings.class);
        Assert.assertTrue("Response amount of bookings is not equal to " + amount,
                bookings.getBookings().size() == amount);
    }

    @And("^response amount of bookings is not equal to \"([^\"]*)\"$")
    public void checkResponseBookingAmountIsNotEqual(String input){
        int amount = Integer.valueOf(input);
        Assert.assertNotNull("Http response body is absent in Text context"
                ,TestContext.get(TestContextKeyEnum.reponseBody.name()));
        Bookings bookings = Utils.convertJSONtoObject(TestContext.get(TestContextKeyEnum.reponseBody.name()),Bookings.class);
        Assert.assertTrue("Response amount of bookings is equal to " + amount,
                bookings.getBookings().size() != amount);
    }

    @Then("^put the first booking from http response to test context under the name: \"([^\"]*)\"$")
    public void putFirstBookingToTestContext(String name){
        Assert.assertNotNull("Http response body is absent in Text context"
                ,TestContext.get(TestContextKeyEnum.reponseBody.name()));
        Bookings bookings = Utils.convertJSONtoObject(TestContext.get(TestContextKeyEnum.reponseBody.name()),Bookings.class);
        Assert.assertTrue("Amount of bookings is zero",bookings.getBookings().size() != 0);
        TestContext.put(name, bookings.getBookings().get(0));
    }

    @Then("^response body of getBooking corresponds to the value from test context value of: \"([^\"]*)\"$")
    public void checkResponseBodyValue(String key){
        Assert.assertNotNull("Http response body is absent in Text context"
                ,TestContext.get(TestContextKeyEnum.reponseBody.name()));
        Assert.assertNotNull("Value of "+key+" is absent in Text context"
                ,TestContext.get(key).toString());
        Booking booking = TestContext.get(key);
        Booking responseBooking = Utils.convertJSONtoObject(TestContext.get(TestContextKeyEnum.reponseBody.name()),
                Booking.class);
        log.debug("booking: "+ booking.toString() + "; responseBooking: " + responseBooking.toString());
        Assert.assertTrue("Booking from text context is not equal to booking from the response body",
                booking.equals(responseBooking));
    }
}
