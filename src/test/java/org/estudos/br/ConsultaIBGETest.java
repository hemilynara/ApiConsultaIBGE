package org.estudos.br;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class ConsultaIBGETest {
    @Test
    public void testConsultarEstado() {
        try {
            String resultado = ConsultaIBGE.consultarEstado("SP"); // Consultar informações do estado de São Paulo
            assertNotNull(resultado); // Verificar se o resultado não é nulo
            assertTrue(resultado.contains("São Paulo")); // Verificar se o resultado contém informações de São Paulo
        } catch (Exception e) {
            fail("Exceção lançada durante a consulta de estado: " + e.getMessage());
        }
    }

    @Test
    public void testConsultarDistrito() {
        try {
            String resultado = ConsultaIBGE.consultarEstado("SP"); // Consultar informações do estado de São Paulo
            assertNotNull(resultado); // Verificar se o resultado não é nulo
            assertTrue(resultado.contains("São Paulo")); // Verificar se o resultado contém informações sobre o estado de São Paulo
        } catch (Exception e) {
            fail("Exceção lançada durante a consulta de distrito: " + e.getMessage());
        }
    }  

}
