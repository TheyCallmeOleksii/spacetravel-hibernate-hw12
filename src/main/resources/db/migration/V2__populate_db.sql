INSERT INTO planet (id, name) VALUES
                                  ('EARTH', 'Земля'),
                                  ('MARS', 'Марс'),
                                  ('VEN', 'Венера'),
                                  ('JUP', 'Юпітер'),
                                  ('SAT', 'Сатурн');

INSERT INTO client (name) VALUES
                              ('Люк Скайвокер'),
                              ('Лея Органа'),
                              ('Ган Соло'),
                              ('Чубакка'),
                              ('Дарт Вейдер'),
                              ('Майстер Йода'),
                              ('Обі-Ван Кенобі'),
                              ('Боба Фетт'),
                              ('Лендо Калріссіан'),
                              ('Падме Амідала');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
                                                                 (1, 'EARTH', 'MARS'),
                                                                 (2, 'EARTH', 'VEN'),
                                                                 (3, 'MARS', 'JUP'),
                                                                 (4, 'VEN', 'EARTH'),
                                                                 (5, 'SAT', 'MARS'),
                                                                 (6, 'JUP', 'SAT'),
                                                                 (7, 'MARS', 'EARTH'),
                                                                 (8, 'VEN', 'JUP'),
                                                                 (9, 'EARTH', 'SAT'),
                                                                 (10, 'SAT', 'EARTH');