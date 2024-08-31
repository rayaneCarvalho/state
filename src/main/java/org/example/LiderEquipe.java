package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class LiderEquipe implements Observer {

    private String nome;
    private List<String> notificacoes;

    public LiderEquipe(String nome) {
        this.nome = nome;
        this.notificacoes = new ArrayList<>();
    }

    @Override
    public void update(Observable tarefa, Object arg) {
        String mensagem = "Líder " + nome + " foi notificado. Novo estado da tarefa: " + arg;
        notificacoes.add(mensagem);
        System.out.println(mensagem);
    }

    public String getUltimaNotificacaoLider() {
        if (notificacoes.isEmpty()) {
            return null;
        }
        return notificacoes.get(notificacoes.size() - 1);
    }
}
