package io.github.rexmolo.sequencers;

public class TodoItemTaskIdSquencer {
    private static int currentId;


    public static int nextId() { return ++currentId; }

    public static int getCurrentId() { return currentId; }
    public static void setCurrentId(int currentId) { TodoItemTaskIdSquencer.currentId = currentId; }
}
