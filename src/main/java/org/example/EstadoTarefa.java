package org.example;

public abstract class EstadoTarefa {

    public abstract String getEstado();

    public boolean iniciar(Tarefa tarefa) {
        return false;
    }

    public boolean pausar(Tarefa tarefa) {
        return false;
    }

    public boolean concluir(Tarefa tarefa) {
        return false;
    }

    public boolean cancelar(Tarefa tarefa) {
        return false;
    }
}
