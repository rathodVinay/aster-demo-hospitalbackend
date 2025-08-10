package com.example.Aster_Hosp.controller;

import com.example.Aster_Hosp.DTO.DoctorRequest;
import com.example.Aster_Hosp.DTO.DoctorResponse;
import com.example.Aster_Hosp.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> create(@RequestBody DoctorRequest req) {
        return ResponseEntity.ok(service.create(req));
    }

    @GetMapping
    public List<DoctorResponse> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> update(@PathVariable Long id,
                                                 @RequestBody DoctorRequest req) {
        return ResponseEntity.ok(service.update(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
