package com.platzi.platziweb.model;

import com.platzi.platziweb.common.codevalue.Category;
import com.platzi.platziweb.common.codevalue.Gender;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findByIdentificacion", query = "Select c from Cliente c where c.identificacion = ?1")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private Set<Reserva> reservaSet;

    @Column(name = "column_date_time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime columnDateTime;

    @Column(name = "column_date", nullable = false, columnDefinition = "DATE")
    private LocalDate columnDate;

    @Column(name = "column_time", nullable = false, columnDefinition = "TIME")
    private LocalTime column_time;

    // @Convert(converter = LocalDateTimeConverter.class)
    // @Column(name = "audit_insert_dt", nullable = false)
    // private LocalDateTime auditInsertDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Category category; // CategoryConverter (https://www.baeldung.com/jpa-persisting-enums-in-jpa)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Reserva> getReservaSet() {
        return reservaSet;
    }

    public void setReservaSet(Set<Reserva> reservaSet) {
        this.reservaSet = reservaSet;
    }

    public LocalDateTime getColumnDateTime() {
        return columnDateTime;
    }

    public void setColumnDateTime(LocalDateTime columnDateTime) {
        this.columnDateTime = columnDateTime;
    }

    public LocalDate getColumnDate() {
        return columnDate;
    }

    public void setColumnDate(LocalDate columnDate) {
        this.columnDate = columnDate;
    }

    public LocalTime getColumn_time() {
        return column_time;
    }

    public void setColumn_time(LocalTime column_time) {
        this.column_time = column_time;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", identificacion='" + identificacion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

