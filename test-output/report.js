$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AEMauthor.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: jaivyas@98gmail.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary : Selenium_BDD_framework"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 19,
  "name": "To Automate AEM",
  "description": "\t\nI want to use this template for my feature file",
  "id": "to-automate-aem",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2788689396,
  "status": "passed"
});
formatter.scenario({
  "line": 44,
  "name": "[AEM][ADD COMPONENT] To add and a component to a page and edit it",
  "description": "",
  "id": "to-automate-aem;[aem][add-component]-to-add-and-a-component-to-a-page-and-edit-it",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 43,
      "name": "@addingacomponentandeditingit"
    }
  ]
});
formatter.step({
  "line": 45,
  "name": "invokebrowser",
  "keyword": "Given "
});
formatter.step({
  "line": 46,
  "name": "Delete all cookies",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "intialize aem author instance in \"Testauthor\" Environment",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "enter \"Testauthor\" Credentials",
  "keyword": "When "
});
formatter.step({
  "line": 49,
  "name": "navigate to sites",
  "keyword": "Then "
});
formatter.step({
  "line": 50,
  "name": "select path \"playground\"",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "select path \"playground/autostructure\"",
  "keyword": "Then "
});
formatter.step({
  "line": 52,
  "name": "select path \"playground/autostructure/autohomepage\"",
  "keyword": "Then "
});
formatter.step({
  "line": 53,
  "name": "select thumbnail at \"playground/autostructure/autohomepage\"",
  "keyword": "Then "
});
formatter.step({
  "line": 54,
  "name": "click on coralactionbar button \"Edit\"",
  "keyword": "Then "
});
formatter.step({
  "line": 55,
  "name": "add the component \"KAW Image\" to 3",
  "keyword": "Then "
});
formatter.step({
  "line": 56,
  "name": "Select the component \"KAW Image\" and click on the desired editable toolbar option \"Configure\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AEMauthor.invokeBrowser()"
});
formatter.result({
  "duration": 9555642695,
  "status": "passed"
});
formatter.match({
  "location": "AEMauthor.delete_all_cookies()"
});
formatter.result({
  "duration": 5411267,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Testauthor",
      "offset": 34
    }
  ],
  "location": "AEMauthor.intialize_aem_author_instance(String)"
});
formatter.result({
  "duration": 10814955027,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Testauthor",
      "offset": 7
    }
  ],
  "location": "AEMauthor.enter_Credentials(String)"
});
formatter.result({
  "duration": 6763944210,
  "status": "passed"
});
formatter.match({
  "location": "AEMauthor.navigate_to_sites()"
});
formatter.result({
  "duration": 2510705245,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "playground",
      "offset": 13
    }
  ],
  "location": "AEMauthor.select_path(String)"
});
formatter.result({
  "duration": 1536352430,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "playground/autostructure",
      "offset": 13
    }
  ],
  "location": "AEMauthor.select_path(String)"
});
formatter.result({
  "duration": 1516302068,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "playground/autostructure/autohomepage",
      "offset": 13
    }
  ],
  "location": "AEMauthor.select_path(String)"
});
formatter.result({
  "duration": 1546322956,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "playground/autostructure/autohomepage",
      "offset": 21
    }
  ],
  "location": "AEMauthor.select_thumbnail_at(String)"
});
formatter.result({
  "duration": 520237565,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Edit",
      "offset": 32
    }
  ],
  "location": "AEMauthor.click_On_CoralActionBar_Button(String)"
});
formatter.result({
  "duration": 565449032,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "KAW Image",
      "offset": 19
    },
    {
      "val": "3",
      "offset": 33
    }
  ],
  "location": "AEMauthor.add_the_component(String,int)"
});
formatter.result({
  "duration": 2014798111,
  "error_message": "java.lang.IndexOutOfBoundsException: Index: 3, Size: 0\n\tat java.util.ArrayList.rangeCheck(ArrayList.java:657)\n\tat java.util.ArrayList.get(ArrayList.java:433)\n\tat stepDefinitions.AEMauthor.add_the_component(AEMauthor.java:506)\n\tat ✽.Then add the component \"KAW Image\" to 3(AEMauthor.feature:55)\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "KAW Image",
      "offset": 22
    },
    {
      "val": "Configure",
      "offset": 83
    }
  ],
  "location": "AEMauthor.click_on_the_desired_editable_toolbar_option(String,String)"
});
formatter.result({
  "status": "skipped"
});
});