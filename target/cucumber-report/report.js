$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/Booking.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: en"
    }
  ],
  "line": 4,
  "name": "Booking",
  "description": "",
  "id": "booking",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@Regress"
    }
  ]
});
formatter.scenario({
  "line": 23,
  "name": "Test that bookings can be created",
  "description": "",
  "id": "booking;test-that-bookings-can-be-created",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@Positive"
    },
    {
      "line": 22,
      "name": "@Test"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "user send \"GET\" http request to the endpoint \"booking/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "response is received with status code \"200\"",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "response amount of bookings is more than \"2\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "put the first booking from http response to test context under the name: \"booking\"",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "user send \"DELETE\" http request to the endpoint \"booking/{text context: booking.id}\"",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "response is received with status code \"200\"",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "user send \"GET\" http request to the endpoint \"booking/{text context: booking.id}\"",
  "keyword": "Given "
});
formatter.step({
  "line": 31,
  "name": "response is received with status code \"404\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 11
    },
    {
      "val": "booking/",
      "offset": 46
    }
  ],
  "location": "BookingSteps.sendHttpReq(String,String)"
});
formatter.result({
  "duration": 999740160,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 39
    }
  ],
  "location": "BookingSteps.checkResponseStatusCode(String)"
});
formatter.result({
  "duration": 2180264,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 42
    }
  ],
  "location": "BookingSteps.checkResponseBookingAmountIsMore(String)"
});
formatter.result({
  "duration": 12284998,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "booking",
      "offset": 74
    }
  ],
  "location": "BookingSteps.putFirstBookingToTestContext(String)"
});
formatter.result({
  "duration": 2458450,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DELETE",
      "offset": 11
    },
    {
      "val": "booking/{text context: booking.id}",
      "offset": 49
    }
  ],
  "location": "BookingSteps.sendHttpReq(String,String)"
});
formatter.result({
  "duration": 185426536,
  "error_message": "cucumber.runtime.CucumberException: No response was received\r\n\tat steps.BookingSteps.sendHttpReq(BookingSteps.java:47)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:115)\r\n\tat org.junit.runner.JUnitCore.runMain(JUnitCore.java:77)\r\n\tat org.junit.runner.JUnitCore.main(JUnitCore.java:36)\r\n\tat launcher.Launcher.main(Launcher.java:22)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 39
    }
  ],
  "location": "BookingSteps.checkResponseStatusCode(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 11
    },
    {
      "val": "booking/{text context: booking.id}",
      "offset": 46
    }
  ],
  "location": "BookingSteps.sendHttpReq(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 39
    }
  ],
  "location": "BookingSteps.checkResponseStatusCode(String)"
});
formatter.result({
  "status": "skipped"
});
});