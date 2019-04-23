# Arkkitehtuurikuvaus

### Rakenne
Sovelluksen rakenne koostuu erillisissä paketeissa olevista käyttöliittymästä, DAO:sta ja sovelluslogiikasta. Käyttöliittymään liittyvä koodi on paketissa sudoku.ui, sovelluslogiikan koodi paketissa sudoku.domain ja DAO-koodi paketissa sudoku.dao. DAO-paketin koodi tulee vastaamaan tietojen pysyvästä tallentamisesta tietokantaan.

### Käyttöliittymä
Sovelluksen graafinen käyttöliittymä on luokassa sudoku.ui.UserInterface. Kaikki käyttöliittymän koodi on siis samassa luokassa sudoku.ui paketissa.

Käyttöliittymä sisältää kolme päänäkymää. Ensimmäinen näkymä on käynnistyksessä avautuva valikko, jossa käyttäjä pääsee valitsemaan, haluaako hän pelata vai tarkastella ennätyksiä. Yhteensä nappeja on valikossa kolme: napit helppoon sudokuun, normaaliin sudokuun ja ennätyksiin.

Toinen näkymä on pelinäkymä, jossa sudokua täytetään. Näkymässä on ylhäällä napit takaisin palaamiseen, uuden sudokun pyytämiseen ja sudokun tarkistamiseen. Keskellä ikkunaa on itse sudokuruudukko, jonka tyhjien ruutujen määrä riippuu vaikeustasosta. Yläoikealle ilmestyy sudokua tarkistettaessa tieto siitä, menikö sudoku oikein. Mikäli meni, tulee oikeaan yläkulmaan näkyviin myös sudokuun käytetty kokonaisaika, sekä mahdollisuus tuloksen tallentamiseen.

Kolmas näkymä näyttää tietokannasta haettavia ennätyksiä. Näkymän yläkulmassa on nappi takaisin alkuvalikkoon. Keskellä on 0 - 10 nopeinta suoritusaikaa sekä helpolle että normaalille sudokulle. Mikäli suorituksia on tallennettu jompaan kumpaan tietokantatauluun alle kymmenen, ne ovat kyseisen tietokantataulun kohdalla kaikki näkyvillä, ja jos niitä on yli kymmenen, niin vain parhaat kymmenen tulost näkyvät. Jos tuloksia ei ole yhtään, lukee tulosten kohdalla niin.

Jokainen graafisen käyttöliittymän kolmesta näkymästä on oma Scene-olionsa. Stage-olioita on vain yksi. Kukin näkymä sijoitetaan näkyväksi Stage-olioon oikeaa nappia painaessa, tai ensimmäisen näkymän tapauksessa myös heti ohjelman käynnistyttyä.

Sovelluslogiikkaa on yritetty sisältää käyttöliittymään mahdollisimman vähän. Tarkoituksena oli, ettei käyttöliittymään jäisi sovelluslogiikkaa. Käyttöliittymä on yhteydessä sovelluslogiikkaan niin, että se vaihtaa tietoa Sudoku-luokan kanssa sen metodien välityksellä. Käyttöliittymässä myös käytetään Score-olioita ennätysten viemiseen DAO-olioille, joita tarvitaan tulosten tallentamiseen.

### Sovelluslogiikka
Sovelluslogiikka koostuu sudokuruudukkoa esitteävästä luokasta Sudoku sekä pelitulosta esittävästä luokasta Score. Sudokulla on oliomuuttujana itse ruudukkoa esittävä kaksiulotteinen taulukko. Sudoku-luokan tehtävä on sudokuruudukon numeroiden hallinnoiminen. Sen avulla täytetään pelattava sudoku sekä huolehditaan sen tyhjentämisestä ja tarkastamisesta.

Scorella on oliomuuttujina id, alkukirjaimet ja suoritusaika tietokantaan tallentamista varten. Sudoku ei tiedä mitään pelituloksista, eivätkä pelitulokset sudokusta. Luokkakaavio:

![Luokkakaavio](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuLuokkakaavio1904.png "Luokkakaavio")


Score-luokalla on yhteys molempiin käyttöliittymässä käytössä oleviin DAO-olioihin, koska DAO:n kautta tietokantaan tallennetaan riveja Score-olioiden tietojen perusteella. Rivit myös tuodaan tietokannasta niin, että luodaan niitä vastaavat Score-oliot.

Sovelluslogiikan, DAO-puolen ja käyttöliittymän luokkien välisiä suhteita kuvaava luokka-/pakkauskaavio:

![Pakkauskaavio](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuPakkauskaavio1904.png "Pakkauskaavio")

### DAO ja tietojen tallennus
DAO-puolen (siis pakkauksen sudoku.dao) luokkien EasyScoreDao ja NormalScoreDao tehtävänä on sudokutulosten pitkäaikaistallennus tietokantaan. EasyScoreDao tallentaa omaan tauluunsa helpon vaikeusasteen sudokuihin liittyviä tuloksia ja NormalScoreDao puolestaan omaansa normaalin vaikeusasteen tuloksia.

DAO-luokissa on myötäilty normaalia Data Access Object -mallia. Niissä on metodit rivien lisäämiseen tietokantatauluun ja taulun kaikkien rivien listaamiseen järjestyksessä suoritusajan mukaan. Kumpikin EasyScoreDao- ja NormalScoreDao-luokista käyttävät rajapintaa SQLDao. Testausta varten kumpaankin DAO-tyyppiin on lisätty metodi, jolla kohde tietokannaksi voi vaihtaa testitietokannan.

Tulostietojen tallennus tapahtuu SQL-tietokantaan, jonka DAO-luokat luovat tarvittaessa, mikäli sitä ei löydy. Linux-koneissa tietokannan oletetaan olevan samassa kansiossa sovelluksen kanssa, kun taas Windows-koneilla tietokantaa haetaan ja luodaan käyttäjän omaan ylähakemistoon. Tietokannassa on kunkin tuloksen kohdalla itsestään generoituva id, tuloksen saajan antamat nimikirjaimet sekä sudokun suoritusaika.

### Oleellisia toiminnallisuuksia
Ehkä tärkeimmät toiminnallisuudet sudokupelin ydintoiminnan kannalta ovat uuden sudokun generoiminen ja tehdyn sudokun tarkastaminen. Varsinkin ensimmäinen näistä kahdesta on välttämätön, jotta peliä voi pelata sovelluksessa.

Käyttäjälle generoidaan uusi sudoku, kun hän pyytää sitä painamalla alkuvalikon jompaakumpaa play-nappia, tai kun hän pelinäkymässä klikkaa nappia uuden sudokun generoimiseksi. Käyttäjän pyytäessä uutta sudokua (tässä tapauksessa painamalla pelinäkymän nappia), toiminnallisuus etenee seuraavasti:
![Uuden sudokun generoiminen](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuSekvenssikaavioUusiSudoku.png "Uuden sudokun generoiminen")

Napin painalluksen jälkeen siis käyttöliittymä kutsuu Sudoku-luokan omaa uuden sudokun rakentamiseen tarkoitettua metodia. Sudoku-luokan newSudoku-metodi tyhjentää ensin ruudukkonsa ja täyttää sitten kolme-kertaa-kolme-kokoiset aliruudukot ylävasemmalta, keskeltä ja alaoikealta. Tämän jälkeen se kutsuu toista metodiaan täyttämään loput ruudut ja kolmatta korvaamaan osan ruuduista nollilla, jotka kuvaavat tyhjiä ruutuja. Uusi sudoku täytetään ensin kokonaan, jotta voidaan olla varmoja, että generoitu sudoku on mahdollista ratkaista. Sudokun newSudoku-metodin aikana kutsutaan myös muun muassa isOk-metodia tarkastamaan, että numeroita voidaan laittaa ruutuihin, joihin niitä ollaan laittamassa. Kaiken kaikkiaan uuden sudokun generoinnissa kutsutaan suurinta osaa Sudoku-luokan metodeista. Lopuksi vielä käyttöliittymässä lisätään Sudokusta saadut tiedot visuaalista sudokua kuvaavaan ruudukkoon.

Kun käyttäjä on mielestään tehnyt sudokun, hän voi tarkistaa sen painamalla pelinäkymän tarkistusnappia.
Käyttäjän halutessa tarkistaa sudoku, toiminnallisuus etenee seuraavasti:
![Sudokun tarkistus](https://github.com/fannif/ot-harjoitustyo/blob/master/dokumentaatio/sudokuSekvenssikaavioTarkistaminen.png "Sudokun tarkistus")

Käyttöliittymä siis kutsuu Sudoku-luokan checkSudoku-metodia, joka tarkistaa isOk-metodin avulla, että kussakin sudokun ruudussa on hyväksyttävä arvo. Ennen tätä kuitenkin käyttöliittymä tarkistaa sudokuun syötettyjen arvojen olevan numeroita väliltä 1 - 9 ja kopioi jokaisen visuaaliseen sudokuun lisätyn arvon Sudoku-olion tietoon. Pääosin sudoku-luokan palauttaman totuusarvon perusteella käyttöliittymä kertoo sitten käyttäjälle, oliko hänen ratkaisunsa oikein vai ei.

Sudokun generoimisen ja tarkistamisen lisäksi tärkeimmät toiminnot ovat varmaankin tulosten tallentaminen ja listaaminen. Tuloksen tallentaminen tapahtuu niin, että kun käyttäjä kirjoittaa annettuun tekstikenttään nimikirjaimensa ja painaa lisäämiseen tarkoitettua nappia, niin käyttöliittymä lähettää kyseessä olevaa vaikeustasoa vastaavalle DAO:lle create-metodin parametrina uuden Score-olion, jonka tietona ovat käyttäjän nimikirjaimet ja aika. Listaaminen puolestaan tapahtuu niin, että käyttäjän painaessa alkuvalikossa ennätyksiin vievää nappia, käyttöliittymä kutsuu kummankin DAO:n list-metodia, ja asettaa niistä saamistaan Score-olioista 0 - 10 parhaassa ajassa suoritettua esille tulokset näyttävään näkymään.


### Ohjelman rakenteen heikkoudet
#### Käyttöliittymä
Vaikka käyttöliittymästä onkin pyritty poistamaan sovelluslogiikka, on sitä hiukan jäänyt sinne jäljelle esimerkiksi sudokun tarkastamiseen. Käyttöliittymän koodia voi myöskin olla hiukan haastava ymmärtää ja seurata, koska selvästi suurin osa koodista on yhdessä start-metodissa.

#### DAO-luokat
EasyScoreDao:n ja NormalScoreDao:n toteutukset ovat hyvin samankaltaiset. Niinpä niiden välillä ilmenee toisteisuutta, josta olisi hyvä päästä jotenkin eroon. Ehkä esimerkiksi rajapinnan sijaan niiden kannattaisi molempien periä jokin toinen luokka, jolloin metodeita ei tarvitsisi kirjoittaa molempiin erikseen.

#### Sovelluslogiikka
Sudoku-luokka on luokkana melko iso, ja siinä on yksi hyvin pitkä metodi. Metodi fillRestOfGrid on suositeltua pitempi, mutta se johtuu isolta osaa siitä, että siinä on niin paljon ehtoja. Metodin lyhentäminen tuntuisikin haastavalta juuri, koska siinä vievät paljon tilaa ehdot. Itse Sudoku-luokka jäi näin pitkäksi, koska kaikki siinä olevat metodit liittyvät kuitenkin sudokuun ja sen ylläpitoon. Ehkä sen olisi jotenkin kuitenkin voinut jakaa kahdeksi luokaksi.
