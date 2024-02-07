delete from players;
insert into players (player_id, birth_year, birth_month, birth_day, birth_country, birth_state, birth_city,
                     death_year, death_month, death_day, death_country, death_state, death_city,
                     name_first, name_last, name_given, weight, height, batting_hand, throwing_hand,
                     debut, final_game, retro_id, bbref_id)
values ('abadijo01', 1850, 11, 4, 'USA', 'PA', 'Philadelphia', 1905, 5, 17, 'USA', 'NJ', 'Pemberton', 'John', 'Abadie',
        'John W.', 192, 72, 'R', 'R', '1875-04-26', '1875-06-10', 'abadj101', 'abadijo01'),
       ('abbated01', 1877, 4, 15, 'USA', 'PA', 'Latrobe', 1957, 1, 6, 'USA', 'FL', 'Fort Lauderdale', 'Ed', 'Abbaticchio',
        'Edward James', 170, 71, 'R', 'R', '1897-09-04', '1910-09-15', 'abbae101', 'abbated01');