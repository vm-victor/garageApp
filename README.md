# GarageApp
Garage-App 

## Setting Up the DB: 

Edit the application.properties in src/main/resources/

```
db.default.driver = org.postgresql.Driver
db.default.ddl = update
db.default.url = jdbc:postgresql://localhost:5432/axelor
db.default.user = postgres
db.default.password = 
```

## Run the App

```
./gradlew --no-daemon run
```

