package aln.joaovitor.controlador;

import aln.joaovitor.modelo.Jogador;
import aln.joaovitor.modelo.Questao;
import aln.joaovitor.modelo.Resposta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/** Permite contralar a intergração com o banco de dados.
 * @author João Vitor Mendes Pinto dos Santos
 * @version 0.0.1
 */
public class DataBaseHandler {
    /**
     * Cria a conexão com o banco de dados
     * @return a conexão com o banco de dados
     */
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

    /**
     * Método para obter as questões e as respotas cadastradas no banco de dados
     * @return Um ArrayList do objeto tipo Questão
     */
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

    /**
     * Um método auxiliar  para verificar se o a questão já esta cadastrada no ArrayList das questões e caso não esteja alocar adicionar uma nova questão ao ArrayList
     * @param questoes
     * @param id
     * @param pergunta
     * @return
     */
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

    /**
     *
     * @return
     */
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

    public List<Jogador> getRankings() {
        ArrayList<Jogador> ranking = new ArrayList<Jogador>();
        String sql = "SELECT r.nome, r.acertos FROM ranking r ORDER BY acertos DESC";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             ResultSet rs    = pstmt.executeQuery()) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                Integer acertos = rs.getInt("acertos");
                ranking.add(new Jogador(nome, acertos));
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar respostas corretas: " + e.getMessage());
        }
        return ranking;
    }

    public void insertPlayerInRanking(String nome, int acertos){
        String sql = "INSERT INTO ranking (nome, acertos) VALUES (?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, acertos);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao buscar respostas corretas: " + e.getMessage());
        }
    }
}
