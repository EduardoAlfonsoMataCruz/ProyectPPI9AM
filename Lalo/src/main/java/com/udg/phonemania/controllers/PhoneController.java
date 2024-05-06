package com.udg.phonemania.controllers;

import com.udg.phonemania.models.PhoneModel;
import com.udg.phonemania.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @GetMapping()
    public ArrayList<PhoneModel> getAllPhones(){return phoneService.getAllPhones();}

    @PostMapping()
    public PhoneModel savePhone(@RequestBody PhoneModel phone){return phoneService.savePhone(phone);}

    @DeleteMapping("/delete-phone-by-id")
    public String deletePhoneById(@RequestParam("id") Long id){
        return phoneService.deletePhone(id);
    }

    @PutMapping()
    public PhoneModel editPhone(@RequestBody PhoneModel phone){return phoneService.savePhone(phone);}

    @GetMapping("/findPhoneById/{id}")
    public Optional<PhoneModel> findPhoneById(@PathVariable Long id){
        return phoneService.findPhoneById(id);
    }

    @GetMapping("/findPhoneByCode/{code}")
    public Optional<PhoneModel> findPhoneByCode(@PathVariable String code){
        return phoneService.findPhoneByCode(code);
    }

    @GetMapping("/findPhoneByModel/{model}")
    public Optional<PhoneModel> findPhoneByModel(@PathVariable String model){
        return phoneService.findPhoneByModel(model);
    }

    @GetMapping("/findPhoneByMark/{mark}")
    public ResponseEntity<?> findPhoneByMark(@PathVariable String mark){
        return phoneService.findPhoneByMark(mark);
    }
}
