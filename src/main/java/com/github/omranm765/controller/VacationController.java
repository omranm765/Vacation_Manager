package com.github.omranm765.controller;

import com.github.omranm765.entity.VacationEntity;
import com.github.omranm765.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacations")
public class VacationController {

    private final VacationService vacationService;

    @Autowired
    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping
    public List<VacationEntity> getAllVacations() {
        return vacationService.getAllVacations();
    }

    @GetMapping("/{userName}")
    public List<VacationEntity> getVacationsByUserName(@PathVariable String userName) {
        return vacationService.getVacationsByUserName(userName);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<VacationEntity> getVacationById(@PathVariable Long id) {
        return vacationService.getVacationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public VacationEntity createVacation(@RequestBody VacationEntity vacation) {
        return vacationService.addVacation(vacation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacation(@PathVariable Long id) {
        if (vacationService.getVacationById(id).isPresent()) {
            vacationService.deleteVacation(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
