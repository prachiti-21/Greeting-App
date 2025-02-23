package com.example.Greeting.controller;

import com.example.Greeting.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // GET Method: Return a default greeting message as JSON
    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello from BridgeLabz", "Admin");
    }

    // POST Method: Accept a JSON body and return the greeting message
    @PostMapping
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Hello " + greeting.getSender(), "BridgeLabz");
    }

    // PUT Method: Update the greeting message using Path Variable and Query Parameter
    @PutMapping("/{message}")
    public Greeting putGreeting(@PathVariable String message,
                                @RequestParam(value = "sender", defaultValue = "Guest") String sender) {
        return new Greeting(message, sender);
    }

    // DELETE Method: Return a message confirming deletion
    @DeleteMapping("/{message}")
    public Greeting deleteGreeting(@PathVariable String message) {
        return new Greeting("Deleted: " + message, "BridgeLabz");
    }
}

