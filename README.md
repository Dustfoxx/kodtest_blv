# kodtest_blv

## Funktionaliteter baserat på User Stories
- Initialisera databasen med REST Countries API. 
- Endpoint som ger alla tillgängliga länder.
    - Stödjer paginering.
    - Filtrering enligt region (Europa, Asien)
    - ASC/DESC sortering på både namn och befolkningsmängd.
- Endpoint som lägger till användare.
- Markering och avmarkering av besökta länder.
- Lägga till anteckning som kopplas till besöket.
- CRUD för de tre ovan.
- Lista länder med anteckningar som en specifik användare besökt.
## Antaganden
Uppgiften specifierar att programmet inte ska agera mellanhand till REST Countries API men däremot hävdar User Story 1 att programmet vid initiering ska hämta datan därifrån. Mitt antagande är därför att ett kommando ska hämta datan och därmed agera mellanhand men resterande endpoints ska endast agera inom den egna databasen.