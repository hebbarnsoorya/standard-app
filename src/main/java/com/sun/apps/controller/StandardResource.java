package com.sun.apps.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/standards")
public class StandardResource {

    // In-memory storage for demonstration (replace with a service or DB layer)
    private final Map<Long, String> standards = new ConcurrentHashMap<>();
    private long currentId = 1;

    // GET Health Status
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("{" +
                "'health-status': 'TRUE'" +
                "}");
    }

    // Welcome Message
    @GetMapping("/welcome/{name}")
    public ResponseEntity<String> welcomeUser(@PathVariable String name) {
        return name != null ?
                ResponseEntity.ok(String.join(name, ", ", " Welcome to our STANDARD team!")) :
                ResponseEntity.ok(String.join("Hello  ", "Guest!", "Welcome to our Team!"));
    }

    // GET all standards
    @GetMapping
    public ResponseEntity<List<String>> getAllStandards() {
        return ResponseEntity.ok(new ArrayList<>(standards.values()));
    }

    // GET a standard by ID
    @GetMapping("/{id}")
    public ResponseEntity<String> getStandard(@PathVariable Long id) {
        String standard = standards.get(id);
        return standard != null ?
                ResponseEntity.ok(standard) :
                ResponseEntity.notFound().build();
    }

    // POST create a new standard
    @PostMapping
    public ResponseEntity<String> createStandard(@RequestBody String name) {
        standards.put(currentId, name);
        return new ResponseEntity<>("Created standard with ID: " + currentId++, HttpStatus.CREATED);
    }

    // PUT update a standard
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStandard(@PathVariable Long id, @RequestBody String name) {
        if (!standards.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        standards.put(id, name);
        return ResponseEntity.ok("Updated standard with ID: " + id);
    }

    // DELETE a standard
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStandard(@PathVariable Long id) {
        if (standards.remove(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Deleted standard with ID: " + id);
    }
}

