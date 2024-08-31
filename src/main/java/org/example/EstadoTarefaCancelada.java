package org.example;

public class EstadoTarefaCancelada extends EstadoTarefa {

    private EstadoTarefaCancelada() {};
    private static EstadoTarefaCancelada instance = new EstadoTarefaCancelada();
    public static EstadoTarefaCancelada getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Cancelada";
    }
}
