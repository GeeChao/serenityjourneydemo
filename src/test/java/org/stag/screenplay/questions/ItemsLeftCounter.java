package org.stag.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.stag.screenplay.pages.TodoList;

public class ItemsLeftCounter implements Question<Integer> {
    
    @Override
    public Integer answeredBy(Actor actor) {
        return Text.of(TodoList.ITEMS_LEFT)
                .viewedBy(actor)
                .asInteger();
    }

}