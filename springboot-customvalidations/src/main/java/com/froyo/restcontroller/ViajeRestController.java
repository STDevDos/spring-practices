package com.froyo.restcontroller;

import com.froyo.messages.MessagePair;
import com.froyo.messages.MessagePairTypeCode;
import com.froyo.model.ViajeRequest;
import com.froyo.model.ViajeResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/viaje")
public class ViajeRestController {

    @PostMapping("/saveViaje")
    private ViajeResponse saveViaje(@Valid @RequestBody ViajeRequest viajeRequest, BindingResult bindingResult) {

        ViajeResponse viajeResponse = new ViajeResponse();

        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                viajeResponse.addMessagePair(new MessagePair(objectError.getCode(), objectError.getDefaultMessage(), MessagePairTypeCode.ERROR));
            }
            return viajeResponse;
        }

        viajeResponse.addMessagePair(new MessagePair(null, "SUCCESS", MessagePairTypeCode.SUCCESS));
        return viajeResponse;

    }

}

