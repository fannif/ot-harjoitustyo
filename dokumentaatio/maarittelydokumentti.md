## Sudoku: Alustava määrittelydokumentti

### Sovelluksen tarkoitus
Sovellus on peli. Siinä on tarkoitus täyttää 9x9 -kokoisia ruudukoita numeroilla yhdestä yhdeksään niin, että kullakin vaaka- ja pystyrivillä on kukin numero vain kerran. Ruudukko koostuu myös yhdeksästä 3x3:n ruudun pikkuruudukoista, joissa kussakin saa olla kukin luku yhdestä yhdeksään vain kerran.

### Käyttäjät
Kyseessä on peli, johon ei tarvita muita käyttäjärooleja kuin _normaali käyttäjä_.

### Perusversion toiminnallisuudet
- Alkunäytössä, joka aukeaa, kun sovellus käynnistetään, käyttäjä pystyy valitsemaan, haluaako hän katsoa aiempia ennätyksiä vai pelata
- Jos valittiin edellisestä näytöstä ennätykset, niin sovellus listaa kymmenen parasta tulosta ja niiden tekijöiden antamat nimimerkit. Tästä voi myös palata alkunäyttöön.
- Jos valittiin pelit, niin sovellus tuottaa käyttäjälle uuden sudokun täytettäväksi. Käyttäjä voi halutessaan palata täältä alkunäyttöön.
- Pelatessaan käyttäjä voi halutessaan laittaa sovelluksen tuottamaan uuden sudokun tai tarkistamaan nykyisen sudokun. Mikäli nykyinen sudoku on oikein, ja saatu aika on tarpeeksi hyvä, käyttäjä voi antaa kolmemerkkisen nimimerkin, minkä jälkeen hänen tuloksensa tallennetaan ennätyksiin. Jos sudoku meni väärin, sovellus ilmoittaa siitä, ja käyttäjä voi jatkaa yrittämistä.
- Sudokun täyttäminen tapahtuu niin, että käyttäjä klikkaa ruutua, johon haluaa laittaa numeron, ja syöttää sitten tiedon siitä, minkä numeron siihen haluaa laittaa. Tällöin numero ilmestyy näkyviin ruudukkoon. Valmiiksi annettuja numeroita ei voi muuttaa, ja ne on voitu esimerkiksi merkitä erivärisinä, jotta ne erottaa.

### Jatkokehitysideoita
- Voitaisiin luoda toinenkin vaikeustaso (esimerkiksi 6x6-sudokut, joissa katsotaan vain, ettei samoilla riveillä tai sarakkeilla ilmene samaa numeroa useasti)
	- Tällöin kun aloitusnäytöstä valittaisiin _Pelaa_, niin seuraavaksi käyttäjä pääsisi valitsemaan vaikeustason
	- Myös ennätyksiä olisi nyt erikseen eri vaikeustasoihin
- Peliin voitaisiin lisätä ääniefektejä
- Voitaisiin mahdollistaa pelitilanteen tallentaminen
- Käyttäjälle voitaisiin antaa mahdollisuus valita sudokun taustan väri


