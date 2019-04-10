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

### Sovelluslogiikka
Sovelluslogiikka koostuu sudokuruudukkoa esitteävästä luokasta Sudoku. Sillä on oliomuuttujana itse ruudukkoa esittävä taulukko. Alustava luokkakaavio:

![Alustava luokkakaavio](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuLuokkakaavio.png "Alustava luokkakaavio")

Alla myös versio, johon on lisätty metodien nimet:

![Alustava luokkakaavio 2](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuLuokkakaavioMetodit.png "Alustava luokkakaavio 2")

Alustava pakkauskaavio:

![Alustava pakkauskaavio](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuPakkauskaavio.png "Alustava pakkauskaavio")

### Oleellisia toiminnallisuuksia
Käyttäjän pyytäessä uutta sudokua, toiminnallisuus etenee seuraavasti:
![Uuden sudokun generoiminen](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuSekvenssikaavioUusiSudoku.png "Uuden sudokun generoiminen")

Käyttäjän halutessa tarkistaa sudoku, toiminnallisuus etenee seuraavasti:
![Sudokun tarkistus](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuSekvenssikaavioTarkistus.png "Sudokun tarkistus")

