package com.froyo.service.restcontroller;

import com.froyo.service.model.dto.CurrencyRequest;
import com.froyo.service.model.dto.CurrencyResponse;
import com.froyo.service.service.CurrencyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurrencyRestController {

    // @Qualifier("currencyPostgresServiceImpl")
    // private final CurrencyService currencyPostgresService;

    private final CurrencyService currencyMysqlServiceImpl;

    // @Qualifier("currencyH2ServiceImpl")
    // private final CurrencyService currencyH2Service;

    public CurrencyRestController(@Qualifier("currencyMysqlServiceImpl") CurrencyService currencyMysqlServiceImpl) {
        this.currencyMysqlServiceImpl = currencyMysqlServiceImpl;
    }

    @PostMapping("/addCurrency")
    private CurrencyResponse addCurrency(@RequestBody CurrencyRequest currencyRequest) {

        CurrencyResponse result = new CurrencyResponse();
        result.setCurrencyRequest(currencyRequest);

        // CurrencyResponse currencyResponseP =
        // currencyPostgresService.saveCurrency(currencyRequest);
        // result.getMessagePairList().addAll(currencyResponseP.getMessagePairList());

        CurrencyResponse currencyResponseM = currencyMysqlServiceImpl.saveCurrency(currencyRequest);
        result.getMessagePairList().addAll(currencyResponseM.getMessagePairList());

        // CurrencyResponse currencyResponseH =
        // currencyH2Service.saveCurrency(currencyRequest);
        // result.getMessagePairList().addAll(currencyResponseH.getMessagePairList());

        return result;
    }

}
