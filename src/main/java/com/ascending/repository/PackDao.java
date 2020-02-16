package com.ascending.repository;

import com.ascending.model.Pack;

import java.util.List;

public interface PackDao {
    List<Pack> getPacks();
    Pack save(Pack pack);
    Pack update(Pack pack);
    boolean deleteBy(String destination);
    boolean delete(Pack pack);
}
