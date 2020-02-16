package com.ascending.repository;

import com.ascending.model.Routing;

import java.util.List;

public interface RoutingDao {
    List<Routing> getRoutings();
    Routing save(Routing routing);
    Routing update(Routing routing);
    boolean deleteBy(String pirority);
    boolean delete(Routing routing);
    Routing getRoutingByPirority(String pirority);
    List<Routing> getRoutingAndPack(String pirority);
}
