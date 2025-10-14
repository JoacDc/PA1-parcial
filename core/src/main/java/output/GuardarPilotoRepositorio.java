package output;

import model.Piloto;

public interface GuardarPilotoRepositorio {

    boolean guardarPiloto(Piloto piloto);
    boolean existePiloto(String documento);
}
