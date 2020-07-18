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
    private List<String> myList;

    @Before
    public void init() {
        firstUser = new People();
        secondUser = new People();
        timeLine = new TimeLine();
        myList = new ArrayList<String>();
    }


    @Test
    public void addAlice(){
        firstUser.Name = "Alice";
        timeLine.addPeople(firstUser);
        Assert.assertEquals(1, timeLine.people.size());
    }

    @Test
    public void getAlicesMessage(){
        firstUser.Name = "Alice";
        timeLine.addPeople(firstUser);
        myList.add("I love the weather today.");
        List<String> messages = timeLine.sendMessage(myList);

        Assert.assertEquals("I love the weather today.", messages.get(0));
    }

    @Test
    public void addBob(){
        firstUser.Name = "Alice";
        secondUser.Name = "Bob";
        timeLine.addPeople(firstUser);
        timeLine.addPeople(secondUser);

        Assert.assertEquals(2, timeLine.people.size());
    }

    @Test
    public void checkBobsMessages(){
        secondUser.Name = "Bob";
        timeLine.addPeople(secondUser);
        myList.add("Darn! We lost!");
        myList.add("Good game though.");
        List<String> messages = timeLine.sendMessage(myList);

        Assert.assertEquals("Good game though.", messages.get(0));
        Assert.assertEquals("Darn! We lost!", messages.get(1));
    }
}
