# Sudoku

Sovellus on perinteinen sudokupeli, jota pystyy pelaamaan ilman sisäänkirjautumista. Sovellus generoi käyttäjälle pelejä, joiden suoritusajasta se pitää kirjaa. Suoritusajan perusteella parhaat suoritukset luetellaan ennätyksissä, mikäli käyttäjä haluaa suorituksensa tallentaa. Ennätyksiä on mahdollista tarkastella sovelluksessa. Tarkempi kuvaus löytyy sovelluksen määrittelydokumentista.

### Dokumentaatio

##### Vaatimusmäärittely:
[Määrittelydokumentti](/dokumentaatio/maarittelydokumentti.md)

##### Työaikakirjanpito:
[Työaikakirjanpito](/dokumentaatio/tyoaikakirjanpito.md)

##### Arkkitehtuurikuvaus
[Arkkitehtuurikuvaus](/dokumentaatio/arkkitehtuurikuvaus.md)

##### Testausdokumentti
[Testausdokumentti](/dokumentaatio/testaus.md)

##### Käyttöohje
[Käyttöohje](/dokumentaatio/kayttoohje.md)


### Releaset
[Viikko 5](https://github.com/fannif/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/fannif/ot-harjoitustyo/releases/tag/viikko6)

[Loppupalautus](https://github.com/fannif/ot-harjoitustyo/releases/tag/loppupalautus)


### Komentorivitoimintoja

##### Testien ajaminen:
`mvn test`

##### Testikattavuuden selvittäminen:
`mvn test jacoco:report`

Komento kertoo testien rivi- ja haaraumakattavuuden. Kattavuusraportti löytyy tiedostosta target/site/jacoco/index.html.

##### Jar-tiedoston generointi:
`mvn package`

Komento luo target-hakemistoon kaksi jar-tiedostoa, joista suoritettava on Sudoku-1.0-SNAPSHOT.jar.

##### Projektin koodin suorittaminen:
`mvn compile exec:java -Dexec.mainClass=sudoku.ui.UserInterface`

##### Checkstyle-raportti:
`mvn jxr:jxr checkstyle:checkstyle`

Komento luo target-kansioon projektista Checkstyle-raportin (target/site/checkstyle.html), jonka voi avata selaimella, sekä tulostaa terminaaliin tyylivirheiden määrän.

##### Javadocin generointi:
`mvn javadoc:javadoc`

Komento generoi projektin JavaDocin. Se luodaan sijaintiin target/site/apidocs/index.html.

