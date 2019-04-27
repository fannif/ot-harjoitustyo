## Testausdokumentti
Sovelluksen testaus koostuu isolta osaa itsekirjoitetuista automaattisesti ajetuista JUnit-testeistä. Kyseisillä testeillä on testattu sovelluksen kaikkia luokkia käyttöliittymää lukuunottamatta. Käyttöliittymää, ja osittain siinä samalla myös muita sovelluksen osia, on testattu sovellusta käyttämällä ja siten erilaisia käyttötilanteita simuloimalla.

### JUnit-testit
#### Sovelluslogiikka
Suurin osa automaattisesti ajettavista JUnit-testeitsä testaa ohjelman sovelluslogiikkaa. Sovelluslogiikka on pakkauksessa sudoku.domain, jota testaavat testipakkauksessa sudoku.domain olevat testiluokat ScoreTest ja SudokuTest.

ScoreTest-luokassa pyritään testaamaan mahdollisimman kattavasti Score-luokan metodien oikeanlainen toimivuus. SudokuTest puolestaan testaa Sudoku-luokan metodeja. Kummassakin testiluokassa on ollut tarkoituksena käydä läpi testattavan luokan kaikki metodit konstruktorista lähtien niin, että on samalla tarkasteltu erilaisia haarautumisia.

#### DAO
EasyScoreDao- ja NormalScoreDao-luokkien toimintaa on testattu testipakkauksen sudoku.dao testiluokissa. Testausta varten luodaan oma testitietokanta, mitä varten DAO-luokkiin on tehty metodi tietokannan vaihtamista varten. Testitietokantaa kohdellaan kuin sovelluksen varsinaista tietokantaa, jotta DAO-luokkien metodit saataisiin hyvin testattua. Testien ajamisen jälkeen testitietokanta tyhjennetään siltä varalta, että samaa tietokantaa käytetään seuraavankin kerran testaukseen.

#### Testikattavuus
Tällä hetkellä sovelluksen DAO-puolen rivikattavuus on 90 prosenttia ja haarautumakattavuus 100 prosenttia. Sovelluslogiikan rivikattavuus on 98 prosenttiaa ja haarautumakattavuus 95 prosenttia. Käyttöliittymää lukuunottamatta sovelluksen kokonaisrivikattavuus on 96 prosenttia ja haarautumakattavuus 95 prosenttia.

DAO-puolella testaamattomat tilanteet ovat sellaiset, joissa käsitellään SQLException. Sovelluslogiikan puolelta testaamatta jäi Sudoku-luokasta tilanne, jossa fillRestOfGrid-metodissa ollaan alussa jo käsitelty kaikki sudokun jäljellä olleet ruudut.

### Manuaalinen testaus
Sovelluksen käyttöliittymää testattiin manuaalisesti käyttämällä ohjelmaa, ja kokeilemalla käydä läpi erilaisia tilanteita, joita sovelluksen käytössä voi syntyä. Samalla testattiin sovelluksen toimivuutta kokonaisuutena. Näin suoritettiin siis järjestelmätestaus.

#### Asennnus
Ohjelmaa on testattu simuloimalla tilannetta, jossa sovellus ladattiin netistä asennusohjeen mukaisesti. Testauksessa ei kohdattu ongelmia. Samalla kokeiltiin myös, että sovellus osaa luoda itse käyttöönsä tietokannan, mikäli sitä ei ole vielä olemassa käyttöohjeessa määritellyssä sijainnissa, ja että sovellus osaa myös käyttää oikeanmuotoista tietokantaa, mikäli se puolestaan löytyy oikeasta sijainnista.

#### Toiminnallisuus
Sovelluksen kaikki toiminnallisuudet pyrittiin käymään testauksessa mahdollisimman tarkasti läpi. Kokeilemalla varmistettiin myös, ettei ennätystä tallennettaessa tule virhetilannetta, jos käyttäjä yrittää syöttää liian pitkän tai lyhyen nimimerkin, ja ettei sudokun tarkistuksessa tule virhetilannetta, jos käyttäjä on syöttänyt sudokuun epäkelpoja arvoja.

### Sovelluksen laatuongelmat
Testauksessa käytetty testitietokanta ei ole tilapäinen tiedosto. Niinpä mikäli sen olemassa olo häiritsee, sen joutuu poistamaan aina testien ajamisen jälkeen itse uudestaan. Kuitenkaan kooltaan se ei ole iso, joten sen tilanviennin ei pitäisi olla ongelma.

Sovellukseen ei ole ohjelmoitu juurikaan varsinaisia virheilmoituksia. Ainoat virheilmoituksen tyyliset ilmoitukset liittyvät virheelliseen nimimerkkiin sitä syöttäessä sekä väärin menneeseen sudokuun. Tämä johtuu siitä, että sovellusta testatessa ei olla törmätty varsinaisiin virheilmoitusta vaativiin virheisiin. Kuitenkin on mahdollista, että jokin virhe, jolle olisi hyvä olla virheilmoitus, on jäänyt huomaamatta.

Sovelluksen käytön kannalta graafisen käyttöliittymän toteutus sudokuruudukosta ei välttämättä ole kaikille mieluinen. Nyt ruudukon täyttämiseen vaaditaan hiiren käyttöä, kun voisi olla mukavampi pystyä liikkumaan sudokuruudokossa ruudusta toiseen esimerkiksi nuolinäppäinten avulla niin, ettei hiirtä tarvittaisi. Myös sudokuruudukon aliruudukkojen värien eri on melko pieni, ja sudokussa voikin olla vaikea erottaa, missä kohdassa aliruudukko vaihtuu.
