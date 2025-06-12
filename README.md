# Adapter List CLDC 1.1

Implementazione di un adapter per l'interfaccia List di J2SE 1.4.2 utilizzando la classe Vector di CLDC 1.1.

## Struttura del Progetto

```
.
├── src/
│   ├── myAdapter/    # Package contenente l'implementazione dell'adapter
│   └── myTest/       # Package contenente i test
└── JUnit/            # Directory contenente junit.jar
```

## Requisiti

- Java Development Kit (JDK)
- La directory JUnit deve contenere il file junit.jar (versione utilizzata: 3.8.1)

## Compilazione e Test

1. **Compilazione del progetto**:
   ```bash
   javac -cp "JUnit/junit.jar" src/myAdapter/*.java src/myTest/*.java
   ```

2. **Esecuzione dei test**:
   ```bash
   java -cp "JUnit/junit.jar;src" myTest.TestRunner
   ```

   L'output dei test mostrerà:
   - Il numero di test eseguiti (indicato dal numero di punti ".")
   - Il tempo di esecuzione
   - Il risultato complessivo (OK se tutti i test passano)

## Test Suite

La test suite segue il template "Homework" come specificato nella consegna e include:

- Summary: Descrizione dettagliata della test suite
- Test Suite Design: Descrizione del design della test suite
- Pre-Condition: Informazioni necessarie prima dell'esecuzione
- Post-Condition: Informazioni che devono essere vere dopo l'esecuzione
- Expected Results: Condizioni per il successo della test suite
- Test Cases: Casi di test implementati

Ogni test case è documentato secondo il template "Homework" e include:
- Summary
- Pre-Condition
- Post-Condition
- Expected Results

## Note Importanti

- Il progetto è stato sviluppato per essere compatibile con CLDC 1.1
- L'implementazione segue le specifiche dell'interfaccia List di J2SE 1.4.2
- Tutti i test sono documentati secondo il template "Homework"
- Non è implementata la thread safety in quanto non richiesta
- Non è implementato il comportamento fail-fast degli iteratori per modifiche concorrenti

## Author
[Your Name] 