package com.pm.patientservice.services;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository)
    {
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatient()
    {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO)
    {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail()))
        {
            throw new EmailAlreadyExistException("This email already exists "+ patientRequestDTO.getEmail());
        }

        Patient patient= patientRepository.save(PatientMapper.toPatient(patientRequestDTO));

        return PatientMapper.toDTO(patient);
    }

    public PatientResponseDTO updatePatient(UUID id,PatientRequestDTO patientRequestDTO)
    {
        Patient patient= patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("This patient with this id does not exists "+id));

        if ( patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id))
        {
            throw new EmailAlreadyExistException("This email already exists "+ patientRequestDTO.getEmail());
        }
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        return PatientMapper.toDTO(patientRepository.save(patient));
    }

    public void deletePatient(UUID id)
    {
        Patient patient= patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException(" patient with this id does not exists "+id));

        patientRepository.deleteById(patient.getId());
    }

}
