# Java List Adapter (CLDC 1.1)

Implementazione di un adapter per l'interfaccia List di J2SE 1.4.2 utilizzando la classe Vector di CLDC 1.1.

## Requisiti di Sistema

- Java Development Kit (JDK) versione 1.4.2 o superiore
- Apache Ant (opzionale, per build automatizzato)

## Struttura del Progetto

```
.
├── src/
│   ├── myAdapter/    # Package contenente l'implementazione dell'adapter
│   └── myTest/       # Package contenente i test
├── lib/              # Directory per le dipendenze
│   └── junit.jar     # JUnit framework
├── build/           # Directory per i file compilati
└── build.xml        # File di configurazione Ant
```

## Setup dell'Ambiente

1. **Installazione JDK**:
   - Scarica e installa il JDK da [Oracle](https://www.oracle.com/java/technologies/downloads/)
   - Aggiungi JAVA_HOME alle variabili d'ambiente
   - Aggiungi %JAVA_HOME%/bin al PATH

2. **Setup JUnit** (se non presente):
   - Scarica junit.jar da [JUnit Archive](https://search.maven.org/artifact/junit/junit/3.8.1/jar)
   - Copia junit.jar nella directory `lib/` del progetto

## Compilazione e Test

### Usando il Terminale (Metodo Manuale)

1. **Compilazione**:
   ```bash
   # Crea la directory build se non esiste
   mkdir build

   # Compila i sorgenti
   javac -d build -cp "lib\junit.jar;src" src\myAdapter\*.java src\myTest\*.java
   ```

2. **Esecuzione dei Test**:
   ```bash
   java -cp "build;lib\junit.jar" myTest.TestRunner
   ```

### Usando Apache Ant (Opzionale)

1. **Installazione Ant**:
   - Scarica Apache Ant da [ant.apache.org](https://ant.apache.org/)
   - Aggiungi ANT_HOME alle variabili d'ambiente
   - Aggiungi %ANT_HOME%/bin al PATH

2. **Comandi Ant**:
   ```bash
   # Compila il progetto
   ant compile

   # Esegui i test
   ant test

   # Genera la documentazione
   ant javadoc

   # Pulisci i file generati
   ant clean
   ```

## Note Aggiuntive

- Il progetto è stato sviluppato per essere compatibile con CLDC 1.1
- L'implementazione segue le specifiche dell'interfaccia List di J2SE 1.4.2
- Tutti i test sono documentati secondo il template "Homework"

## Author
[Your Name] 