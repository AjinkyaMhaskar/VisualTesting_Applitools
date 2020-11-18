$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Test.feature");
formatter.feature({
  "line": 1,
  "name": "Test login functionality",
  "description": "",
  "id": "test-login-functionality",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Verification user login",
  "description": "",
  "id": "test-login-functionality;verification-user-login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Open the Firefox and launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User navigates to Login Page",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Enter the Username and Password",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User logged-in successfully in his/her account",
  "keyword": "Then "
});
formatter.match({
  "location": "test.open_the_Firefox_and_launch_the_application()"
});
formatter.result({
  "duration": 10163226600,
  "status": "passed"
});
formatter.match({
  "location": "test.user_navigates_to_Login_Page()"
});
formatter.result({
  "duration": 2459920700,
  "status": "passed"
});
formatter.match({
  "location": "test.enter_the_Username_and_Password()"
});
formatter.result({
  "duration": 1819200200,
  "status": "passed"
});
formatter.match({
  "location": "test.success_message_is_displayed()"
});
formatter.result({
  "duration": 1204727700,
  "status": "passed"
});
