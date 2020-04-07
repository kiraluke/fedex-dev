package com.ascending.service;

import com.ascending.model.Pack;
import com.ascending.model.Routing;
import com.ascending.repository.RoutingDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoutingService {
    @Autowired
    private RoutingDao routingDao;

    public Routing save(Routing routing){return routingDao.save(routing);}
    public Routing update(Routing routing){return routingDao.update(routing);}
    public boolean delete(Routing routing){return routingDao.delete(routing);}
    public List<Routing> getRoutings(){return routingDao.getRoutings();}
    public Routing getRoutingByPirority(String pirority){return routingDao.getRoutingByPirority(pirority);}
    public List<Pack> getRoutingAndPack(String pirority){return routingDao.getRoutingAndPack(pirority);}
    public boolean delete(String pirority){return routingDao.deleteBy(pirority);}
}
