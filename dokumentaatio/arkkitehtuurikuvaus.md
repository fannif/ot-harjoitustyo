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
Sovelluslogiikka koostuu sudokuruudukkoa esitteävästä luokasta Sudoku sekä pelitulosta esittävästä luokasta Score. Sudokulla on oliomuuttujana itse ruudukkoa esittävä taulukko. Scorella on oliomuuttujina id, alkukirjaimet ja suoritusaika tietokantaan tallentamista varten. Sudoku ei tiedä mitään pelituloksista, eivätkä pelitulokset sudokusta. Luokkakaavio:

![Luokkakaavio](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuLuokkakaavio1904.png "Luokkakaavio")

Luokka-/pakkauskaavio:

![Pakkauskaavio](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuPakkauskaavio1904.png "Pakkauskaavio")

### Oleellisia toiminnallisuuksia
Käyttäjän pyytäessä uutta sudokua, toiminnallisuus etenee seuraavasti:
![Uuden sudokun generoiminen](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuSekvenssikaavioUusiSudoku.png "Uuden sudokun generoiminen")

Käyttäjän halutessa tarkistaa sudoku, toiminnallisuus etenee seuraavasti:
![Sudokun tarkistus](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuSekvenssikaavioTarkistus.png "Sudokun tarkistus")

