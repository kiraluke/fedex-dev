package com.ascending.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping(value = {"/test"})
public class TestController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * GET/Test
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String,Object> getSampleJson(){
        Map<String,Object> m = new HashMap<>();
        m.put("id",1);
        m.put("name","HR");
        m.put("capacity",500);
        return m;
    }

    /**
     * Post/Test/example
     * @return
     */
    @RequestMapping(value = {"/example"},method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String,Object> createObject(){
        Map<String,Object> m = new HashMap<>();
        Random r = new Random();
        m.put("id",r.nextInt());
        m.put("name","HR");
        m.put("capacity",500);
        logger.debug("create an object with id:" + m.get("id"));
        return m;
    }

    /**
     * Put/test/simple
     * @return
     */

    @RequestMapping(value = {"/simple"}, method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String,Object> putData(){
        Map<String,Object> m = new HashMap<>();
        Random r = new Random();
        m.put("id",r.nextInt());
        m.put("name","HR");
        m.put("capacity",500);
        logger.debug("create an object with id:" + m.get("id"));
        m.replace("id",1);
        m.replace("name","Manager");
        m.replace("capacity",1000);
        logger.debug("update data with id" + m.get(1));
        return m;
    }

    /**
     * delete/test/simple1
     * @return
     */
    @RequestMapping(value = {"/simple1"}, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String,Object> deleteData() {
        Map<String, Object> m = new HashMap<>();
        Random r = new Random();
        m.put("id", r.nextInt());
        m.put("name", "HR");
        m.put("capacity", 500);
        logger.debug("create an object with id:" + m.get("id"));
        m.replace("id", 1);
        m.replace("name", "Manager");
        m.replace("capacity", 1000);
        logger.debug("update data with id" + m.get(1));
        m.remove("id");
//        m.remove("id", 1);
        m.remove("name");
        m.remove("capacity");
        logger.debug("delete data with id" +m.remove(1));
        return m;
    }
}
