## Käyttöohje

### Ohjelman käynnistys
Ohjelma käynnistetään menemällä ensin terminaalissa kansioon, johon ohjelman jar-tiedosto on ladattu. Tämän jälkeen ajetaan komento `java -jar SudokuGame.jar`. Tällöin ohjelma käynnistyy.

### Pelaaminen
Ohjelman käynnistyttyä avautuu alkuvalikko. Sudokun pelaaminen aloitetaan painamalla nappia Play game (easy) tai Play game (normal), sen mukaan haluaako peliä pelata haastavammalla vai vähemmän haastavalla vaikeusasteella. Vaikeusasteiden ero on, että helpossa sudokussa pelaajan täytettäväksi on jätetty vähemmän ruutuja.

Kun ohjelma on ohjannut käyttäjän pelinäkymään, pelaaminen tapahtuu täyttämällä ikkunassa olevaan sudokuruudukkoon tyhjiin kohtiin numerot, joita ei ilmene ennestään kyseisen ruudun rivillä, sarakkeella tai kolme-kertaa-kolmen ruudun aliruudukossa. Kun ruudukkoon täytetyn ratkaisun haluaa tarkistaa, painetaan Check my sudoku -nappia. Ohjelma ilmoittaa, mikäli ratkaisu on oikein. Jos ratkaisu on oikea, käyttäjä voi tallentaa tuloksen kirjoittamalla nimimerkkinsä ilmestyvään tekstikenttään ja painamalla ilmestynyttä tallennusnappia. Ohjelma hyväksyy nimimerkiksi vain 1 - 3 merkkiä pitkän merkkijonon. Tämän jälkeen (tai halutessaan vielä edellisen sudokun ollessa kesken) käyttäjä voi pyytää uuden sudokun painamalla Generate new sudoku -nappia. Mikäli käyttäjä haluaa palata alkuvalikkoon, se voidaan tehdä painamalla Return to start menu -nappia. Kaikki tässä luetellut napit löytyvät pelinäkymän vasemmasta yläkulmasta.

### Tulosten katseleminen
Käyttäjän parhaiden tulosten katselu onnistuu painamalla alkuvalikossa View High Scores -nappia. Nappi avaa ennätysnäkymän, jossa on vasemmalla listattuna parhaat suoritukset normaalilla vaikeustasolla ja oikealla helpolla vaikeustasolla. Halutessaan käyttäjä voi palata takaisin alkuvalikkoon painamalla vasemmassa yläkulmassa olevaa Return to start menu -nappia.

### Muuta huomioitavaa
Sovellusta käyttäessä on hyvä huomata, että sovellus käyttää tietokantaa pelitulosten tallentamiseen. Tietokannan poistaminen johtaa  pelitulosten katoamiseen. Jos tietokanta poistetaan pysyvästi, ei siihen mennessä tallennettuja pelituloksia saa enää takaisin. Tällöin sovellus luo uuden tietokannan seuraavalla käynnistyskerralla.

Tietokanta luodaan Linux-järjestelmissä samaan hakemistoon sovelluksen jar-tiedoston kanssa. Windows-järjestelmissä tietokanta luodaan käyttäjän oman päähakemiston alle. Myös tietokannan siirtäminen pois näistä hakemistoista aiheuttaa sen, ettei sovellus pysty lukemaan senastisia tuloksia, ellei tietokantaa siirretä takaisin.

Käyttäjän ei siis tule siirtää tai poistaa scores.db -tiedostoa, ellei ennätyksiä haluta nollata tarkoituksella.
