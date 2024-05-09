package aln.joaovitor.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Questao {
    int id;
    String pergunta;
    ArrayList<Resposta> respostas;

    public Questao(int id, String pergunta, ArrayList<Resposta> respostas) {
        this.id = id;
        this.pergunta = pergunta;
        this.respostas = respostas;
    }

    public String getPergunta() {
        return pergunta;
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    public Map<String, Object> serialize() {
        Map<String, Object> serializedQuestion = new HashMap<>();
        serializedQuestion.put("pergunta", this.pergunta);

        List<Map<String, Object>> serializedResponses = new ArrayList<>();
        for (Resposta resposta : this.respostas) {
            Map<String, Object> serializedResponse = new HashMap<>();
            serializedResponse.put("alternativa", resposta.alternativa);
            serializedResponse.put("descricao", resposta.descricao);
            serializedResponses.add(serializedResponse);
        }

        serializedQuestion.put("respostas", serializedResponses);
        return serializedQuestion;
    }

    public int getId() {
        return id;
    }

    public void addResposta(Resposta resposta){
        respostas.add(resposta);
    }

}
