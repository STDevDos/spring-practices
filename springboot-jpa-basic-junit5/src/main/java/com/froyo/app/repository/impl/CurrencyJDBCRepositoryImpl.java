package com.froyo.app.repository.impl;

import com.froyo.app.model.entity.CurrencyEntity;
import com.froyo.app.repository.CurrencyJDBCRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyJDBCRepositoryImpl implements CurrencyJDBCRepository {

    private final JdbcTemplate jdbcTemplate;

    public CurrencyJDBCRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int[][] batchInsert(List<CurrencyEntity> currencyEntities) {
        return jdbcTemplate.batchUpdate(
                "insert into currency (currency) values(?)",
                currencyEntities,
                currencyEntities.size(),
                (ps, argument) -> ps.setString(1, argument.getCurrency())
        );
    }

}
