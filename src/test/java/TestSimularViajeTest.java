import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSimularViajeTest {

    TestSimularViaje objetoTestSimularViaje;
    Persona objetoPersona;
    Vehículo obejetoVehiculo;

    @BeforeEach
    void setUp() {
        objetoTestSimularViaje = new TestSimularViaje();
        objetoPersona = new Persona("Joaquin");
        obejetoVehiculo = new Vehículo("Auto", 50);
    }

    @AfterEach
    void tearDown() {
        objetoTestSimularViaje = null;
        objetoPersona = null;
        obejetoVehiculo = null;
    }

    @Test
    void crearVehículo() {
        assertEquals(obejetoVehiculo.getClass(), Vehículo.class);

    }

    @Test
    void crearPersona() {
        assertEquals(objetoPersona.getClass(), Persona.class);
    }

    @Test
    void isMayorCero() {
        assertTrue(objetoTestSimularViaje.isMayorCero(0.00001));
        assertFalse(objetoTestSimularViaje.isMayorCero(-0.0001));
    }


}