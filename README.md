# Sudoku

Sovellus on perinteinen sudokupeli, jota pystyy pelaamaan ilman sisäänkirjautumista. Sovellus generoi käyttäjälle pelejä, joista se pitää yllä suoritusaikaa. Suoritusajan perusteella parhaat suoritukset lisätään ennätyksiin, joita on myös mahdollista tarkastella sovelluksessa. Tarkempi kuvaus löytyy sovelluksen määrittelydokumentista.

### Dokumentaatio

##### Alustava määrittelydokumentti:
[Määrittelydokumentti](/dokumentaatio/maarittelydokumentti.md)

##### Työaikakirjanpito:
[Työaikakirjanpito](/dokumentaatio/tyoaikakirjanpito.md)

##### Alustava arkkitehtuurikuvaus (kesken)
[Arkkitehtuurikuvaus](/dokumentaatio/arkkitehtuurikuvaus.md)


### Releaset
[Viikko 5](https://github.com/fannif/ot-harjoitustyo/releases/tag/viikko5)


### Komentorivitoimintoja

##### Testien ajaminen:
mvn test

##### Rivikattavuuden selvittäminen:
mvn test jacoco:report

##### Jar-tiedoston generointi:
mvn package

##### Projektin koodin suorittaminen:
mvn compile exec:java -Dexec.mainClass=sudoku.ui.UserInterface

##### Rivikattavuuden selvittäminen:
mvn jxr:jxr checkstyle:checkstyle

