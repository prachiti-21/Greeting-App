package com.example.UC5Greeting.controller;





//import com.example.greetingapp.model.Greeting;
//import com.example.greetingapp.repository.GreetingRepository;
import com.example.UC5Greeting.GreetingRepository;
import java.util.Optional;
import com.example.UC5Greeting.Greeting;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping("/greet")
    public String greetUser(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName) {

        String message;

        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello, World!";
        }

        // Save the message to the repository
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);

        return message;
    }

    // Endpoint to get all greetings
    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    // Import Optional for findById


    @GetMapping("/greetings/{id}")
    public String getGreetingById(@PathVariable Long id) {
        Optional<Greeting> greeting = greetingRepository.findById(id);

        // Check if a Greeting with the given ID exists
        if (greeting.isPresent()) {
            return greeting.get().getMessage();
        } else {
            return "Greeting not found for ID: " + id;
        }
    }

}
