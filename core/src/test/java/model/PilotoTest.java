package model;

import exception.PilotoException;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PilotoTest {


    @Test
    @Order(1)
    @DisplayName("Creacion de un piloto con todos sus atributos")
    //Camino Feliz
    public void crearPilotConTodosSusAtributos(){
        Piloto piloto = Piloto.create("cabbd417-1841-4b25-8798-e8d54df1416e",
                "Franco Colapinto",
                "123456ABC",
                LocalDate.of(2000, 05, 02));

        Assertions.assertEquals("cabbd417-1841-4b25-8798-e8d54df1416e", piloto.getLicencia());
        Assertions.assertEquals("Franco Colapinto", piloto.getNombre());
        Assertions.assertEquals("123456ABC", piloto.getDocumento());
        Assertions.assertEquals("02/05/2000", piloto.fechaNactoFormat());
    }

    @Test
    @Order(2)
    @DisplayName("Atributo invalido de piloto")

    public void atributoInvalidoPiloto(){
        Exception exception = assertThrows(PilotoException.class, () ->
                Piloto.create("cabbd417-1841-4b25-8798-e8d54df1416e",
                        null,
                        "123456ABC",
                        LocalDate.of(2003, 02, 03)));

        Assertions.assertEquals("El espacio Nombre no debe estar vacio", exception.getMessage());
    }

    @Test
    @Order(3)
    @DisplayName("Fecha de Nacto posterios a la Actual")

    public void fechaNacimientoNoDebeSerPosteriorALaActual(){
        Exception exception = assertThrows(PilotoException.class, () ->
                Piloto.create("cabbd417-1841-4b25-8798-e8d54df1416e",
                        "Franco Colapinto",
                                                "123456ABC",
                        LocalDate.of(2026, 02, 03)));

        Assertions.assertEquals("La Fecha de nacimiento invalida",
                exception.getMessage());
    }

    @Test
    @Order(4)
    @DisplayName("El Documento no debe superar los 9 digitos")

    public void elDniNoDebeSuperarLosNueveDigitos(){
        Exception exception = assertThrows(PilotoException.class, () ->
                Piloto.create("cabbd417-1841-4b25-8798-e8d54df1416e",
                        "Franco Colapinto",
                        "1234567ABC",
                        LocalDate.of(2000, 02, 03)));

        Assertions.assertEquals("El Documento es inavalido",
                exception.getMessage());
    }

    @Test
    @Order(5)
    @DisplayName("La Edad del Pilot no puede ser menor de 18 años")

    public void edadDelPilotoNoPuedeSerMenorADieciocho(){
        Exception exception = assertThrows(PilotoException.class, () ->
                Piloto.create("cabbd417-1841-4b25-8798-e8d54df1416e",
                        "Franco Colapinto",
                        "123456ABC",
                        LocalDate.of(2015, 02, 03)));

        Assertions.assertEquals("El piloto no puede ser menor de edad",
                exception.getMessage());
    }
}
