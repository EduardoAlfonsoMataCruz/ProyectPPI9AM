package com.udg.phonemania.services;

import com.udg.phonemania.models.PhoneModel;
import com.udg.phonemania.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    public ArrayList<PhoneModel> getAllPhones(){return (ArrayList<PhoneModel>)phoneRepository.findAll();}

    public PhoneModel savePhone(PhoneModel phoneModel){
        if((phoneRepository.findPhoneModelByCode(phoneModel.getCode()).isEmpty()) && (phoneRepository.findPhoneModelByModel(phoneModel.getModel()).isEmpty())){
            return phoneRepository.save(phoneModel);
        }else if((phoneRepository.findPhoneModelByCode(phoneModel.getCode()).isPresent())){
            PhoneModel phoneErrorCode = new PhoneModel();
            phoneErrorCode.setId(-1L);
            return phoneErrorCode;
        }else if((phoneRepository.findPhoneModelByModel(phoneModel.getModel()).isPresent())){
            PhoneModel phoneErrorModel = new PhoneModel();
            phoneErrorModel.setModel("-1L");
            return phoneErrorModel;
        }else{
            return null;
        }
    }

    public String deletePhone(Long id){
        if(phoneRepository.findById(id).isPresent()){
            phoneRepository.deleteById(id);
            return "phone delete successfully";
        }
        else{
            return "phone not found with id="+id;
        }
    }

    public Optional<PhoneModel> findPhoneById(Long id) {return phoneRepository.findById(id);}

    public PhoneModel editById(PhoneModel phoneModel) {return phoneRepository.save(phoneModel);}

    public Optional<PhoneModel> findPhoneByCode(String code){
        return phoneRepository.findPhoneModelByCode(code);
    }

    public Optional<PhoneModel> findPhoneByModel(String model){
        return phoneRepository.findPhoneModelByModel(model);
    }

    public ResponseEntity<?> findPhoneByMark(@PathVariable String mark) {
        Optional<ArrayList<PhoneModel>> result = phoneRepository.findPhoneModelByMark(mark);

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



