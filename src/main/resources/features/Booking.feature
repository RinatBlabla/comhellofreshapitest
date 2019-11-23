# language: en

@Regress
Feature: Booking

  @Positive
  Scenario: Test that at least 2 existing bookings are returned in the response
     Given user send "GET" http request to the endpoint "booking/"
     Then response is received with status code "200"
     And response amount of bookings is more than "2"

  @Positive
  Scenario: Test that the data returned for an existing booking matches
     Given user send "GET" http request to the endpoint "booking/"
     Then response is received with status code "200"
     And response amount of bookings is more than "2"
     Then put the first booking from http response to test context under the name: "booking"
     Given user send "GET" http request to the endpoint "booking/{text context: booking.id}"
     Then response is received with status code "200"
     And response body of getBooking corresponds to the value from test context value of: "booking"

  @Positive @Test
  Scenario: Test that bookings can be created
     Given user send "GET" http request to the endpoint "booking/"
     Then response is received with status code "200"
     And response amount of bookings is more than "2"
     Then put the first booking from http response to test context under the name: "booking"
     Given user send "DELETE" http request to the endpoint "booking/{text context: booking.id}"
     Then response is received with status code "200"
     Given user send "GET" http request to the endpoint "booking/{text context: booking.id}"
     Then response is received with status code "404"
#     Given user prepare http request body with booking json values:
#     | bookingdates.checkin  | {test context: booking.checkin}     |
#     | bookingdates.checkout | {test context: booking.checkout}    |
#     | bookingid             | {test context: booking.bookingid}   |
#     | depositpaid           | {test context: booking.depositpaid} |
#     | email                 | string@wqe.we                       |
#     | firstname             | {test context: booking.firstname}   |
#     | lastname              | {test context: booking.lastname}    |
#     | phone                 | 12345678901                         |
#     | roomid                | {test context: booking.roomid}      |
#     And user send "POST" http request with parameters to the endpoint "booking/{text context: booking.id}"
#     | body   |     | {test context: booking}     |
#     Then response is received with status code "200"
#     Given user send "GET" http request to the endpoint "booking/{text context: booking.id}"
#     Then response is received with status code "200"
