package com.ascending.controller;

import com.ascending.model.Routing;
import com.ascending.service.RoutingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/routing"})
public class RoutingController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private RoutingService routingService;

    /**
     * Get/Routing
     */
    @RequestMapping(value = "",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Routing> getRoutings(){
        List<Routing> routings = routingService.getRoutings();
        return routings;
    }
    /**
     * Get/RoutingByPirority
     */
    @RequestMapping(value = "/{pirority}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Routing getRoutingByPirority(@PathVariable(name = "pirority") String pirority){
        Routing routing = routingService.getRoutingByPirority(pirority);
        return routing;
    }
    /**
     * Post/Routing
     */

    @RequestMapping(value = "",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Routing createRouting(@RequestBody Routing routing){
        logger.debug("Routing: "+ routing.toString());
        String msg = "The routing has been created.";
        Routing rout = routingService.save(routing);

        if(rout == null) msg = "The routing has not been created.";

        return rout;
    }
    /**
     * Put/Routing
     */
    @RequestMapping(value = "",method = RequestMethod.PUT,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Routing updateRouting(@RequestBody Routing routing){
        logger.debug("Routing: "+ routing.toString());
        String msg = "The routing has been updated.";
        Routing rout = routingService.update(routing);

        if(rout == null) msg = "The routing has not been updated.";

        return rout;
    }
    /**
     * delete/Routing
     */
    @RequestMapping(value = "/{pirority}",method = RequestMethod.DELETE,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteRouting(@PathVariable(name = "pirority")String pirority){
        logger.debug("Pirority: " + pirority);
        String msg = "The routing has been deleted.";
        boolean isSuccess = routingService.delete(pirority);

        if(!isSuccess)msg = "The routing has not been deleted.";

        return msg;
    }
}
