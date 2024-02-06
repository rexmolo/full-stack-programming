package io.github.rexmolo.data.dao;

import io.github.rexmolo.models.Person;
import io.github.rexmolo.models.TodoItem;

import java.util.Collection;

public interface TodoItemsDAO {

    TodoItem create(TodoItem todo);
    Collection<TodoItem> findAll();
    TodoItem findById(int id);
    Collection<TodoItem> findByDoneStatus(boolean status);
    Collection<TodoItem> findByAssignee(Person person);
    Collection<TodoItem> findByUnAssigneeTodoItems();
    TodoItem update(TodoItem todoItem);
    boolean deleteById(int id);


}
