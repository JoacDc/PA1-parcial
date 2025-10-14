package input;

import java.time.LocalDate;

public interface CrearPilotoInput {

    boolean crearPiloto(String licencia,
                        String nombre,
                        String documento,
                        LocalDate fechaNacto);

}
