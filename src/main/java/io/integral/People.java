package io.integral;

import java.util.ArrayList;
import java.util.List;

public class People {

    private String name;
    private String message;
    private List<Message> timeLine = new ArrayList<>() {};

     public void setName(String name) {
        this.name = name;
    }

    public void postMessage(String text) {
        Message message = new Message(text);
        timeLine.add(message);

    }

    public List<Message> viewTimeLine() {
        return timeLine;
    }
}
