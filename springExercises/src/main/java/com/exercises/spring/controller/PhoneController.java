package com.exercises.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercises.spring.model.entity.postgres.PhoneEntity;
import com.exercises.spring.repository.postgres.PhoneRepository;

@RestController
@RequestMapping("/api/v1")
public class PhoneController {

	@Autowired
    private PhoneRepository phoneRepository;

    // GET method to fetch all phones
    @GetMapping("/phones")
    public Iterable<PhoneEntity> getAllPhones() {
        return phoneRepository.findAll();
    }

    // GET method to fetch phone by Id
    @GetMapping("/phones/{id}")
    public ResponseEntity<PhoneEntity> getPhoneById(@PathVariable(value = "id") Long phoneId)
            throws Exception {
        PhoneEntity phone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));
        return ResponseEntity.ok().body(phone);
    }

    // POST method to create a phone
    @PostMapping("/phones")
    public PhoneEntity createPhone(@Valid @RequestBody PhoneEntity phone) {
        return phoneRepository.save(phone);
    }

    /*
    // PUT method to update a phone's details
    @PutMapping("/phones/{id}")
    public ResponseEntity<PhoneEntity> updatePhone(
            @PathVariable(value="id") Long phoneId, @Valid @RequestBody PhoneEntity phoneDetails
    ) throws Exception {
        PhoneEntity phone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));

        phone.setPhoneName(phoneDetails.getPhoneName());
        phone.setOs(phoneDetails.getOs());

        final PhoneEntity updatedPhone = phoneRepository.save(phone);
        return ResponseEntity.ok(updatedPhone);
    }
    */


    // DELETE method to delete a phone
    @DeleteMapping("/phone/{id}")
    public Map<String, Boolean> deletePhone(@PathVariable(value = "id") Long phoneId) throws Exception {
        PhoneEntity phone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));

        phoneRepository.delete(phone);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
