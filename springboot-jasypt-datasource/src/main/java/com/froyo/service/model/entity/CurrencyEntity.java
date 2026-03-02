package com.froyo.service.model.entity;

import com.froyo.service.model.entity.listener.CurrencyListener;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "currency")
@EntityListeners(CurrencyListener.class) // Listener process logs
public class CurrencyEntity implements Serializable {

    private static final long serialVersionUID = 6734139637088679530L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Each currency will be given an auto-generated unique identifier when stored

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "fechacompleta", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime fechacompleta;

    @Column(name = "fecha", nullable = false, columnDefinition = "DATE")
    private LocalDate fecha;

    @Column(name = "tiempo", nullable = false, columnDefinition = "TIME")
    private LocalTime tiempo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getFechacompleta() {
        return fechacompleta;
    }

    public void setFechacompleta(LocalDateTime fechacompleta) {
        this.fechacompleta = fechacompleta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalTime tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CurrencyEntity that = (CurrencyEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(currency, that.currency)
                && Objects.equals(fechacompleta, that.fechacompleta) && Objects.equals(fecha, that.fecha)
                && Objects.equals(tiempo, that.tiempo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency, fechacompleta, fecha, tiempo);
    }

    @Override
    public String toString() {
        return "CurrencyEntity{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", fechacompleta=" + fechacompleta +
                ", fecha=" + fecha +
                ", tiempo=" + tiempo +
                '}';
    }
}

