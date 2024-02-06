package io.github.rexmolo.models;

import io.github.rexmolo.exception.ErrMsg;
import io.github.rexmolo.utils.Verify;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean done;
    private Person creator;



//    public TodoItem() {
//        this.id = this.generateId();
//    }


    public TodoItem() {
    }

    public TodoItem(String title, String taskDescription, LocalDate deadline, Person creator) {
        this(title, taskDescription, deadline, creator, false);
    }


    public TodoItem(String title, String taskDescription, LocalDate deadline, Person creator, boolean done) {
        this();
        this.title = title;
        this.taskDescription = taskDescription;
        this.setDeadline(deadline);
        this.creator = creator;
        this.done = done;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isOverdue() {
        LocalDate today = LocalDate.now();
        return today.isAfter(this.deadline);
    }

    private void checkArguments(){
        String[] fieldName = {"title"};
        String[] fieldValue = {this.title};
        Verify.arguments(fieldName, fieldValue);
    }

//    public int generateId(){
//        return ++this.id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        Verify.arguments("title", title);
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        LocalDate today = LocalDate.now();
        if (today.isAfter(deadline)) ErrMsg.custom("not allowed before today");
        this.deadline = deadline;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem todoItem)) return false;
        return id == todoItem.id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && Objects.equals(deadline, todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", creator=" + creator +
                '}';
    }
}
