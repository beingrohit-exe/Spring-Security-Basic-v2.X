package com.security.security_basics.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.security.security_basics.Entity.User;

@Service
public class UserService {
    
    List<User> list = new ArrayList<>();

    public UserService(){
        list.add(new User(1, "Rohit Parihar", "rohit@gmail.com", "rohit"));
        list.add(new User(2, "Rakesh Sharma", "rakesh@gmail.com", "rakesh"));
        list.add(new User(3, "Sachin", "sachin@gmail.com", "sachin"));
        list.add(new User(4, "Abhishek", "abhishek@gmail.com", "abhishek"));
    }

    public User getUser(Integer id){
        return list.stream().filter((user)-> user.getId().equals(id)).findFirst().orElse(null);
    }

    public List<User> allUsers(){
        return list;
    }

    public String addUser(User user){
        List<Boolean> collect = list.stream().map(e-> e.getId().equals(user.getId())).collect(Collectors.toList());
        boolean contains = collect.contains(true);
        if(!contains){
            list.add(user);
            return "User Added";
        }
        else throw new RuntimeException("User Present");
    }

    public String removeUser(Integer id){
        User newUser =  list.stream().filter((user)-> user.getId().equals(id)).findFirst().get();
        list.remove(newUser);
        return "Removed Successfully";
    }
}
