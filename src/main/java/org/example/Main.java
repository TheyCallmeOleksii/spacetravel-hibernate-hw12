package org.example;

import org.example.dao.ClientDaoService;
import org.example.dao.ClientDaoServiceImpl;
import org.example.dao.PlanetDaoService;
import org.example.dao.PlanetDaoServiceImpl;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.service.ClientService;
import org.example.service.ClientServiceImpl;
import org.example.service.PlanetService;
import org.example.service.PlanetServiceImpl;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:h2:./spacetravel";
        String dbUser = "sa";
        String dbPassword = "";

        Flyway flyway = Flyway.configure()
                .dataSource(dbUrl, dbUser, dbPassword)
                .load();
        flyway.migrate();
        System.out.println("База даних готова!\n");

        ClientDaoService clientDao = new ClientDaoServiceImpl();
        ClientService clientService = new ClientServiceImpl(clientDao);

        PlanetDaoService planetDao = new PlanetDaoServiceImpl();
        PlanetService planetService = new PlanetServiceImpl(planetDao);

        System.out.println("--- ТЕСТУВАННЯ КЛІЄНТІВ ---");
        Client newClient = new Client();
        newClient.setName("Мандалорець");

        clientService.createClient(newClient);
        System.out.println("Створено клієнта: " + newClient.getName() + " з ID: " + newClient.getId());

        System.out.println("\n--- ТЕСТУВАННЯ ПЛАНЕТ ---");
        Planet newPlanet = new Planet();
        newPlanet.setId("NABOO");
        newPlanet.setName("Набу");

        planetService.createPlanet(newPlanet);
        System.out.println("Створено планету: " + newPlanet.getName() + " з ID: " + newPlanet.getId());

        HibernateUtil.getInstance().close();
    }
}