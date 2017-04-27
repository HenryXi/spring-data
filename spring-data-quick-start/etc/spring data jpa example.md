# Spring data jpa example
This is a sample example to quick start to use spring data framework. I assume you have created a Mysql database which
name is db. For quick start we only save data into database and query them out without any condition.

**The structure of this example**
```
├─main
│  ├─java
│  │  └─com
│  │      └─henryxi
│  │          └─springdata
│  │              └─quickstart
│  │                      Application.java
│  │                      Employee.java
│  │                      EmployeeRepository.java
│  │                      MainController.java
│  │
│  └─resources
│          application.properties
```

**The file of pom.xml**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>1.5.3.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <version>1.5.3.RELEASE</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>6.0.6</version>
</dependency>
```

**The content of application.properties**
```ini
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://10.232.56.19:3306/db
spring.datasource.username=root
spring.datasource.password=123456
```

**Application.java**
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
**Employee.java**
```java
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    //getter and setter methods
}
```
**EmployeeRepository.java**
```java
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
```
**MainController.java**
```java
@Controller
@RequestMapping(path = "/spring-data-jpa")
public class MainController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(path = "/add")
    @ResponseBody
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
        Employee n = new Employee();
        n.setName(name);
        n.setEmail(email);
        employeeRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }
}
```

Execute the main method in `Application` and access "localhost:8080/spring-data-jpa/add?name=henryxi&email=email@henryxi.com" to
save the employ into database. After saving we can access "http://localhost:8080/spring-data-jpa/all" get query the data 
from database without any condition. The output is like following.
```
[{"id":1,"name":"henryxi","email":"email@henryxi.com"}]
```

EOF