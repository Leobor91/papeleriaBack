
package com.leobor.papeleriawww.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "tipo_documento", length = 50)
    private String documentType;

    @Column(name = "numero_documento", length = 50, unique = true)
    private String documentNumber;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String apellido;

    @Column(length = 100, unique = true)
    private String correo;

    @Column(length = 255)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @Column(length = 50)
    private String username;

    @Column(length = 100)
    private String password;

    // Constructor vacío
    public User() {}

    // Constructor con argumentos
    public User(long id, String documentType, String documentNumber, String nombre, String apellido, String correo, String direccion, String telefono, String username, String password) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.username = username;
        this.password = password;
    }
}
