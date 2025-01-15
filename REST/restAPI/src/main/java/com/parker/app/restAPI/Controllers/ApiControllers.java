package com.parker.app.restAPI.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.parker.app.restAPI.Models.User;
import com.parker.app.restAPI.Repo.UserRepo;

@RestController
public class ApiControllers {

    //CRUD interface - Create (Post)
    //               - Read (Get)
    //               - Update (Put)
    //               - Delete (Delete)
    //
    
    @Autowired
    private UserRepo userRepo;

    //Default
    @GetMapping(value = "/")
    public String getPage(){
        return "CRUD interface supported - \r\n" + //
            "Create (Post)\r\n" + //
            "Read (Get)\r\n" + //
            "Update (Put)\r\n" + //
            "Delete (Delete)\r\n";
    }

    //Example use:
    // http://localhost:8080/
    
    //Create
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved for...User: " + user.getLastName() + " " + user.getFirstName() + ", " + user.getAge() + ": " + user.getOccupation();
    }

    //Example use:
    // http://localhost:8080/save
    // {
    //     "firstName": "Jane",
    //     "lastName" : "Doe",
    //     "age" : 33,
    //     "occupation" : "Dev"
    // }


    //Hello
    @GetMapping(value = "/hello")
    public List<User> hello(){
        System.out.println("Hello From Java!");
        return userRepo.findAll();
    }

    //Read
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    //Example use:
    // http://localhost:8080/users

    //Update
    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        if(user.getFirstName() != null)
            updatedUser.setFirstName(user.getFirstName());
        if(user.getLastName() != null)
            updatedUser.setLastName(user.getLastName());
        if(user.getAge() > 0)
            updatedUser.setAge(user.getAge());
        if(user.getOccupation() != null)
            updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "Updated for...User: " + updatedUser.getLastName() + " " + updatedUser.getFirstName() + ", " + updatedUser.getAge() + ": " + updatedUser.getOccupation();
    }

    //Example use:
    // http://localhost:8080/update/23
    // {
    //     "firstName": "Johnnie",
    //     "lastName" : "Doe",
    //     "age" : 44,
    //     "occupation" : "Admin"
    // }

    //Delete
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        //method successfully deletes, but does NOT get values for the User object
        
        User deletedUser = userRepo.findById(id).get();
        String lName = deletedUser.getLastName();
        String fName = deletedUser.getFirstName();
        int age = deletedUser.getAge();
        String occup = deletedUser.getOccupation();

        //this part works
        userRepo.deleteById(id);

        return "Deleted for...User: " + lName + " " + fName + ", " + age + ": " + occup;
    }

    //Example use:
    // http://localhost:8080/delete/19
}
