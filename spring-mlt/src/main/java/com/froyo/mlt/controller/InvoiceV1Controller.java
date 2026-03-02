package com.froyo.mlt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceV1Controller {

    /**
     * Sophia leverages URL versioning (/api/v1/invoices) to maintain compatibility
     * while evolving the microservices REST API.
     */
    @GetMapping
    public List<String> getInvoices() {
        return Arrays.asList("Invoice #101 (V1)", "Invoice #102 (V1)");
    }
}
