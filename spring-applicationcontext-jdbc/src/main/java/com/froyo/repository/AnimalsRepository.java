package com.froyo.repository;

import com.froyo.model.entity.AnimalsEntity;

import java.util.List;
import java.util.Optional;

public interface AnimalsRepository {

    Optional<AnimalsEntity> find(Integer id);

    void addAnimal(AnimalsEntity animalsEntity);

    void editAnimal(AnimalsEntity animalsEntity);

    void deleteAnimal(int id);

    List<AnimalsEntity> findAll();

}

