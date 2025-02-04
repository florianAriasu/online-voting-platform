## Tema 1 POO

#### Clase utilizate
In aceasta tema am creat urmatoarele clase:

- Alegeri
- Circumscriptie
- Persoana (care este o clasa abstracta)
- Candidat (mosteneste persoana)
- Votant (mosteneste persoana)
- Vot
- FunctiiAuxiliare (este o clasa ce contine toate metodele scurte pentru verificari erori de orice tip)
- ManagerGeneralAlegeri (aceasta clasa este clasa `main` in sensul ca reprezinta nucleul aplicatiei)
- StagiuAlegeri (este un enum cu cele trei tipuri de stagii ale votarii)

#### Clase precizate in enunt, dar pe care nu le-am creat
- Frauda
- Analiza

```
 Tin sa precizez ca nu am creat aceste clase, deoarece toata implementarea gandita de mine este in ManagerGeneralAlegeri si nu am avut nevoie pentru punctajul cumulat
```

#### Descriere functionalitati

###### Structuri de date folosite
- HashMap<,>
- ArrayList<>

###### Clase
- Am folosit o clasa tip `manager`, deoarece as fi creat o instanta a unui obiect de tip alegeri in mod redundant la intalnirea oricarei erori din enuntul temei
- Aici am toate metodele necesare pentru a implementa functionalitatea temei(in functie de punctajul obtinut de mine)
- In clasa `Alegeri` am definite variabilele necesare + constructor + getter-e si setter-e
- Toate celelalte clase au acelasi tipar precum `Alegeri`
- `Enum-ul` l-am definit pentru a nu transmite ca argument la apelul functiilor si tipul de stagiu ca String. Nu este neaparat nevoie, ci asa m-am gandit sa implementez
- `Persoana` este o clasa abstracta, deoarece nu creez in mod explicit o persoana, ci doar `votanti` sau `candidati`
- Clasele `Votant` si `Candidat` extind clasa parinte `Persoana`

###### Citirea
- `Citirea` am facut-o cu ajutorul unui HashMap<>, dar care are valori duplicate, deoarece si comenzile se pot repeta pentru testarea erorilor
- Citesc linie cu linie si populez HashMap-ul, iar apoi doar il parcurg si extrag valorile, valorile fiind comenzile din AppTest.java

###### Apelare metode
- Am folosit un `switch`, astfel incat sa am codul cat mai bine formatat in functie de ce metoda vreau sa apelez si este posibil sa fie mai lizibil codul astfel
- Cand intalneste comanda de `exit` si anume `18` iese direct din metoda Run()

###### Concepte POO folosite
- Am folosit doar 3/4 concepte POO, si anume: `encapsulare`, `mostenire`, `abstractizare`
- `Encapsulare`: acest concept l-am folosit pentru ca am folosit variabile private per clasa cu constructori publici
- `Abstractizare`: Am clasa `Persoana` care este abstracta, deoarece nu creez niciodata o instanta explicit persoana, ci `candidat` sau `votant`
- `mostenire`: Datorita faptului ca folosesc abstractizare si pentru ca folosesc super() in constructor. Am o relatie de tipul is-a.
- Nu am folosit polimorfism, deoarece nu am suprascris nicio metoda si nu am toata implementarea corecta, astfel incat rezultatul este 70/80 puncte

###### Punctaj partial
- Am obtinut punctaj partial pe aceasta tema, desi codul meu ar trebui sa acopere toate cazurile din cerinta
- Am diferite bug-uri cand adaug voturile in lista de voturi sau votantii in lista de votanti, astfel incat nu functioneaza listarea in niciun caz din implementarea ultimelor metode

###### Comentarii
- Nu am adaugat comentarii in cod pentru a nu il supraincarca
- Am avut grija sa folosesc numele de variabile, metode, clase doar intr-o singura limba(lb. Romana) si sa folosesc reguli de formatare a codului general cunoscute in Java, astfel incat sa fie totul cat mai organizat si coerent
- Am avut in vedere sa fiu cat mai explicit in numele variabilelor si a metodelor, astfel incat sa nu trebuiasca sa supraincarc codul adaugand si comentarii

###### Bonus
- AppTest.java poate fi imbunatatit, deoarece nu tine cont de ordinea afisarii rezultatului, prin urmare `toate sortarile` in functie de CNP sau numar de voturi sunt `redundante`
- Acest lucru se intampla pentru ca este folosita metoda contains()
- Ca solutie m-am gandit ca rezultatul poate fi scris tot block si nu secvential, cu rezultate unul dupa celalalt
- De asemenea, as implementa si o functionalitate, astfel incat sa vad cu adevarat cine este votant frausulos, deoarece si cei neindemanatici ar fi catalogati ca fiind fraudulosi, in caz de incearca a doua oara sa voteze, votul lor necontand prima oara, pe cand la votantii fraudulosi ei chiar sunt la al doilea vot
  
