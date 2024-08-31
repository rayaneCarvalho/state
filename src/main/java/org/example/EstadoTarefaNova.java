package org.example;

import org.example.EstadoTarefa;

public class EstadoTarefaNova extends EstadoTarefa {

    private EstadoTarefaNova() {};
    private static EstadoTarefaNova instance = new EstadoTarefaNova();
    public static EstadoTarefaNova getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Nova";
    }

    @Override
    public boolean iniciar(Tarefa tarefa) {
        tarefa.setEstado(EstadoTarefaEmProgresso.getInstance());
        return true;
    }
}
