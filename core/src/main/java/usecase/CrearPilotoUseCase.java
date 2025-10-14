package usecase;

import exception.PilotoException;
import exception.PilotoRepositorioException;
import input.CrearPilotoInput;
import model.Piloto;
import output.GuardarPilotoRepositorio;

import java.time.LocalDate;

public class CrearPilotoUseCase implements CrearPilotoInput {

    private GuardarPilotoRepositorio guardarPilotoRepositorio;


    @Override
    public boolean crearPiloto(String licencia, String nombre, String documento, LocalDate fechaNacto) {

        try {
            if (this.guardarPilotoRepositorio.existePiloto(documento)) {
                throw new PilotoException("Piloto ya existe");
            }

            Piloto piloto = Piloto.create(licencia, nombre, documento, fechaNacto);

            if (!this.guardarPilotoRepositorio.guardarPiloto(piloto)) {
                throw new PilotoRepositorioException("Algo pudo salir mal, no se guardo PIloto");
            }

            return true;

        } catch (Exception e) {
            System.out.println(e);

        }
        return false;
    }
}

