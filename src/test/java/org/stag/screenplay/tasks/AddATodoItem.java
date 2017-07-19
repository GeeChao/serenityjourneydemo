package org.stag.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.RETURN;
import static org.stag.screenplay.pages.TodoList.WHAT_NEEDS_TO_BE_DONE;

public class AddATodoItem implements Task {

    private final String thingToDo;

    public AddATodoItem(String thingToDo) {
        this.thingToDo = thingToDo;
    }

    @Step("{0} adds a todo item called: #thingToDo")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Enter.theValue(thingToDo)
                        .into(WHAT_NEEDS_TO_BE_DONE)
                        .thenHit(RETURN)
        );
    }

    public static AddATodoItem called(String thingToDo) {
        return instrumented(AddATodoItem.class, thingToDo);
    }

}