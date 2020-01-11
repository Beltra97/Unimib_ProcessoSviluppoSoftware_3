# 2019_assignment3_JobSocialNetwork

## Applicazione  

L'applicazione JobSocialNetwork, scritta in Java, è un nuovo social network 
pensato per il mondo lavorativo, in cui le aziende possono ricercare profili 
interessanti e viceversa.

L'applicazione Spring implementa sia l'architettura MVC,
che la persistenza dei data con Java JPA.

E' presente anche una parte di test in JUnit per verificare la corretta esecuzione
delle operazioni CRUD (CREATE, READ, UPDATE, DELETE) per ogni entità presente.

Dalla homepage raggiungibile all'indirizzo "http://localhost:8080" è possibile
accedere alle varie pagine di gestione delle varie entità.

Nella pagina User è possibile aggiungere un nuovo utente, eliminarne uno utilizzando 
il link e anche modificarlo attraverso la medesima form.
E' possibile cercare un utente per cognome e anche per data di nascita.

Nella pagina AddressUser è possibile aggiungere un nuovo indirizzo di residenza, eliminarne uno utilizzando 
il link e anche modificarlo attraverso la medesima form.
E' possibile cercare un indirizzo per nome della via.

Nella pagina AddressCompany è possibile aggiungere un nuovo indirizzo legale, eliminarne uno utilizzando 
il link e anche modificarlo attraverso la medesima form.
E' possibile cercare un indirizzo per nome della via.

Nella pagina Company è possibile aggiungere un nuova company, eliminarne una utilizzando 
il link e anche modificarla attraverso la medesima form.
E' possibile cercare una company per nome e per CEO.

Nella pagina JobType è possibile aggiungere un nuovo tipo di lavoro, eliminarne uno utilizzando 
il link e anche modificarlo attraverso la medesima form.
E' possibile cercare un jobtype per nome e per descrizione.

Nella pagina Friend è possibile aggiungere un nuova amicizia, eliminarne una utilizzando 
il link e anche modificarla attraverso la medesima form.
E' possibile cercare un'amicizia per data di creazione.

Nella pagina Work è possibile aggiungere un nuovo lavoro, eliminarne uno utilizzando 
il link e anche modificarlo attraverso la medesima form.
E' possibile cercare un lavoro per salario.


## Membri  

Il progetto è stato sviluppato da: Beltramelli Fabio (816912) e Finati Davide (817508)

## Repository  

Il codice sorgente è disponibile su gitlab: https://gitlab.com/davidefinati/2019_assignment3_jobsocialnetwork/

## Branches

Sono stati creati e utilizzati i branch master e develop.

## Modello ER
Il modello ER prevede 6 entità e 4 relazioni, tra cui una self (cioè su se stessa) e una
di generalizzazione is-a.

![ER MODEL](Modello_ER.png)

- Un utente può avere più amicizie con più utenti.
- Un utente vive in un solo indirizzo. 
- In un indirizzo vive un solo utente.
- Una company ha un solo indirizzo legale.
- In un indizzo ci possono essere più company (spazi di co-working).
- Un tipo di lavoro è praticato da più utenti in più company.
- In una company ci sono più utenti che svolgono più lavori.
- Un utente può svolgere piuù lavori in più company su diversi periodi.

## Modello logico

- Address(***Id***, Street, Municipality, CivicNumber, CAP, State, Type)  
- User(***Id***, FirstName, LastName, Gender, BirthDate, ResidentialAddress)  
- FriendsOf(***User1***, ***User2***, CreationDate)  
- Company(***Id***, Name, CEO, Description, NumEmployees, FoundationYear, LegalAddress)  
- JobType(***Id***, Name, Description, Category)  
- Works(***User***, ***Company***, ***JobType***, Salary, StartDate, EndDate)  


## Come eseguire applicazione

Comando per creazione package evitando la compilazione dei test.
```bash
mvnw -Dmaven.test.skip=true clean package spring-boot:repackage
```

Comando per avviare l'applicazione che sarà accessibile all'indirizzo 
[http://localhost:8080](http://localhost:8080)
```bash
java -Djava.security.egd=file:/dev/./urandom -jar target/worksocialmedia.jar
```

Comando per creare un container per l'applicazione
```bash
docker build -t worksocialmedia:0.1.0-SNAPSHOT .
```

Comando per eseguire il container appena creato, anche in questo caso l'applicazione è
accessibile all'indirizzo [http://localhost:8080](http://localhost:8080)
```bash
docker run --rm -p 8080:8080 worksocialmedia:0.1.0-SNAPSHOT
```