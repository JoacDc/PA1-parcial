package model;

import exception.PilotoException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Piloto {

    private String licencia;
    private String nombre;
    private String documento;
    private LocalDate fechaNacto;

    private Piloto(String licencia, String nombre, String documento, LocalDate fechaNacto){
        this.licencia = licencia;
        this.nombre = nombre;
        this.documento = documento;
        this.fechaNacto = fechaNacto;
    }

    public static Piloto create(String licencia, String nombre, String documento, LocalDate fechaNacto){

        if(nombre == null || nombre.isEmpty() || nombre.isBlank()){
            throw new PilotoException("El espacio Nombre no debe estar vacio");
        }

        if(documento == null || documento.isEmpty() || documento.isBlank()){
            throw new PilotoException("El espacio Documento no debe estar vacio");
        }

        if(documento.length() < 5 || documento.length()>9){
            throw new PilotoException("El Documento es inavalido");
        }

        if(fechaNacto.isAfter(LocalDate.now())){
            throw new PilotoException("La Fecha de nacimiento invalida");
        }

        if(licencia == null || licencia.isEmpty() || licencia.isBlank()){
            throw new PilotoException("El espacio Nombre no debe estar vacio");
        }

        int edad = Period.between(fechaNacto, LocalDate.now()).getYears();
        if (edad < 18) {
            throw new PilotoException("El piloto no puede ser menor de edad");
        }

        return new Piloto(licencia, nombre, documento, fechaNacto);
    }

    public String getLicencia() {
        return licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String fechaNactoFormat(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaNacto.format(formatter);
    }
    public LocalDate getFechaNacto() {
        return fechaNacto;
    }
}
