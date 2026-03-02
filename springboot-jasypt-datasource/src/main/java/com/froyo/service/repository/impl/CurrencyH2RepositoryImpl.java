//package com.froyo.service.repository.impl;
//
//import com.froyo.messages.MessagePairUtils;
//import com.froyo.messages.codes.CurrencyMessageCode;
//import com.froyo.service.model.dto.CurrencyRequest;
//import com.froyo.service.model.dto.CurrencyResponse;
//import com.froyo.service.repository.CurrencyH2Repository;
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import jakarta.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//
//@AllArgsConstructor
//@Log4j2
//@Repository
//public class CurrencyH2RepositoryImpl implements CurrencyH2Repository {
//
//    @Qualifier("jdbcTemplateH2")
//    private final JdbcTemplate jdbcTemplateH2;
//
//    @PostConstruct
//    public void createTable() {
//        jdbcTemplateH2.execute("CREATE TABLE currency (id SERIAL,currency VARCHAR(255) )");
//    }
//
//    @Override
//    public CurrencyResponse saveCurrency(final CurrencyRequest currencyRequest) {
//        CurrencyResponse currencyResponse = new CurrencyResponse();
//
//        StringBuilder sbQuery = new StringBuilder();
//        sbQuery.append("INSERT INTO currency (currency) VALUES (?) ");
//
//        List<Object> params = new ArrayList<>();
//        params.add(currencyRequest.getCurrency());
//
//        try {
//            jdbcTemplateH2.update(sbQuery.toString(), params);
//            currencyResponse.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1101));
//            return currencyResponse;
//        } catch (Exception ex) {
//            log.error("@@@ saveCurrency: ", ex);
//            currencyResponse.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1102));
//            return currencyResponse;
//        }
//
//    }
//
//}

