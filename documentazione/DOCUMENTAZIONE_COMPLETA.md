# Documentazione Progetto Adapter List (CLDC 1.1)

## 1. Descrizione del Progetto

### 1.1 Obiettivo
Implementazione di un adapter per l'interfaccia List di J2SE 1.4.2 utilizzando la classe Vector di CLDC 1.1 come adaptee. Il progetto è sviluppato seguendo la metodologia Test Driven Development (TDD) e include una suite completa di test JUnit.

### 1.2 Struttura del Progetto
```
.
├── src/
│   ├── myAdapter/           # Package dell'implementazione
│   │   ├── HCollection.java
│   │   ├── HList.java
│   │   ├── HIterator.java
│   │   ├── HListIterator.java
│   │   └── ListAdapter.java
│   └── myTest/             # Package dei test
│       ├── ListAdapterTest.java
│       └── TestRunner.java
├── JUnit/                  # Framework JUnit
│   └── junit.jar
└── documentazione/         # Documentazione
    ├── javadoc/
    └── TEST_DOCUMENTATION.pdf
```

### 1.3 Ambiente di Sviluppo
- Java Development Kit: JDK 17.0.10
- JUnit Version: 3.8.1
- Target Compatibility: CLDC 1.1

## 2. Documentazione dei Test

### 2.1 Test Case Documentation (Template from Table 1)

#### ListAdapterTest

##### Summary
Test case completo per la verifica dell'implementazione dell'adapter List. Verifica tutte le funzionalità richieste dall'interfaccia List di J2SE 1.4.2, incluse le optional operations e il comportamento degli iteratori.

##### Test Case Design
- Approccio Test-Driven Development
- Test di tutti i metodi dell'interfaccia List
- Verifica delle eccezioni previste
- Test degli iteratori e delle loro funzionalità
- Verifica della compatibilità con CLDC 1.1

##### Pre-Condition
- JUnit 3.8.1 installato e configurato
- Implementazione completa delle interfacce (HList, HCollection, HIterator, HListIterator)
- Implementazione della classe ListAdapter
- Ambiente Java configurato correttamente

##### Post-Condition
- Tutti i test eseguiti con successo
- Verifica della corretta implementazione di tutte le funzionalità
- Conformità con la specifica J2SE 1.4.2
- Mantenimento della compatibilità con CLDC 1.1

##### Expected Results
- Tutti i test method passano con successo
- Le eccezioni sono lanciate nei casi previsti
- Il comportamento è conforme alla documentazione J2SE 1.4.2
- Gli iteratori funzionano correttamente
- Le optional operations sono implementate correttamente

### 2.2 Test Method Documentation (Template from Table 2)

#### Test Method: testAdd
##### Summary
Verifica il corretto funzionamento del metodo add() dell'interfaccia List.

##### Test Method Design
- Test dell'aggiunta di elementi in posizioni specifiche
- Verifica del ridimensionamento automatico
- Test dei casi limite (null, indici invalidi)
- Verifica dell'ordine degli elementi

##### Pre-Condition
- Lista vuota inizializzata
- Elementi di test preparati

##### Post-Condition
- Lista contenente gli elementi nell'ordine corretto
- Dimensione della lista aggiornata

##### Expected Results
- Elementi aggiunti correttamente
- Ordine mantenuto
- Eccezioni appropriate lanciate per input invalidi

#### Test Method: testRemove
##### Summary
Verifica la corretta implementazione del metodo remove().

##### Test Method Design
- Test della rimozione per indice
- Test della rimozione per oggetto
- Verifica del comportamento con elementi null
- Test dei casi limite

##### Pre-Condition
- Lista popolata con elementi di test
- Presenza di elementi duplicati e null

##### Post-Condition
- Elementi rimossi correttamente
- Struttura della lista mantenuta
- Dimensione aggiornata

##### Expected Results
- Rimozione corretta degli elementi
- Restituzione dell'elemento rimosso
- Gestione appropriata degli errori

#### Test Method: testIterator
##### Summary
Verifica del corretto funzionamento degli iteratori.

##### Test Method Design
- Test delle operazioni base (next, hasNext)
- Verifica delle operazioni di rimozione
- Test del comportamento con modifiche concorrenti
- Verifica dei casi limite

##### Pre-Condition
- Lista popolata con elementi
- Iteratore inizializzato

##### Post-Condition
- Iterazione completata
- Modifiche applicate correttamente
- Stato della lista consistente

##### Expected Results
- Iterazione corretta attraverso gli elementi
- Rimozioni tramite iteratore eseguite correttamente
- Eccezioni appropriate per modifiche concorrenti

## 3. Informazioni sul Framework di Test
- Framework: JUnit
- Versione: 3.8.1
- Locazione: JUnit/junit.jar
- Esecuzione: Tramite TestRunner da riga di comando

## 4. Note Implementative
- L'implementazione è thread-safe solo per le operazioni atomiche
- Non è implementato il comportamento fail-fast per gli iteratori
- Tutte le optional operations sono supportate
- La compatibilità con CLDC 1.1 è mantenuta utilizzando solo le funzionalità disponibili in tale versione 