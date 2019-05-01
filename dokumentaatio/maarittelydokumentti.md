## Määrittelydokumentti

### Sovelluksen tarkoitus
Sovellus on sudokupeli. Siinä on tarkoitus täyttää 9x9 -kokoisia ruudukoita numeroilla yhdestä yhdeksään niin, että kullakin vaaka- ja pystyrivillä on kukin numero vain kerran. Ruudukko koostuu myös yhdeksästä 3x3:n ruudun pikkuruudukoista, joissa kussakin saa olla kukin luku yhdestä yhdeksään vain kerran.

### Käyttäjät
Kyseessä on peli, johon ei tarvita muita käyttäjärooleja kuin _normaali käyttäjä_.

### Perusversion toiminnallisuudet
- Alkunäytössä, joka aukeaa, kun sovellus käynnistetään, käyttäjä pystyy valitsemaan, haluaako hän katsoa aiempia ennätyksiä vai pelata. Pelaamisvaihtoehtoja on kaksi: helpon tai normaalin vaikeustason sudoku.
- Jos valittiin edellisestä näytöstä ennätykset, niin sovellus listaa nollasta kymmeneen (riippuen pelisuoritusten määrästä) parasta tulosta ja niiden tekijöiden antamat nimimerkit kummastakin vaikeusluokasta. Ennätykset ovat aikajärjestyksessä nopeimmasta hitainpaan. Tästä näkymästä voi myös palata alkunäyttöön.
- Jos valittiin jompikumpi pelaamisvaihtoehto, niin sovellus tuottaa käyttäjälle uuden sudokun täytettäväksi. Käyttäjä voi halutessaan palata täältä alkunäyttöön. Helpossa sudokussa käyttäjä voi täyttää 25 tyhjää ruutua. Normaalissa ruutuja voi täyttää 45.
- Pelatessaan käyttäjä voi halutessaan laittaa sovelluksen tuottamaan uuden sudokun tai tarkistamaan nykyisen sudokun. Mikäli nykyinen sudoku on oikein, läyttäjälle näytetään suoritusaika, ja käyttäjä voi antaa kolmemerkkisen nimimerkin, minkä jälkeen hänen tuloksensa tallennetaan ennätyksiin suoritetun sudokun vaikeustasoa vastaavaan kohtaan. Jos sudoku meni väärin, sovellus ilmoittaa siitä, ja käyttäjä voi jatkaa yrittämistä.
- Sudokun täyttäminen tapahtuu niin, että käyttäjä klikkaa ruutua, johon haluaa laittaa numeron, ja syöttää sitten näppäimistöllä tiedon siitä, minkä numeron siihen haluaa laittaa. Tällöin numero ilmestyy näkyviin ruudukkoon. Valmiiksi annettuja numeroita ei voi muuttaa, ja ne on merkitty erivärisinä, jotta ne erottaa.

### Jatkokehitysideoita
- Voitaisiin luoda lisää vaikeustasoja (esimerkiksi 6x6-sudokut, joissa katsotaan vain, ettei samoilla riveillä tai sarakkeilla ilmene samaa numeroa useasti).
	- Tällöin voitaisiin aloitusnäyttöön laittaa pelaamista varten yleisesti _Pelaa_-nappi, jota painamalla käyttäjä pääsisi valitsemaan vaikeustason ja sudokun koon.
	- Myös ennätyksiä olisi nyt erikseen eri sudokukokoihin ja vaikeustasoihin.
- Peliin voitaisiin lisätä ääniefektejä.
- Voitaisiin mahdollistaa pelitilanteen tallentaminen.
- Käyttäjälle voitaisiin antaa mahdollisuus valita sudokun ja näkymän taustan väri.
- Käyttäjälle voitaisiin antaa mahdollisuus valita ikkunan automaattinen koko.
- Tulostietojen tietokanta voitaisiin tallentaa jatkossa käyttäjän valitsemaan sijaintiin.


