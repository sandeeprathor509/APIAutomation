@freenow
Feature: Verify the JSONPlace holder type code functionality


  Scenario: Test the user list
    And Get the list of users id
    And Get the "albums" of the "1" user
    Then Get the "posts" of the "2" user
    Then Get the posts with the "1" userId
    And Get the list of posts
    And Create a user with title "Automation" and body as "Test" for the user "101"
    Then Get the list of album
    And Get the list of album by userId "1"
    And Get the list of photos
    Then Filtering out the photo by using the albumId "1"
