package org.example.dao;

import org.example.entity.Planet;

public interface PlanetDaoService {
    void create(Planet planet);
    Planet getById(String id);
    void update(Planet planet);
    void delete(Planet planet);
}