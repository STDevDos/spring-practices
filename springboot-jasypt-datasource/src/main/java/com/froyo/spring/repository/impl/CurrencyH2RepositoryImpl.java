package com.froyo.spring.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.froyo.spring.model.dto.CurrencyRequest;
import com.froyo.spring.model.dto.CurrencyResponse;
import com.froyo.spring.repository.CurrencyH2Repository;
import com.froyo.spring.util.messages.MessagePairUtils;
import com.froyo.spring.util.messages.codes.CurrencyMessageCode;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository
public class CurrencyH2RepositoryImpl implements CurrencyH2Repository {

	@Autowired
    @Qualifier("jdbcTemplateH2")
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE currency (id SERIAL,currency VARCHAR(255) )");
    }

    @Override
    public CurrencyResponse saveCurrency(final CurrencyRequest currencyRequest) {
    	CurrencyResponse currencyResponse = new CurrencyResponse();
    	
    	StringBuilder sbQuery = new StringBuilder();
    	sbQuery.append("INSERT INTO currency (currency) VALUES (?) ");
    	
    	List<Object> params = new ArrayList<>();
    	params.add(currencyRequest.getCurrency());
    	
        try {
            jdbcTemplate.update(sbQuery.toString(), params);
            currencyResponse.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1101));
            return currencyResponse;
        } catch (Exception ex) {
            log.error("@@@ saveCurrency: ", ex);
            currencyResponse.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1102));
            return currencyResponse;
        }

    }

}
