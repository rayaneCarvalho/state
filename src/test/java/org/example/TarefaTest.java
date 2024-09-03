package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarefaTest {

    private Tarefa tarefa;
    private LiderEquipe lider;

    @BeforeEach
    public void setUp() {
        tarefa = new Tarefa("Tarefa 1");
        lider = new LiderEquipe("Líder 1");
        tarefa.addObserver(lider);
    }

    @Test
    public void deveIniciarTarefaNova() {
        assertTrue(tarefa.iniciar());
        assertEquals(EstadoTarefaEmProgresso.getInstance(), tarefa.getEstado());
    }

    @Test
    public void naoDevePausarTarefaNova() {
        assertFalse(tarefa.pausar());
    }

    @Test
    public void naoDeveConcluirTarefaNova() {
        assertFalse(tarefa.concluir());
    }

    @Test
    public void naoDeveCancelarTarefaNova() {
        assertFalse(tarefa.cancelar());
    }

    @Test
    public void naoDeveConcluirTarefaPausada() {
        tarefa.iniciar();
        tarefa.pausar();
        assertFalse(tarefa.concluir());
    }

    @Test
    public void naoDevePausarTarefaConcluida() {
        tarefa.iniciar();
        tarefa.concluir();
        assertFalse(tarefa.pausar());
    }

    @Test
    public void naoDeveCancelarTarefaConcluida() {
        tarefa.iniciar();
        tarefa.concluir();
        assertFalse(tarefa.cancelar());
    }

    @Test
    public void naoDevePausarTarefaCancelada() {
        tarefa.iniciar();
        tarefa.cancelar();
        assertFalse(tarefa.pausar());
    }

    @Test
    public void naoDeveConcluirTarefaCancelada() {
        tarefa.iniciar();
        tarefa.cancelar();
        assertFalse(tarefa.concluir());
    }

    @Test
    public void naoDeveCancelarTarefaCancelada() {
        tarefa.iniciar();
        tarefa.cancelar();
        assertFalse(tarefa.cancelar());
    }
}
