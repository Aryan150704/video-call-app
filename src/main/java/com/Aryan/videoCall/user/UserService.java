package com.Aryan.videoCall.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

@Service

public class UserService {

    private static final List<User> USER_LIST = new ArrayList<>();

    public void register(User User){
        User.setStatus("online");
        USER_LIST.add(User);
    }
    public User login(User User){
        var userIndex= IntStream.range(0,USER_LIST.size())
                .filter(i->USER_LIST.get(i).getEmail().equals(User.getEmail()))
                .findAny()
                .orElseThrow(()->new RuntimeException("User not found"));
        var cUser=USER_LIST.get(userIndex);
        if(!cUser.getPassword().equals(User.getPassword())){
            throw new RuntimeException("Password is Incorrect");
        }
        cUser.setStatus("online");
        return cUser;
    }
    public void logout(String email){
        var userIndex= IntStream.range(0,USER_LIST.size())
                .filter(i->USER_LIST.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(()->new RuntimeException("User not found"));
        USER_LIST.get(userIndex).setStatus("offline");
    }
    public List<User> findAll(){
        return USER_LIST;
    }
}
