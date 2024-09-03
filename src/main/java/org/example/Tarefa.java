package org.example;

import java.util.Observable;

public class Tarefa extends Observable {
    private String nome;
    private EstadoTarefa estado;

    public Tarefa(String nome) {
        this.nome = nome;
        this.estado = EstadoTarefaNova.getInstance();
    }

    public void setEstado(EstadoTarefa estado) {
        this.estado = estado;
        setChanged();
        notifyObservers(estado.getEstado());
    }

    public boolean iniciar() {
        if (estado instanceof EstadoTarefaNova) {
            estado = EstadoTarefaEmProgresso.getInstance();
            return true;
        }
        return false;
    }

    public boolean pausar() {
        if (estado instanceof EstadoTarefaEmProgresso) {
            estado = EstadoTarefaPausada.getInstance();
            return true;
        }
        return false;
    }

    public boolean concluir() {
        if (estado instanceof EstadoTarefaEmProgresso) {
            estado = EstadoTarefaConcluida.getInstance();
            return true;
        }
        return false;
    }

    public boolean cancelar() {
        if (estado instanceof EstadoTarefaEmProgresso) {
            estado = EstadoTarefaCancelada.getInstance();
            return true;
        }
        return false;
    }

    public EstadoTarefa getEstado() {
        return estado;
    }
}
