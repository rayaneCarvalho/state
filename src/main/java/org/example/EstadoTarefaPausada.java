package org.example;

public class EstadoTarefaPausada extends EstadoTarefa {

    private EstadoTarefaPausada() {};
    private static EstadoTarefaPausada instance = new EstadoTarefaPausada();
    public static EstadoTarefaPausada getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Pausada";
    }

    @Override
    public boolean iniciar(Tarefa tarefa) {
        tarefa.setEstado(EstadoTarefaEmProgresso.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Tarefa tarefa) {
        tarefa.setEstado(EstadoTarefaCancelada.getInstance());
        return true;
    }
}

