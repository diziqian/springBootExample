package com.demo.springboot.web;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.
//.data.rest.webmvc.ResourceNotFoundException;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.demo.springboot.entity.User;
import com.demo.springboot.repository.UserRepository;


@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private UserRepository userRepository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDefault() {
        return "Hello, world!";
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public List<User> getAllUser() {
    	logger.info("getAllUser");
        return userRepository.findAll();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
    	System.out.print("User is: ");
    	System.out.println(user);
//    	logger.debug("User is: ", user);
        return userRepository.save(user);
    }
    
//    @PutMapping("/updateUser/userId")
    @RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.POST)
    public ResponseEntity<User> updateEmployee(@PathVariable(value = "userId") Integer userId,
         @Valid @RequestBody User userDetails) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception(
        		"User not found for this id :: " + 
        				userId
        ));
        
        user.setUserId(userDetails.getUserId());
        user.setUserName(userDetails.getUserName());
        user.setSex(userDetails.getSex());
        user.setCreatedTime(userDetails.getCreatedTime());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

//    @DeleteMapping("/deleteUser")
    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.POST)
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "userId") Integer userId)
         throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception(
    		"User not found for this id :: " + 
			userId
        ));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
