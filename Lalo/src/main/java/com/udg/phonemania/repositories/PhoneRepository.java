package com.udg.phonemania.repositories;

import com.udg.phonemania.models.PhoneModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PhoneRepository extends CrudRepository<PhoneModel, Long> {
    public Optional<PhoneModel> findPhoneModelByCode(String code);

    public Optional <ArrayList<PhoneModel>> findPhoneModelByMark(String mark);
    public Optional<PhoneModel> findPhoneModelByModel(String model);
}
