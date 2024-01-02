package io.github.rexmolo.data.dao;

import io.github.rexmolo.models.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO extends BaseDAO<TodoItem> {

    TodoItem findById(int id);
    Collection<TodoItem> findAllByDoneStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int id);
    Collection<TodoItem> findByDeadlineBefore(LocalDate date);
    Collection<TodoItem> findByDeadlineAfter(LocalDate date);
}
