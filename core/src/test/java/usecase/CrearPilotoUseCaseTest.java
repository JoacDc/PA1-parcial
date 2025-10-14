package usecase;

import model.Piloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.GuardarPilotoRepositorio;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

public class CrearPilotoUseCaseTest {

    @Mock
    GuardarPilotoRepositorio guardarPilotoRepositorio;

    @InjectMocks
    CrearPilotoUseCase useCase;

    @Test
    @Order(1)
    @DisplayName("Crear Piloto y Alamacenarlo")
    public void crearPilotoYAlmacenarlo(){

        when(guardarPilotoRepositorio.existePiloto("45469057")).thenReturn(false);
        when(guardarPilotoRepositorio.guardarPiloto(any(Piloto.class))).thenReturn(true);

        boolean result_piloto = useCase.crearPiloto("cabbd417-1841-4b25-8798-e8d54df1416e",
                "Franco Colapinto",
                "45469057",
                LocalDate.of(2000, 05, 02));

        Assertions.assertTrue(result_piloto);
    }

    @Test
    @Order(2)
    @DisplayName("")

    public void creaPilotoFallaPorqueRepositorioNoGuarda(){

        when(guardarPilotoRepositorio.existePiloto("45469057")).thenReturn(false);
        when(guardarPilotoRepositorio.guardarPiloto(any(Piloto.class))).thenReturn(false);

        // act
        boolean result = useCase.crearPiloto("cabbd417-1841-4b25-8798-e8d54df1416e",
                "Franco Colapinto",
                "45469057",
                LocalDate.of(2000, 05, 02));

        // assert
        Assertions.assertFalse(result);

    }

    @Test
    @Order(3)
    @DisplayName("Piloto exception")

    void test_excecption_piloto(){
        boolean result = useCase.crearPiloto("cabbd417-1841-4b25-8798-e8d54df1416e",
                null,
                "45469057",
                LocalDate.of(2000, 05, 02));
        Assertions.assertFalse(result);
        verify(guardarPilotoRepositorio, never()).guardarPiloto(any());

    }



}


