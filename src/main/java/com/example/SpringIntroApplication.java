package com.example;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
class Person{
	String firstName;
	String lastName;
}

@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class SpringIntroApplication {

	static List<Person> list = new ArrayList<>();
	//simple common api
	@GetMapping("/getAll")
	public List<Person> getHello(){
		return list;
	}

	//query paramater
	@GetMapping("/query")
	public String gethellowithName(@RequestParam String firstName){
		return "Hello "+firstName+" from bridgeLabz";
	}

	//path variable
	@GetMapping("/param/{firstName}")
	public String getHellobyPath(@PathVariable String firstName){
		return "hELLO "+firstName+" from BridgeLabz";
	}

	//adding data
	@PostMapping("/post")
	public String addData(@RequestBody Person person){
		list.add(person);
		return person.getFirstName()+" "+person.getLastName()+" added";
	}

	@PutMapping("/put/{firstName}")
	public String editData(@PathVariable String firstName, @RequestParam String lastName){
		for(Person p : list){
			if(p.getFirstName().equals(firstName)){
				p.setLastName(lastName);
				return "Updated " + firstName + " to last name: " + lastName;
			}
		}
		return "Person not found with firstName " + firstName;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroApplication.class, args);
	}

}
