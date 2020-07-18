package io.integral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TimeLine {

    public TimeLine(){
        people = new ArrayList<People>();
        message = new ArrayList<String>();
    }

    public  List<People> people;
    public  List<String> message;

    public void addPeople(People user){
        people.add(user);
    }

    public List<String> sendMessage(List<String> m) {

        for(var i = 0; i < m.size(); i++){
            message.add(m.get(i));
        }

        if(message.size() == 1){
            return message;
        }
        else{
            Collections.reverse(message);
            return message;
        }
    }

}

 class People {
    public String Name;
}