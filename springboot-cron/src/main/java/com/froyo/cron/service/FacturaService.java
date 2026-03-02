package com.froyo.cron.service;

public interface FacturaService {

    /**
     * Simple método para enviar balance por correo electrónico.
     * El valor de las carteras se obtendrá de forma manual.
     */
    void sendBalance();

    void createFactura();
}
