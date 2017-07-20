Feature: Maintaining ToDos
  As an organized person,
  I should be able to maintain my to-do list,
  So that I can manage what I need to do.

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
      | Frodo | Create demo, Create ppt       | Create demo      | Active    | Create ppt  |
      | Bilbo | Create framework, Write tests | Create framework | Completed | Write tests |

  Scenario: Verify item count
    Given that Jerry the dog has a todo list containing Eat food, Sleep, Poop
    When he completes the task called 'Poop'
    Then the number of items left to do is 2
