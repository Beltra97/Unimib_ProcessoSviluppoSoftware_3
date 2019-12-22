# 2019_assignment3_JobSocialNetwork

## Applicazione  

L'applicazione JobSocialNetwork, scritta in Java, è un nuovo social network 
pensato per il mondo lavorativo, in cui le aziende possono ricercare profili 
interessanti e viceversa.

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

- User(Id, FirstName, LastName, Gender, BirthDate, ResidentialAddress)  
- FriendsOf(<u>User1</u>, User2, CreationDate)  
- Company(Id, Name, CEO, Description, NumEmployees, FoundationYear, LegalAddress)  
- JobType(Id, Name, Description, Category)  
- Works(User, Company, JobType, Salary, StartDate, EndDate)  
- Address(Id, Street, Municipality, CivicNumber, CAP, State)  
