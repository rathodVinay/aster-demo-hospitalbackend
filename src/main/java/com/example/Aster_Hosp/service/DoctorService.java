package com.example.Aster_Hosp.service;

import com.example.Aster_Hosp.DTO.DoctorRequest;
import com.example.Aster_Hosp.DTO.DoctorResponse;
import com.example.Aster_Hosp.Models.Doctor;
import com.example.Aster_Hosp.repo.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository repo;
    private final ModelMapper mapper;

    public DoctorService(DoctorRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public DoctorResponse create(DoctorRequest req) {
        Doctor doc = mapper.map(req, Doctor.class);
        Doctor saved = repo.save(doc);
        return mapper.map(saved, DoctorResponse.class);
    }

    public List<DoctorResponse> list() {
        return repo.findAll()
                .stream()
                .map(d -> mapper.map(d, DoctorResponse.class))
                .toList();
    }

    public DoctorResponse get(Long id) {
        Doctor d = repo.findById(id).orElseThrow();
        return mapper.map(d, DoctorResponse.class);
    }

    public DoctorResponse update(Long id, DoctorRequest req) {
        Doctor existing = repo.findById(id).orElseThrow();
        mapper.map(req, existing);
        Doctor saved = repo.save(existing);
        return mapper.map(saved, DoctorResponse.class);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

