DDD

- Layers of this application based on DDD:
  * **Application** (outside) - where the world interacts with your application, _contains things like user interfaces, RESTful controllers, and JSON serialization libraries_
  * **Domain** (inside) - business logic, core of application, _contain interfaces that define the API to communicate with external parts_
  * **Infrastructure** (outside) - database, spring configs, interfaces that depends on infrastructure but serves to domain layer


