# Jelszóellenőrző Rendszer

## Feladat

Egy jelszóellenőrző rendszert készítünk itt a banknál, és ahhoz, hogy szuperbiztonságossá tegyük jelszavak helyett, jelmondatokat használunk. 
A jelmondatok nagyon hasonlítanak a jelszavakhoz, annyiból jobbak, hogy szavakat tartalmaznak, szóközzel elválasztva és a végére egy írásjel kerül (? vagy ! vagy .)

A feladatod az, hogy hozz létre magadnak egy `input.txt` nevű fájlt (van egy minta lentebb, de nem csak arra kell működnie), és írj egy programot, ami beolvassa (minden jelmondat új sorban van) és megszámolja hány darab helyes jelmondat van benne, és ezt kiírja a standard outputra (konzol). 
A programodat készítsd el legjobb tudásod szerint, törekedj a tiszta és jól olvasható kódra. 
Ha van tapasztalatod tesztelésben, teszteket is mellékelhetsz. Bármilyen programozási nyelvet használhatsz a feladat megoldásához (nem ér semmi hátrány ha pl a Javascript a “legerősebb” nyelved), de preferáld kérlek a Java-t vagy a Python-t, ha magabiztos vagy bennük.

## Mi számít helyes jelmondatnak

- Több mint egy szóból áll (szóköz választja el a szavakat)
- Van írásjel (! ? .) a végén
- Nem fordul elő benne többször ugyanaz a szó
- A szavak csak az angol ABC betűit tartalmazzák
- A szavak csak kisbetűvel írhatóak

## Nem kell ellenőrizni

- A bemenet értelmes magyar szó-e

## Példa input.txt

```plaintext
alma korte!
szilva.
citrom lime
korte korte?
dinnye, ananasz, fuge.
Alma Korte!
```

## Feldolgozás

- alma korte! - helyes input (+1)
- szilva. - helytelen input, csak 1 szóból áll
- citrom lime - helytelen input, nincs írásjel a végén
- korte korte? - helytelen input, ugyanaz a szó többször fordul elő benne
- dinnye, ananasz, fuge - helytelen input, nem megengedett karakter van benne (,)
- Alma Korte! - helytelen input, nem csak kisbetűk vannak benne

## Output
- Helyes jelmondatok szama: 1