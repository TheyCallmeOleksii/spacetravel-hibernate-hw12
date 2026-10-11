package org.example;

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

        System.out.println("--- ТЕСТУВАННЯ КЛІЄНТІВ ---");
        ClientCrudService clientService = new ClientCrudService();

        Client newClient = new Client();
        newClient.setName("Мандалорець");
        clientService.createClient(newClient);
        System.out.println("Створено клієнта: " + newClient.getName() + " з ID: " + newClient.getId());

        Client savedClient = clientService.getClientById(newClient.getId());
        System.out.println("Знайдено в базі: " + savedClient.getName());

        savedClient.setName("Дін Джарін");
        clientService.updateClient(savedClient);
        System.out.println("Після оновлення ім'я: " + clientService.getClientById(savedClient.getId()).getName());

        clientService.deleteClient(savedClient);
        System.out.println("Спробували знайти після видалення: " + clientService.getClientById(savedClient.getId()));
        System.out.println("\n--- ТЕСТУВАННЯ ПЛАНЕТ ---");

        PlanetCrudService planetService = new PlanetCrudService();

        Planet newPlanet = new Planet();
        newPlanet.setId("TATOOINE");
        newPlanet.setName("Татуїн");
        planetService.createPlanet(newPlanet);
        System.out.println("Створено планету: " + newPlanet.getName() + " з ID: " + newPlanet.getId());

        Planet savedPlanet = planetService.getPlanetById("TATOOINE");
        System.out.println("Знайдено в базі: " + savedPlanet.getName());

        savedPlanet.setName("Пустельний Татуїн");
        planetService.updatePlanet(savedPlanet);
        System.out.println("Після оновлення назва: " + planetService.getPlanetById("TATOOINE").getName());

        planetService.deletePlanet(savedPlanet);
        System.out.println("Спробували знайти після видалення: " + planetService.getPlanetById("TATOOINE"));

        HibernateUtil.getInstance().close();
    }
}