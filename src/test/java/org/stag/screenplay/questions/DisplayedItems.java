package org.stag.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import org.stag.screenplay.pages.TodoList;

import java.util.List;

@Subject("the displayed todo items")
public class DisplayedItems implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(TodoList.ITEMS)
                .viewedBy(actor)
                .asList();
    }
}