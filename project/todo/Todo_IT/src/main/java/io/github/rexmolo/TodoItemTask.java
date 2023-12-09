package io.github.rexmolo;

import java.util.Objects;

public class TodoItemTask {

    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask() {
        this.assigned = true ? !Objects.isNull(this.assignee) : false;
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }


    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }


    public String getSummary() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +
                ", assignee=" + assignee +
                '}';
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +
                ", assignee=" + assignee +
                '}';
    }
}