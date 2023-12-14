package io.github.rexmolo.models;

import io.github.rexmolo.utils.verify;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean done;
    private Person creator;


    public TodoItem() {
        this.id = this.generateId();
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

    public boolean isOverdue() {
        LocalDate today = LocalDate.now();
        if (today.isAfter(this.deadline))
            return true;
        return false;
    }

    private void checkArguments(){
        String[] fieldName = {"title"};
        String[] fieldValue = {this.title};
        verify.arguments(fieldName, fieldValue);
    }

    public int generateId(){
        return ++this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        verify.arguments("title", title);
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
        if (today.isAfter(deadline)) throw new IllegalArgumentException("not allowed before today");
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


    public String getSummary() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadline=" + deadline +
                ", done=" + (done ? "finished" : "unfinished") +
                ", creator=" + creator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem todoItem)) return false;
        return id == todoItem.id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && Objects.equals(deadline, todoItem.deadline) && Objects.equals(creator, todoItem.creator);
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
