package org.estudos.br;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertTrue;


import static org.mockito.Mockito.when;

public class MainTest {
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    protected void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    protected void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }
    
    @Mock
    private Scanner scannerMock;

    @Test
    public void testConsultarEstado() throws IOException {
        // Configurar o mock do Scanner para simular a entrada do usuário
        Scanner scannerMock = Mockito.mock(Scanner.class);
        when(scannerMock.next()).thenReturn("SC"); // Simula a entrada do estado

        // Redirecionar a saída do System.out para um ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma instância de Main para chamar o método consultarEstado
        Main main = new Main();
        main.consultarEstado(scannerMock);

        // Verificar se a saída contém o resultado esperado
        String output = outputStream.toString();
        assertTrue(output.contains("Resultado da consulta: "));
    }

    @Test
    public void testConsultarDistrito() throws IOException {
        // Configurar o mock do Scanner para simular a entrada do usuário
        Scanner scannerMock = Mockito.mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(123); // Simula a entrada do ID do distrito

        // Redirecionar a saída do System.out para um ByteArrayOutputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Criar uma instância de Main para chamar o método consultarDistrito
        Main main = new Main();
        main.consultarDistrito(scannerMock);

        // Verificar se a saída contém o resultado esperado
        String output = outputStream.toString();
        assertTrue(output.contains("Resultado da consulta: "));
    }

    @Test
    public void testSairDoPrograma() throws IOException {
        // Simular a entrada do usuário para escolher a opção "3" (Sair do programa)
        String input = "3";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Capturar a saída do console para verificar se a mensagem de agradecimento é exibida
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Chamar o método main diretamente
        Main.main(new String[]{});

        // Verificar se a saída contém a mensagem de agradecimento
        assertTrue(outputStream.toString().contains("Obrigado por usar nossos serviços!"));
    }

}
