package com.ascending.service;

import com.ascending.model.Pack;
import com.ascending.repository.PackDao;
import com.ascending.repository.PackDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PackService {
//    @Autowired
    private PackDao packDao;

    public Pack save(Pack pack){return packDao.save(pack);}
    public Pack update(Pack pack){return packDao.update(pack);}
    public List<Pack> getPacks(){return packDao.getPacks();}
    public boolean delete(Pack pack){return packDao.delete(pack);}
    public Pack getPackByTrackingId(String trackingId){return packDao.getPackByTracking(trackingId);}
}