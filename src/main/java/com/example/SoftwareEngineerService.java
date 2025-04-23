package com.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found!"));
    }

    public void deleteSoftwareEngineer(Integer id) {
        boolean exists =  softwareEngineerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    id + " not found"
            );
        }
        softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineer(Integer id, SoftwareEngineer softwareEngineerUpdate) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found!"));
        softwareEngineer.setName(softwareEngineerUpdate.getName());
        softwareEngineer.setTechStack(softwareEngineerUpdate.getTechStack());
        softwareEngineerRepository.save(softwareEngineer);
    }
}
