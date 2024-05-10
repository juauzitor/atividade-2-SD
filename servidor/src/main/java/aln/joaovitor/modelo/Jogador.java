package aln.joaovitor.modelo;

import java.util.HashMap;
import java.util.Map;

public class Jogador {
    private String nome;
    private int acertos;

    public Jogador(String nome, int acertos) {
        this.nome = nome;
        this.acertos = acertos;
    }

    public String getNome() {
        return nome;
    }

    public int getAcertos() {
        return acertos;
    }
    public Map<String, Object> serialize() {
        Map<String, Object> serializedJogador = new HashMap<>();
        serializedJogador.put("nome", this.nome);
        serializedJogador.put("acertos", this.acertos);
        return serializedJogador;
    }
}
