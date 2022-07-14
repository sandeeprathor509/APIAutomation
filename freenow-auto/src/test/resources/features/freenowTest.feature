@freenow
Feature: Verify the JSONPlace holder type code functionality

  Scenario: Validate the users functionality
    And Get the list of users id
    And Get the "albums" of the "1" user
    Then Get the "posts" of the "2" user
    
  Scenario: Validate the post functionality
    Given Get the list of posts
    Then Get the posts with the "1" userId
    And Create a user with title "Automation" and body as "Test" for the user "101"
    
  Scenario: Validate the album functionality
    Given Get the list of album
    And Get the list of album by userId "1"
    
  Scenario: Validate the photos functionality
    Given Get the list of photos
    Then Filtering out the photo by using the albumId "1"

  Scenario: Validate the comment for some user's posts
    Given Search for the user "Samantha" and save the details
    Then Search the post with the searched userId and save the postId
    And Search for the saved user email using postId
