package io.github.rexmolo.data.dao;

import io.github.rexmolo.models.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO extends BaseDAO<TodoItemTask> {
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findByAssignedStatus(boolean status);
    Collection<TodoItemTask> findByPersonid(int personId);
}
