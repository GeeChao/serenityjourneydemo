Feature: Demo feature
  As an automation tester,
  I should be able to use the screenplay pattern,
  So that I create more legible and robust tests.

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

  Scenario: Complete an item
    Given that Matt has a todo list containing Buy milk, Buy cereal
    When she completes the task called 'Buy milk'
    And he filters his list to show only Completed tasks
    Then his todo list should contain Buy milk

  Scenario Outline: Viewing items **by status**
    Given that <Actor> has a todo list containing <Tasks>
    And he completes the task called '<Complete>'
    When he filters his list to show only <Filter> tasks
    Then his todo list should contain <Expected>
    Examples:
      | Actor | Tasks                         | Complete         | Filter    | Expected    |
      | Matt  | Create demo, Create ppt       | Create demo      | Active    | Create ppt  |
      | Bella | Create framework, Write tests | Create framework | Completed | Write tests |

  Scenario: Verify item count
    Given that Jerry the dog has a todo list containing Eat food, Sleep, Poop
    When he completes the task called 'Poop'
    Then the number of items left to do is 2
