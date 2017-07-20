package org.stag.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.stag.screenplay.models.TodoStatusFilter;
import org.stag.screenplay.questions.TheItems;
import org.stag.screenplay.tasks.AddATodoItem;
import org.stag.screenplay.tasks.CompleteItem;
import org.stag.screenplay.tasks.FilterItems;
import org.stag.screenplay.tasks.Start;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class DemoSteps {

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) has an empty todo list$")
    public void actor_has_an_empty_todo_list(String actorName) throws Throwable {;
        theActorCalled(actorName).wasAbleTo(Start.withAnEmptyTodoList());
    }

    @Given("^that (.*) has a todo list containing (.*)$")
    public void that_James_has_an_empty_todo_list(String actorName, List<String> items) throws Throwable {
        theActorCalled(actorName).wasAbleTo(Start.withATodoListContaining(items));
    }

    @When("^s?he adds '(.*)' to (?:his|her|the) list$")
    public void adds_Buy_some_milk_to_his_list(String item) throws Throwable {
        theActorInTheSpotlight().attemptsTo(AddATodoItem.called(item));
    }

    @When("^s?he completes the task called '(.*)'$")
    public void complete_a_task(String item) throws Throwable {
        theActorInTheSpotlight().attemptsTo(CompleteItem.called(item));
    }

    @When("^s?he filters (?:his|her) list to show only (.*) tasks")
    public void filter_tasks_by(TodoStatusFilter filter) {
        theActorInTheSpotlight().attemptsTo(FilterItems.toShow(filter));
    }

    @Then("^'(.*)' should be recorded in (?:his|her|the) list$")
    public void item_should_be_recorded_in_the_list(String expectedItem) throws Throwable {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), hasItem(expectedItem)));
    }

    @Then("^(?:his|her|the) todo list should contain (.*)$")
    public void todo_list_should_contain(List<String> expectedItems) throws Throwable {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), equalTo(expectedItems)));
    }

    @Then("^(.*)'s todo list should contain (.*)$")
    public void a_users_todo_list_should_contain(String actorName, List<String> expectedItems) throws Throwable {
        theActorCalled(actorName).should(seeThat(TheItems.displayed(), equalTo(expectedItems)));
    }

    @Then("^the number of items left to do is (\\d*)$")
    public void verify_items_left_to_do(Integer count) {
        theActorInTheSpotlight().should(seeThat(TheItems.leftCount(), equalTo(count)));
    }
}
