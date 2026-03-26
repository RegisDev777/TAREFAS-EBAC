package DesafioHashMap;

public class EstacionamentoHash {
    
    // 1. O "Ticket": Guarda a placa (chave) e o modelo do carro (valor) juntos
    private class Ticket {
        int placa; 
        int modelo; 

        public Ticket(int placa, int modelo) {
            this.placa = placa;
            this.modelo = modelo;
        }
    }

    // 2. Nosso "Estacionamento": um array de Tickets com 10 vagas (de 0 a 9)
    private Ticket[] vagas;

    public EstacionamentoHash() {
        vagas = new Ticket[10];
    }

    // 3. A Catraca (Função Hash): calcula o resto da divisão por 10 para achar a vaga
    private int calcularVaga(int placa) {
        return Math.abs(placa % 10);
    }

    // Método PUT: Estacionar o carro
    public void estacionar(int placa, int modelo) {
        int numeroDaVaga = calcularVaga(placa);
        vagas[numeroDaVaga] = new Ticket(placa, modelo);
    }

    // Método GET: Buscar qual modelo está estacionado usando a placa
    public Integer buscarModelo(int placa) {
        int numeroDaVaga = calcularVaga(placa);
        Ticket ticket = vagas[numeroDaVaga];
        
        // Verifica se a vaga tem carro E se a placa bate com a que estamos procurando
        if (ticket != null && ticket.placa == placa) {
            return ticket.modelo;
        }
        return null; // Retorna vazio se não encontrar o carro
    }

    // Método DELETE: Retirar o carro do estacionamento pela placa
    public Integer retirarCarro(int placa) {
        int numeroDaVaga = calcularVaga(placa);
        Ticket ticket = vagas[numeroDaVaga];
        
        if (ticket != null && ticket.placa == placa) {
            int modeloRetirado = ticket.modelo;
            vagas[numeroDaVaga] = null; // Esvazia a vaga
            return modeloRetirado;
        }
        return null; 
    }

    // Método CLEAR: Esvaziar todo o estacionamento
    public void fecharEstacionamento() {
        for (int i = 0; i < vagas.length; i++) {
            vagas[i] = null; 
        }
    }
}