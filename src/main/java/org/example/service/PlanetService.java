package org.example.service;

import org.example.entity.Planet;

public interface PlanetService {
    void createPlanet(Planet planet);
    Planet getPlanetById(String id);
    void updatePlanet(Planet planet);
    void deletePlanet(Planet planet);
}