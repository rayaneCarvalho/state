package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TarefaTest {

    private Tarefa tarefa;

    @BeforeEach
    public void setUp() {
        tarefa = new Tarefa(new EstadoTarefaNova());
    }

    // Tarefa Nova

    @Test
    public void deveIniciarTarefaNova() {
        assertTrue(tarefa.iniciar());
        assertEquals(new EstadoTarefaEmProgresso(), tarefa.getEstado());
    }

    @Test
    public void naoDevePausarTarefaNova() {
        assertThrows(IllegalStateException.class, () -> tarefa.pausar());
    }

    @Test
    public void naoDeveConcluirTarefaNova() {
        assertThrows(IllegalStateException.class, () -> tarefa.concluir());
    }

    @Test
    public void naoDeveCancelarTarefaNova() {
        assertTrue(tarefa.cancelar());
        assertEquals(new EstadoTarefaCancelada(), tarefa.getEstado());
    }

    // Tarefa Em Progresso

    @Test
    public void naoDeveIniciarTarefaEmProgresso() {
        tarefa.iniciar(); // Transição para Em Progresso
        assertThrows(IllegalStateException.class, () -> tarefa.iniciar());
    }

    @Test
    public void devePausarTarefaEmProgresso() {
        tarefa.iniciar(); // Transição para Em Progresso
        assertTrue(tarefa.pausar());
        assertEquals(new EstadoTarefaPausada(), tarefa.getEstado());
    }

    @Test
    public void deveConcluirTarefaEmProgresso() {
        tarefa.iniciar(); // Transição para Em Progresso
        assertTrue(tarefa.concluir());
        assertEquals(new EstadoTarefaConcluida(), tarefa.getEstado());
    }

    @Test
    public void naoDeveCancelarTarefaEmProgresso() {
        tarefa.iniciar(); // Transição para Em Progresso
        assertThrows(IllegalStateException.class, () -> tarefa.cancelar());
    }

    // Tarefa Pausada

    @Test
    public void naoDeveIniciarTarefaPausada() {
        tarefa.iniciar(); // Transição para Em Progresso
        tarefa.pausar();  // Transição para Pausada
        assertThrows(IllegalStateException.class, () -> tarefa.iniciar());
    }

    @Test
    public void naoDevePausarTarefaPausada() {
        tarefa.iniciar(); // Transição para Em Progresso
        tarefa.pausar();  // Transição para Pausada
        assertThrows(IllegalStateException.class, () -> tarefa.pausar());
    }

    @Test
    public void deveConcluirTarefaPausada() {
        tarefa.iniciar(); // Transição para Em Progresso
        tarefa.pausar();  // Transição para Pausada
        assertTrue(tarefa.concluir());
        assertEquals(new EstadoTarefaConcluida(), tarefa.getEstado());
    }

    @Test
    public void deveCancelarTarefaPausada() {
        tarefa.iniciar(); // Transição para Em Progresso
        tarefa.pausar();  // Transição para Pausada
        assertTrue(tarefa.cancelar());
        assertEquals(new EstadoTarefaCancelada(), tarefa.getEstado());
    }

    // Tarefa Concluída

    @Test
    public void naoDeveIniciarTarefaConcluida() {
        tarefa.iniciar(); // Transição para Em Progresso
        tarefa.concluir(); // Transição para Concluída
        assertThrows(IllegalStateException.class, () -> tarefa.iniciar());
    }

    @Test
    public void naoDevePausarTarefaConcluida() {
        tarefa.iniciar(); // Transição para Em Progresso
        tarefa.concluir(); // Transição para Concluída
        assertThrows(IllegalStateException.class, () -> tarefa.pausar());
    }

    @Test
    public void naoDeveConcluirTarefaConcluida() {
        tarefa.iniciar(); // Transição para Em Progresso
        tarefa.concluir(); // Transição para Concluída
        assertThrows(IllegalStateException.class, () -> tarefa.concluir());
    }

    @Test
    public void naoDeveCancelarTarefaConcluida() {
        tarefa.iniciar(); // Transição para Em Progresso
        tarefa.concluir(); // Transição para Concluída
        assertThrows(IllegalStateException.class, () -> tarefa.cancelar());
    }

    // Tarefa Cancelada

    @Test
    public void naoDeveIniciarTarefaCancelada() {
        tarefa.cancelar(); // Transição para Cancelada
        assertThrows(IllegalStateException.class, () -> tarefa.iniciar());
    }

    @Test
    public void naoDevePausarTarefaCancelada() {
        tarefa.cancelar(); // Transição para Cancelada
        assertThrows(IllegalStateException.class, () -> tarefa.pausar());
    }

    @Test
    public void naoDeveConcluirTarefaCancelada() {
        tarefa.cancelar(); // Transição para Cancelada
        assertThrows(IllegalStateException.class, () -> tarefa.concluir());
    }

    @Test
    public void naoDeveCancelarTarefaCancelada() {
        tarefa.cancelar(); // Transição para Cancelada
        assertThrows(IllegalStateException.class, () -> tarefa.cancelar());
    }
}
