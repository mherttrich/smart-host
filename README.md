## Room Occupancy Manager

## unit tests
unit tests are located in smarthost-core
## web mock tests
web mock tests are located in smarthost-web

#executing test
all tests can be started either in the IDE with maven-surefire-plugin
in the project root

```
cd <workspace>/smart-host
$ mvn test
```

## Start application
```
$ cd <workspace>/smart-host/smart-host-web
$ mvn spring-boot:run
```

http://localhost:8080/room-occupancy?premiumRooms=7&economyRooms=5

