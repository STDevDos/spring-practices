package com.froyo.app.service.impl;

import com.froyo.app.model.dto.CurrencyEntityDTORequest;
import com.froyo.app.model.dto.CurrencyEntityDTOResponse;
import com.froyo.app.model.entity.CurrencyEntity;
import com.froyo.app.repository.CurrencyJDBCRepository;
import com.froyo.app.repository.mysql.CurrencyMysqlRepository;
import com.froyo.app.service.CurrencyService;
import com.froyo.messages.MessagePairUtils;
import com.froyo.messages.codes.CurrencyMessageCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* Spring creates proxies for all the classes annotated with @Transactional
 he proxy allows the framework to inject transactional logic before and after the running method
 – mainly for starting and committing the transaction */
@Service
/*
 * https://www.baeldung.com/spring-transactional-propagation-isolation
 */
@Transactional(propagation = Propagation.REQUIRED)
public class CurrencyMysqlServiceImpl implements CurrencyService {

    private final CurrencyMysqlRepository currencyMysqlRepository;
    private final CurrencyJDBCRepository currencyJDBCRepository;

    public CurrencyMysqlServiceImpl(CurrencyMysqlRepository currencyMysqlRepository,
            CurrencyJDBCRepository currencyJDBCRepository) {
        this.currencyMysqlRepository = currencyMysqlRepository;
        this.currencyJDBCRepository = currencyJDBCRepository;
    }

    @Override
    public CurrencyEntityDTOResponse saveCurrency(final CurrencyEntityDTORequest dtoRequest) {

        CurrencyEntityDTOResponse dtoResponse = new CurrencyEntityDTOResponse();

        var currencyEntity2 = new CurrencyEntity();
        currencyEntity2.setCurrency(LocalDateTime.now().toString());
        // currencyMysqlRepository.save(currencyEntity2);

        var currencyEntity = new CurrencyEntity();
        currencyEntity.setCurrency(dtoRequest.currency());
        // currencyMysqlRepository.save(currencyEntity);

        var currencyEntities = new ArrayList<CurrencyEntity>();
        currencyEntities.add(currencyEntity2);
        currencyEntities.add(currencyEntity);
        currencyJDBCRepository.batchInsert(currencyEntities);

        dtoResponse.addMessagePair(MessagePairUtils.messagePair(CurrencyMessageCode.CY_1101));

        return dtoResponse;
    }

    @Override
    public Optional<CurrencyEntity> retrieveCurrency(final long id) {
        return currencyMysqlRepository.findById(id);
    }

}
