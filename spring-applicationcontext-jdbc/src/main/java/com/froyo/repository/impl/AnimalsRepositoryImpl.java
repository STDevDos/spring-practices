package com.froyo.repository.impl;

import com.froyo.model.entity.AnimalsEntity;
import com.froyo.repository.AnimalsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class AnimalsRepositoryImpl implements AnimalsRepository {

    private static final Logger log = Logger.getLogger(AnimalsRepositoryImpl.class.getName());

    private final JdbcTemplate jdbcTemplate;

    public AnimalsRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<AnimalsEntity> find(Integer id) {
        log.info("AnimalsRepositoryImpl.find(" + id + ")");
        return Optional.empty();
    }

    @Override
    public void addAnimal(AnimalsEntity animalsEntity) {
        log.info("AnimalsRepositoryImpl.addAnimal(" + animalsEntity + ")");
    }

    @Override
    public void editAnimal(AnimalsEntity animalsEntity) {
        log.info("AnimalsRepositoryImpl.editAnimal(" + animalsEntity + ")");
    }

    @Override
    public void deleteAnimal(int id) {
        log.info("AnimalsRepositoryImpl.deleteAnimal(" + id + ")");
    }

    @Override
    public List<AnimalsEntity> findAll() {
        log.info("AnimalsRepositoryImpl.findAll()");
        return jdbcTemplate.query("select * from animals", (rs, rowNum) -> {
            AnimalsEntity animalsEntity = new AnimalsEntity();
            animalsEntity.setId(rs.getLong("id"));
            animalsEntity.setName(rs.getString("name"));
            return animalsEntity;
        });
    }
}

