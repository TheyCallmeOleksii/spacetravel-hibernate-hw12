package org.example.service;

import org.example.dao.PlanetDaoService;
import org.example.entity.Planet;

public class PlanetServiceImpl implements PlanetService {

    private final PlanetDaoService planetDao;

    public PlanetServiceImpl(PlanetDaoService planetDao) {
        this.planetDao = planetDao;
    }

    @Override
    public void createPlanet(Planet planet) {
        validatePlanet(planet);
        planetDao.create(planet);
    }

    @Override
    public Planet getPlanetById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID планети не може бути порожнім");
        }
        return planetDao.getById(id);
    }

    @Override
    public void updatePlanet(Planet planet) {
        validatePlanet(planet);
        if (planet.getId() == null || planet.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("Неможливо оновити планету без ID");
        }
        planetDao.update(planet);
    }

    @Override
    public void deletePlanet(Planet planet) {
        if (planet == null || planet.getId() == null) {
            throw new IllegalArgumentException("Планета або її ID не можуть бути null");
        }
        planetDao.delete(planet);
    }

    private void validatePlanet(Planet planet) {
        if (planet == null) {
            throw new IllegalArgumentException("Планета не може бути null");
        }
        if (planet.getId() == null || !planet.getId().matches("^[A-Z0-9]+$")) {
            throw new IllegalArgumentException("ID планети має складатися виключно з великих латинських букв та цифр");
        }
        if (planet.getName() == null || planet.getName().length() < 1 || planet.getName().length() > 500) {
            throw new IllegalArgumentException("Назва планети має містити від 1 до 500 символів");
        }
    }
}