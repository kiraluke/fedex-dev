package com.ascending.controller;

import com.ascending.model.User;
import com.ascending.repository.UserDao;
import com.ascending.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/user"})
public class UserController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private UserService userService;

    /**
     * Get userbyName
     */
    @RequestMapping(value = "/{recpName}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByName(@PathVariable(name = "recpName") String userName){
        User user = userService.getUserByName(userName);
        return user;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User updateUserName(@PathVariable("id") Long Id,@RequestParam("name") String name){
        User r = userService.getUserById(Id);
        r.setUsername(name);
        r = userService.update(r);
        return r;
    }

    /**
     * GET/User
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getUsers(){
        List<User> users = userService.getUsers();
        return users;
    }
    /**
     * Post/User
     */
    @RequestMapping(value = "",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User createUser(@RequestBody User user){
        logger.debug("User: " + user.toString());
        String msg = "The user has been created.";
        User recp = userService.save(user);

        if(recp == null)msg = "The user has not been created.";

        return recp;
    }

    /**
     * Put/User
     */
    @RequestMapping(value = "",method = RequestMethod.PUT,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User updateUser(@RequestBody User user){
        logger.debug("User: " + user.toString());
        String msg = "The user has been updated.";
        User recp = userService.update(user);

        if(recp == null)msg = "The user has not been updated.";

        return recp;
    }
    /**
     * Delete/UserByName
     */
    @RequestMapping(value = "/{recpName}",method = RequestMethod.DELETE,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteUser(@PathVariable(name = "recpName") String userName){
        logger.debug("User name: " + userName);
        String msg = "The user has been deleted.";
        boolean isSuccess = userService.delete(userName);

        if(!isSuccess)msg = "The user has not been deleted.";

        return msg;
    }
}
