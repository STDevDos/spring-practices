//package com.froyo.service.service.impl;
//
//import com.froyo.messages.MessagePairUtils;
//import com.froyo.messages.codes.CurrencyMessageCode;
//import com.froyo.service.model.dto.CurrencyRequest;
//import com.froyo.service.model.dto.CurrencyResponse;
//import com.froyo.service.model.entity.CurrencyEntity;
//import com.froyo.service.repository.postgres.CurrencyPostgresRepository;
//import com.froyo.service.service.CurrencyService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@AllArgsConstructor
//@Service("currencyPostgresServiceImpl")
//public class CurrencyPostgresServiceImpl implements CurrencyService {
//
//    private final CurrencyPostgresRepository currencyPostgresRepository;
//
//    @Override
//    public CurrencyResponse saveCurrency(final CurrencyRequest currencyRequest) {
//
//        CurrencyResponse currencyResponse = new CurrencyResponse();
//
//        CurrencyEntity currencyEntity = new CurrencyEntity();
//        currencyEntity.setCurrency(currencyRequest.getCurrency());
//
//        //es final
//        currencyRequest.setCurrency("k");
//
//        currencyPostgresRepository.save(currencyEntity);
//        currencyResponse.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1101));
//
//        return currencyResponse;
//    }
//
//}
