package com.ascending.controller;

import com.ascending.model.Pack;
import com.ascending.service.PackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/pack"})
public class PackController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private PackService packService;
/**
 * Get/pack
 */
    @RequestMapping(value = "",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Pack> getPacks(){
        List<Pack> packs = packService.getPacks();
        return packs;
    }
    /**
     * Post/Pack
     */
    @RequestMapping(value = "",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Pack createPack(@RequestBody Pack pack){
        logger.debug("Pack: " +pack.toString());
        String msg = "The package has been created.";
        Pack pkg = packService.save(pack);

        if(pkg == null) msg = "The routing has not been created.";

        return pkg;
    }
    /**
     * Put/Pack
     */
    @RequestMapping(value = "",method = RequestMethod.PUT,consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Pack updatePack(@RequestBody Pack pack){
        logger.debug("Pack: " +pack.toString());
        String msg = "The package has been created.";
        Pack pkg = packService.update(pack);

        if(pkg == null) msg = "The routing has not been created.";

        return pkg;
    }
    /**
     * Get/PackByTracking
     */
    @RequestMapping(value = "/{tracking}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Pack getTackingByTracking(@PathVariable(name = "tracking")String trackingId){
        Pack pack = packService.getPackByTrackingId(trackingId);
        return pack;
    }
}
