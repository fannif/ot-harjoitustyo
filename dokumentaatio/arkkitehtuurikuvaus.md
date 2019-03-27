# Arkkitehtuurikuvaus

### Rakenne
Sovelluksen rakenne koostuu erillisissä paketeissa olevista käyttöliittymästä, DAO:sta ja sovelluslogiikasta.
Käyttöliittymään liittyvä koodi on paketissa sudoku.ui, sovelluslogiikan koodi paketissa sudoku.domain ja DAO-koodi paketissa sudoku.dao.
DAO-paketin koodi tulee vastaamaan tietojen pysyvästä tallentamisesta tietokantaan.

### Käyttöliittymä
Käyttöliittymä tulee olemaan luokassa sudoku.ui.UserInterface.
Käyttöliittymä tulee sisältämään kolme näkymää. Ensimmäinen näkymä on käynnistyksessä avautuva valikko, jossa käyttäjä pääsee valitsemaan, haluaako hän pelata vai tarkastella ennätyksiä.
Toinen näkymä on pelinäkymä, jossa sudokua täytetään.
Kolmas näkymä näyttää tietokannasta haettavia ennätyksiä.
Jokainen näkymä on oma Scene-olionsa.
