# kodtest_blv
Instruktioner gällande körandet av programmet.
Från root kan ./gradlew build köras och sedan kan ```java -jar build/libs/Countries-0.0.1-SNAPSHOT.jar``` användas för att starta servern.
Med intelliJ räcker det att högerklicka ```src/main/java/kodtest/Countries/CountriesApplication.java``` och välja run från menyn.
När servern körs kan du skicka requests till localhost:8080. En lista med calls finns i ```Test API``` foldern som kan användas med Bruno. Annars följer en lista på samtliga tillgängliga calls.

Användare CRUD
- GET ```/visitors```
    - Hämtar alla användare
- POST ```/visitors```
    - Lägger till en ny användare med requestbody.
    Innehåller ``name``.
- GET ``/visitors/{id}``
    - Hämtar användare med user_id = id
- PUT ``/visitors/{id}``
    - Uppdaterar existerande användare med body. Innehåller ``name``. I det fall användaren inte finns redan skapas en ny.
- DELETE ``/visitors/{id}``
    - Tar bort användare med user_id = id

Notes CRUD
- GET ``/notes/{id}``
    - Hämtar alla notes för en specifik användare
- POST ``/notes``
    - Lägger till en note vilket består av användar_id, ett land_id, och en text.
    ``{user_id: {id}, country_id:{id}, content:"text"}``
- PUT ``/notes/{id}/{content}``
    - Uppdaterar note med id {id} med content.
- DELETE ``/notes/{id}``
    - Tar bort en note med id

Countries
- GET ``/country/{id}``
    - Hämtar land med id
- GET ``countries/all``
    - Hämtar alla länder
- GET ``/countries/{page}/{items_per_page}``
    - Hämtar länder enligt paginering.
- POST ``/countries``
    - Hämtar länder med paginering, sortering enligt population eller namn, ascending eller descending, och med specifik region.
    ``{int page, int items_per_page, String region, boolean population, boolean asc}``


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
Uppgiften specifierar att programmet inte ska agera mellanhand till REST Countries API men däremot hävdar User Story 1 att programmet vid initiering ska hämta datan därifrån. Mitt antagande är därför att ett kommando ska hämta datan och därmed agera mellanhand men resterande endpoints ska endast agera inom den egna databasen. Som det är nu hämtar den automatiskt länder från restcountries när man startar servern. Den lägger också till lite användare.

## Begränsningar 
Då jag inte hann bli klar med programmet i vettig tid så har jag skippat mycket felhantering och tester. De finns på några ställen men inte överallt. POST kommandot för countries har även lite konstig namngivning och jag hade gärna velat göra den lite mer flexibel. I.E. sortera enligt population men skippa pagineringen, eller visa alla länder istället för att tvinga region.
Jag valde också att tolka markeringen av vilka länder man varit i att vara listan med notes då man har en koppling mellan users och länder där. Finns en bit data där användaren kopplas till ett land, då har den även besökt landet. 