package org.example;

public class EstadoTarefaEmProgresso extends EstadoTarefa {

    private EstadoTarefaEmProgresso() {}

    private static EstadoTarefaEmProgresso instance = new EstadoTarefaEmProgresso();

    public static EstadoTarefaEmProgresso getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Em Progresso";
    }

    @Override
    public boolean iniciar(Tarefa tarefa) {
        throw new IllegalStateException("A tarefa já está em progresso.");
    }

    @Override
    public boolean pausar(Tarefa tarefa) {
        tarefa.setEstado(EstadoTarefaPausada.getInstance());
        return true;
    }

    @Override
    public boolean concluir(Tarefa tarefa) {
        tarefa.setEstado(EstadoTarefaConcluida.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Tarefa tarefa) {
        tarefa.setEstado(EstadoTarefaCancelada.getInstance());
        return true;
    }
}


