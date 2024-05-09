package aln.joaovitor.controlador;

import aln.joaovitor.modelo.Questao;
import aln.joaovitor.modelo.Resposta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:banco_de_dados.db"; // Caminho para o seu banco de dados
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public ArrayList<Questao> getQuestoes() {
        String sql = "SELECT q.id, q.pergunta, r.alternativa, r.descricao FROM questoes q JOIN respostas r ON q.id = r.questao_id";
        ArrayList<Questao> questoes = new ArrayList<>();

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             ResultSet rs    = pstmt.executeQuery()) {

            while (rs.next()) {
                int questaoId = rs.getInt("id");
                String pergunta = rs.getString("pergunta");
                int alternativa = rs.getInt("alternativa");
                String descricao = rs.getString("descricao");

                Questao questao = findOrCreateQuestao(questoes, questaoId, pergunta);
                questao.addResposta(new Resposta(alternativa, descricao));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return questoes;
    }

    private Questao findOrCreateQuestao(ArrayList<Questao> questoes, int id, String pergunta) {
        for (Questao questao : questoes) {
            if (questao.getId() == id) {
                return questao;
            }
        }
        Questao newQuestao = new Questao(id, pergunta, new ArrayList<>());
        questoes.add(newQuestao);
        return newQuestao;
    }

    public List<Integer> buscarRespostasCorretas() {
        List<Integer> respostasCorretas = new ArrayList<Integer>();
        String sql = "SELECT r.alternativa FROM questoes q JOIN respostas r ON q.id = r.questao_id WHERE r.correta = 1";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             ResultSet rs    = pstmt.executeQuery()) {

            while (rs.next()) {
                Integer alternativa = rs.getInt("alternativa");
                respostasCorretas.add(alternativa);
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar respostas corretas: " + e.getMessage());
        }
        return respostasCorretas;
    }
}
