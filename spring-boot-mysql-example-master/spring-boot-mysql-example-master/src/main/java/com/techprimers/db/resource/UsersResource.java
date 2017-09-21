package com.techprimers.db.resource;

import com.techprimers.db.model.Users;
import com.techprimers.db.repository.UsersRepository;
import com.techprimers.db.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {
    @Autowired
    IUserService _userService;

    @GetMapping(value = "/all")
    public List<Users> getAll() {
        return _userService.findAllUsers();
    }
    
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Integer id){
    	return _userService.findById(id);
	}
    
    @PostMapping(value = "/post")
    public List<Users> persist(@RequestBody final Users users) {
    	_userService.saveUser(users);
        return _userService.findAllUsers();
    }
    
    @PutMapping("/put/{id}")
	public void updateUser(@PathVariable Integer id, @RequestBody Users user) {
    	_userService.updateUser(id,user);
	}
    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Integer id){
    	_userService.deleteUserById(id);
	}

}
