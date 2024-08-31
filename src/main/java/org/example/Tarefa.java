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
        setChanged();  // Marca que o estado foi alterado
        notifyObservers(estado.getEstado());  // Notifica os observadores sobre a mudança
    }

    public void iniciar() {
        estado.iniciar(this);
    }

    public void pausar() {
        estado.pausar(this);
    }

    public void concluir() {
        estado.concluir(this);
    }

    public void cancelar() {
        estado.cancelar(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }
}
