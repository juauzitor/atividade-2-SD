package aln.joaovitor.controlador;

import aln.joaovitor.modelo.Questao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class QuizHandler {
    DataBaseHandler dbHandler = new DataBaseHandler();

    public List<Map<String, Object>> getQuestions() {
        List<Questao> questoes = dbHandler.getQuestoes();
        List<Map<String, Object>> serializedQuestions = new ArrayList<>();
        for (Questao questao : questoes) {
            serializedQuestions.add(questao.serialize());
        }
        return serializedQuestions;
    }

    public String acertos(List<Integer> respostas){
        DataBaseHandler dbHandler = new DataBaseHandler();
        List<Integer> respostasCorretas = dbHandler.buscarRespostasCorretas();
        int acertos = 0;
        for (int i = 0; i < respostas.size(); i++) {
           // System.out.println(respostas.get(i));
           // System.out.println(respostasCorretas.get(i));
            if(Objects.equals(respostas.get(i), respostasCorretas.get(i))){
                acertos++;
            }
        }
        return "Você acertou:" + acertos;
    }
}

