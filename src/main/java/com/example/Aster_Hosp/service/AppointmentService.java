package com.example.Aster_Hosp.service;

import com.example.Aster_Hosp.DTO.AppointmentRequest;
import com.example.Aster_Hosp.DTO.AppointmentResponse;
import com.example.Aster_Hosp.Models.Appointment;
import com.example.Aster_Hosp.Models.Doctor;
import com.example.Aster_Hosp.Models.Patient;
import com.example.Aster_Hosp.repo.AppointmentRepository;
import com.example.Aster_Hosp.repo.DoctorRepository;
import com.example.Aster_Hosp.repo.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository repo;
    private final PatientRepository patientRepo;
    private final DoctorRepository doctorRepo;
    private final ModelMapper mapper;

    public AppointmentService(AppointmentRepository repo, PatientRepository patientRepo,
                              DoctorRepository doctorRepo, ModelMapper mapper) {
        this.repo = repo;
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
        this.mapper = mapper;
    }

    public AppointmentResponse create(AppointmentRequest req) {
        Appointment appt = new Appointment();
        Patient p = patientRepo.findById(req.getPatientId()).orElseThrow();
        Doctor d = doctorRepo.findById(req.getDoctorId()).orElseThrow();
        appt.setPatient(p);
        appt.setDoctor(d);
        appt.setAppointmentTime(req.getAppointmentTime());
        appt.setStatus(req.getStatus());
        appt.setNotes(req.getNotes());
        Appointment saved = repo.save(appt);
        AppointmentResponse resp = mapper.map(saved, AppointmentResponse.class);
        resp.setPatientId(p.getId());
        resp.setDoctorId(d.getId());
        return resp;
    }

    public List<AppointmentResponse> list() {
        return repo.findAll()
                .stream()
                .map(a -> {
                    var resp = mapper.map(a, AppointmentResponse.class);
                    resp.setPatientId(a.getPatient().getId());
                    resp.setDoctorId(a.getDoctor().getId());
                    return resp;
                })
                .toList();
    }

    public AppointmentResponse get(Long id) {
        Appointment a = repo.findById(id).orElseThrow();
        var resp = mapper.map(a, AppointmentResponse.class);
        resp.setPatientId(a.getPatient().getId());
        resp.setDoctorId(a.getDoctor().getId());
        return resp;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
