package library.LibraryServerJava.controllers;

import library.LibraryServerJava.models.User;
import library.LibraryServerJava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    UserService userService;

    //CREATE a User.
    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // DELETE a user based on ID.
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
    // GET a user by ID.
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // GET ALL users.
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // UPDATE a user.
    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}