package org.example;

public class EstadoTarefaConcluida extends EstadoTarefa {

    private EstadoTarefaConcluida() {};
    private static EstadoTarefaConcluida instance = new EstadoTarefaConcluida();
    public static EstadoTarefaConcluida getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Concluída";
    }
}

