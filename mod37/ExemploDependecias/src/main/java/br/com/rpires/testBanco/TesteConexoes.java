package br.com.rpires.testBanco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteConexoes {
    public static void main(String[] args) {
        //testarConexao("PostgresqlPrincipal");
        // testarConexao("PostgresqlBackup");
         testarConexao("BancoMysql");
    }

    private static void testarConexao(String nomePU) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        System.out.println("=== Testando conexão: " + nomePU + " ===");

        try {
            emf = Persistence.createEntityManagerFactory(nomePU);
            em = emf.createEntityManager();
            System.out.println("[OK] Conseguiu conectar ao banco: " + nomePU);
        } catch (Exception e) {
            System.err.println("[ERRO] Não conseguiu conectar ao banco: " + nomePU);
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) em.close();
            if (emf != null && emf.isOpen()) emf.close();
        }

        System.out.println();
    }
}
