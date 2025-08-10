package com.example.Aster_Hosp.service;

import com.example.Aster_Hosp.DTO.PatientRequest;
import com.example.Aster_Hosp.DTO.PatientResponse;
import com.example.Aster_Hosp.Models.Patient;
import com.example.Aster_Hosp.repo.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository repo;
    private final ModelMapper mapper;

    public PatientService(PatientRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public PatientResponse create(PatientRequest req) {
        Patient entity = mapper.map(req, Patient.class);
        Patient saved = repo.save(entity);
        return mapper.map(saved, PatientResponse.class);
    }

    public List<PatientResponse> list() {
        return repo.findAll().stream()
                .map(p -> mapper.map(p, PatientResponse.class))
                .toList();
    }

    public PatientResponse get(Long id) {
        Patient p = repo.findById(id).orElseThrow();
        return mapper.map(p, PatientResponse.class);
    }

    public PatientResponse update(Long id, PatientRequest req) {
        Patient existing = repo.findById(id).orElseThrow();
        mapper.map(req, existing);
        Patient saved = repo.save(existing);
        return mapper.map(saved, PatientResponse.class);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
