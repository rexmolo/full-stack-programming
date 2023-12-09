package io.github.rexmolo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {

    @Test
    void isOverdue() {

        LocalDate deadline = LocalDate.now().minusDays(1);
        Person testPerson = new Person("jackie", "M", "ttt@aa.com");
        TodoItem todoItem = new TodoItem("shopping", "", deadline, testPerson);

        assertTrue(todoItem.isOverdue());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", ""})
    void testTitleNotNull(String title){
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TodoItem one = new TodoItem(
                    title,
                    "",
                    LocalDate.now(),
                    new Person("jackie", "M", "ttt@aa.com"));
            one.setTitle(title);
        });

        Assertions.assertEquals("title Not allowed to be null", thrown.getMessage());
    }

    @Test
    void setDeadline() {
        LocalDate theDayBefore = LocalDate.now().minusDays(1);

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Person testPerson = new Person("jackie", "M", "ttt@aa.com");
            TodoItem testTodoItem = new TodoItem("todo", "", theDayBefore, testPerson);
            testTodoItem.setDeadline(theDayBefore);
        });

        Assertions.assertEquals("not allowed before today", thrown.getMessage());
    }
}