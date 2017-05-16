# Spring Data keyvalue example
Spring Data KeyValue framework use `java.util.Map` to store data in memory. I will show you how use it in this
page.

**pom file**
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>1.5.3.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-keyvalue</artifactId>
    <version>1.2.3.RELEASE</version>
</dependency>
```

**Java code**
```java
@SpringBootApplication
@EnableMapRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

@Controller
@RequestMapping(path = "/spring-data-keyvalue")
public class MainController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/add")
    @ResponseBody
    public String addNewUser(@RequestParam String name, @RequestParam String chatId) {
        Person person = new Person();
        person.setName(name);
        person.setChatId(Integer.valueOf(chatId));
        personRepository.save(person);
        return "Saved";
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Person> getAllPerson() {
        return personRepository.findAll();
    }
}

public class Person {
    @Id
    private Integer id;
    private String name;
    private Integer chatId;

    //getter and setter method
}

public interface PersonRepository extends CrudRepository<Person, Long> {
   
}
```

Run the main method to start Spring Boot.
Access "http://localhost:8080/spring-data-keyvalue/add?name=henryxi1&chatId=1" to save the data in memory. 
Access "http://localhost:8080/spring-data-keyvalue/all" to get the data. The output is like following.
```
[{"id":1995731822,"name":"henryxi1","chatId":1}]
```