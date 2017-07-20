Feature: Adding ToDos
  As an organized person,
  I should be able to add items to my todo list,
  So that I remember to complete my things I plan to do.

  Scenario: Add item to empty list
    Given that Matt has an empty todo list
    When he adds 'Create test framework' to his list
    Then 'Create test framework' should be recorded in his list

  Scenario: Add item to a populated list
    Given that Bella has a todo list containing Front-end dev, Refactor code
    When she adds 'Back-end dev' to her list
    Then her todo list should contain Front-end dev, Refactor code, Back-end dev

  Scenario: Add items to multiple populated lists
    Given that Matt has a todo list containing Walk dog, Feed dog
    And that Bella has a todo list containing Pet cat, Feed cat
    When she adds 'Play with cat' to her list
    Then Matt's todo list should contain Walk dog, Feed dog
    And Bella's todo list should contain Pet cat, Feed cat, Play with cat
