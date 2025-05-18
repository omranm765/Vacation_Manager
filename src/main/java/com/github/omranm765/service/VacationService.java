package com.github.omranm765.service;

import com.github.omranm765.entity.VacationEntity;
import com.github.omranm765.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacationService {

    private final VacationRepository vacationRepository;

    @Autowired
    public VacationService(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    public List<VacationEntity> getAllVacations() {
        return vacationRepository.findAll();
    }

    public List<VacationEntity> getVacationsByUserName(String userName) {
        return vacationRepository.findByUserName(userName);
    }

    public VacationEntity addVacation(VacationEntity vacation) {
        return vacationRepository.save(vacation);
    }

    public Optional<VacationEntity> getVacationById(Long id) {
        return vacationRepository.findById(id);
    }

    public void deleteVacation(Long id) {
        vacationRepository.deleteById(id);
    }
}
