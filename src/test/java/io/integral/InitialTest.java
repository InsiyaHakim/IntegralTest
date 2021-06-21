package io.integral;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class InitialTest {

    private People firstUser;
    private People secondUser;
    private TimeLine timeLine;
    private List<String> messages;

    @Before
    public void init() {
        firstUser = new People();
        firstUser.setName("Alice");
        secondUser = new People();

        timeLine = new TimeLine();
        timeLine.addPeople(firstUser);
        messages = new ArrayList<String>();
    }
/*
person can post a message to there timeline
person can view their messages
create another person and see if her messages are geting correctly
timeline how long message was posted

* */

    @Test
    public void personCanPostMessage(){
        People people = new People();
        people.setName("Alice");
        people.postMessage("I love the weather today.");
        people.viewTimeLine();
        Assert.assertEquals(1, people.viewTimeLine().size());
        Assert.assertEquals("I love the weather today.", people.viewTimeLine().get(0).getText());
    }

    @Test
    public void addAlice(){
        Assert.assertEquals(1, timeLine.people.size());
    }

    @Test
    public void getAlicesMessage(){
        messages.add("I love the weather today.");
        List<String> allMessages = timeLine.sendMessage("I love the weather today.");

        Assert.assertEquals("I love the weather today.", allMessages.get(0));
    }

    @Test
    public void addBob(){
        secondUser.setName("Bob");
        timeLine.addPeople(secondUser);

        Assert.assertEquals(2, timeLine.people.size());
    }

    @Test
    public void checkBobsMessages(){
        secondUser.setName("Bob");
        timeLine.addPeople(secondUser);

        //messages.add("Darn! We lost!");
        /*messages.add("Good game though.");
        messages.add("Good game though, yayy.");*/
        timeLine.sendMessage("Darn! We lost!");
        timeLine.sendMessage("Good game though.");
        List<String> messages = timeLine.sendMessage("Good game though, yayy.");

        Assert.assertEquals("Darn! We lost!", messages.get(2));
        Assert.assertEquals("Good game though.", messages.get(1));
        Assert.assertEquals("Good game though, yayy.", messages.get(0));
    }
}
