package aln.joaovitor.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Questao {
    int id;
    String pergunta;
    ArrayList<Resposta> respostas;

    /**
     *
     * @param id
     * @param pergunta
     * @param respostas
     */
    public Questao(int id, String pergunta, ArrayList<Resposta> respostas) {
        this.id = id;
        this.pergunta = pergunta;
        this.respostas = respostas;
    }

    /**
     *
     * @return
     */
    public String getPergunta() {
        return pergunta;
    }

    /**
     *
     * @return
     */
    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param resposta
     */
    public void addResposta(Resposta resposta){
        respostas.add(resposta);
    }

}
