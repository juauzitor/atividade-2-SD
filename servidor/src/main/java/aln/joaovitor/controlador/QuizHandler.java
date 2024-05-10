package aln.joaovitor.controlador;

import aln.joaovitor.modelo.Jogador;
import aln.joaovitor.modelo.Questao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 */
public class QuizHandler {
    DataBaseHandler dbHandler = new DataBaseHandler();

    /**
     *
     * @return
     */
    public List<Map<String, Object>> getQuestions() {
        List<Questao> questoes = dbHandler.getQuestoes();
        List<Map<String, Object>> serializedQuestions = new ArrayList<>();
        for (Questao questao : questoes) {
            serializedQuestions.add(questao.serialize());
        }
        return serializedQuestions;
    }

    /**
     *
     * @param respostas
     * @return
     */
    public String acertos(String nome,List<Integer> respostas){
        DataBaseHandler dbHandler = new DataBaseHandler();
        List<Integer> respostasCorretas = dbHandler.buscarRespostasCorretas();
        int acertos = 0;
        for (int i = 0; i < respostas.size(); i++) {
            if(Objects.equals(respostas.get(i), respostasCorretas.get(i))){
                acertos++;
            }
        }
        dbHandler.insertPlayerInRanking(nome, acertos);
        return nome + " você acertou: " + acertos + " das questões parabens!";
    }

    public List<Map<String, Object>> getRanking() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        List<Jogador> ranking = dbHandler.getRankings();
        List<Map<String, Object>> serializedRanking = new ArrayList<>();
        for (Jogador jogador : ranking) {
            serializedRanking.add(jogador.serialize());
        }
        return serializedRanking;
    }

}

