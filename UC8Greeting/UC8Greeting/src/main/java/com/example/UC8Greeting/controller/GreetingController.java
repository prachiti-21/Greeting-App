package com.example.UC8Greeting.controller;







//import com.example.greetingapp.model.Greeting;
//import com.example.greetingapp.repository.GreetingRepository;

import com.example.UC8Greeting.Greeting;
import com.example.UC8Greeting.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // Endpoint to update a greeting by ID
    @PutMapping("/greetings/{id}")
    public String updateGreetingById(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        Optional<Greeting> optionalGreeting = greetingRepository.findById(id);

        if (optionalGreeting.isPresent()) {
            Greeting greetingToUpdate = optionalGreeting.get();
            greetingToUpdate.setMessage(updatedGreeting.getMessage());
            greetingRepository.save(greetingToUpdate);
            return "Greeting updated successfully!";
        } else {
            return "Greeting not found for ID: " + id;
        }
    }

    // Endpoint to delete a greeting by ID
    @DeleteMapping("/greetings/{id}")
    public String deleteGreetingById(@PathVariable Long id) {
        Optional<Greeting> optionalGreeting = greetingRepository.findById(id);

        if (optionalGreeting.isPresent()) {
            greetingRepository.deleteById(id);
            return "Greeting deleted successfully!";
        } else {
            return "Greeting not found for ID: " + id;
        }
    }



}

