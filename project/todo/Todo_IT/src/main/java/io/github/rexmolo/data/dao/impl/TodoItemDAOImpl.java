package io.github.rexmolo.data.dao.impl;

import io.github.rexmolo.data.dao.SQL.TodoItemSQL;
import io.github.rexmolo.data.dao.TodoItemsDAO;
import io.github.rexmolo.exception.MySQLException;
import io.github.rexmolo.models.Person;
import io.github.rexmolo.models.TodoItem;
import io.github.rexmolo.sys.DB_Operation._MySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class TodoItemDAOImpl implements TodoItemsDAO {

    private static _MySQL DB;
    private static PeopleDAOImpl peopleDAOImpl;
    public TodoItemDAOImpl(_MySQL db) {
        DB = db;
        peopleDAOImpl = new PeopleDAOImpl(DB);
    }

    @Override
    public TodoItem create(TodoItem todo) {
        try {

            PreparedStatement preparedStatement = DB.getPreparedStatement(TodoItemSQL.CREATE);
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getTaskDescription());
            preparedStatement.setDate(3, Date.valueOf(todo.getDeadline()));
            preparedStatement.setInt(4, todo.getDone()?1:0);
            preparedStatement.setInt(5, todo.getCreator().getId());
            int todoId = DB.create(preparedStatement);

            if (todoId == -1)  throw new MySQLException("create failed");

            todo.setId(todoId);
            return todo;
        } catch (SQLException sqe) {
            throw new MySQLException(sqe.getMessage());
        }
    }

    @Override
    public Collection<TodoItem> findAll() {
        ArrayList<TodoItem> TodoItemLs = new ArrayList<>();

        try {
            ResultSet rs = DB.query(TodoItemSQL.SELECT);
            TodoItemLs.add(getTodoItem(rs));
            return TodoItemLs;
        } catch (SQLException e) {
            throw new MySQLException(e.getMessage());
        }
    }

    @Override
    public TodoItem findById(int id) {
        try {
            PreparedStatement preparedStatement = DB.getPreparedStatement(TodoItemSQL.getFindSQL("todo_id"));
            preparedStatement.setInt(1, id);
            ResultSet rs = DB.executePreparedQuery(preparedStatement);

            return this.getTodoItem(rs);
        } catch (SQLException e) {
            throw new MySQLException(e.getMessage());
        }
    }

    @Override
    public Collection<TodoItem> findByDoneStatus(boolean status) {
        ArrayList<TodoItem> TodoItemLs = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DB.getPreparedStatement(TodoItemSQL.getFindSQL("done"));
            preparedStatement.setInt(1, status?1:0);
            ResultSet rs = DB.executePreparedQuery(preparedStatement);

            TodoItemLs.add(getTodoItem(rs));
            return TodoItemLs;
        } catch (SQLException e) {
            throw new MySQLException(e.getMessage());
        }
    }

    @Override
    public Collection<TodoItem> findByAssignee(Person person) {
        ArrayList<TodoItem> TodoItemLs = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DB.getPreparedStatement(TodoItemSQL.getFindSQL("assignee_id"));
            preparedStatement.setInt(1, person.getId());
            ResultSet rs = DB.executePreparedQuery(preparedStatement);

            TodoItemLs.add(getTodoItem(rs));
            return TodoItemLs;
        } catch (SQLException e) {
            throw new MySQLException(e.getMessage());
        }
    }

    @Override
    public Collection<TodoItem> findByUnAssigneeTodoItems() {
        ArrayList<TodoItem> TodoItemLs = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DB.getPreparedStatement(TodoItemSQL.getFindSQL("assignee_id"));
//            preparedStatement.setInt(1, "NULL"); //todo
            ResultSet rs = DB.executePreparedQuery(preparedStatement);

            TodoItemLs.add(getTodoItem(rs));
            return TodoItemLs;
        } catch (SQLException e) {
            throw new MySQLException(e.getMessage());
        }
    }

    @Override
    public TodoItem update(TodoItem todoItem) {
        if (Objects.isNull(todoItem)) throw new IllegalArgumentException("empty data not allowed");

        TodoItem foundTodo = this.findById(todoItem.getId());
        if (Objects.isNull(foundTodo)) throw new IllegalArgumentException("could not find this todo item");

        if (todoItem.equals(foundTodo)) return todoItem;

        try {
            PreparedStatement preparedStatement = DB.getPreparedStatement(TodoItemSQL.getUpdateSQL("todo_id"));

            preparedStatement.setString(1, todoItem.getTitle());
            preparedStatement.setString(2, todoItem.getTaskDescription());
            preparedStatement.setDate(3, Date.valueOf(todoItem.getDeadline()));
            preparedStatement.setInt(4, todoItem.getDone()?1:0);
            preparedStatement.setInt(5, todoItem.getCreator().getId());

            int rowsAffected = DB.update(preparedStatement);

            if (rowsAffected == 0) throw new MySQLException("update failed");

            return todoItem;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        if (id < 0) throw new IllegalArgumentException("data not allowed");

        TodoItem foundTodo = this.findById(id);
        if (Objects.isNull(foundTodo)) throw new IllegalArgumentException("could not find this todo item");

        try {
            PreparedStatement preparedStatement = DB.getPreparedStatement(TodoItemSQL.getDeleteSQL("todo_id"));

            preparedStatement.setInt(1, id);
            int rowsAffected = DB.delete(preparedStatement);
            return rowsAffected != 0;
        } catch (SQLException e) {
            throw new MySQLException(e.getMessage());
        }
    }


    private TodoItem getTodoItem(ResultSet rs) throws SQLException {
        TodoItem todoItem= new TodoItem();

        while (rs.next()) {
            todoItem.setId(rs.getInt("todo_id"));
            todoItem.setTitle(rs.getString("title"));
            todoItem.setTaskDescription(rs.getString("description"));
            todoItem.setDeadline(rs.getDate("deadline").toLocalDate());
            todoItem.setDone(rs.getInt("done") == 1);
            todoItem.setCreator(peopleDAOImpl.findById(rs.getInt("assignee_id")));

        }
        return todoItem;
    }
}
