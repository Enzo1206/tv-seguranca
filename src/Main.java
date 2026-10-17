import java.util.ArrayList;
import java.util.List;

public class Main {

    static class SoftwareTV {
        private String nome;
        private String versaoAtual;
        private boolean possuiFalhaSeguranca;

        public SoftwareTV(String nome, String versaoAtual, boolean possuiFalhaSeguranca) {
            this.nome = nome;
            this.versaoAtual = versaoAtual;
            this.possuiFalhaSeguranca = possuiFalhaSeguranca;
        }

        public boolean verificarFalhaSeguranca() {
            return possuiFalhaSeguranca;
        }

        public void atualizarVersao(String novaVersao) {
            this.versaoAtual = novaVersao;
            this.possuiFalhaSeguranca = false;
        }

        public String getNome() {
            return nome;
        }

        public String getVersaoAtual() {
            return versaoAtual;
        }
    }

    static class AtualizacaoSeguranca {
        private String versaoDestino;
        private String descricao;
        private boolean disponivel;

        public AtualizacaoSeguranca(String versaoDestino, String descricao) {
            this.versaoDestino = versaoDestino;
            this.descricao = descricao;
            this.disponivel = false;
        }

        public void prepararAtualizacao() {
            System.out.println("Atualização preparada.");
        }

        public void disponibilizar() {
            this.disponivel = true;
        }

        public String getVersaoDestino() {
            return versaoDestino;
        }

        public String getDescricao() {
            return descricao;
        }

        public boolean isDisponivel() {
            return disponivel;
        }
    }

    static class ServidorAtualizacoes {
        private List<AtualizacaoSeguranca> atualizacoes;

        public ServidorAtualizacoes() {
            atualizacoes = new ArrayList<>();
        }

        public void publicarAtualizacao(AtualizacaoSeguranca atualizacao) {
            atualizacao.disponibilizar();
            atualizacoes.add(atualizacao);
            System.out.println("Atualização publicada no servidor.");
        }

        public void listarAtualizacoes() {
            for (AtualizacaoSeguranca atualizacao : atualizacoes) {
                System.out.println("Versão: " + atualizacao.getVersaoDestino());
                System.out.println("Descrição: " + atualizacao.getDescricao());
                System.out.println("Disponível: " + atualizacao.isDisponivel());
            }
        }
    }

    public static void main(String[] args) {
        SoftwareTV software = new SoftwareTV("Smart TV OS", "v1", true);
        ServidorAtualizacoes servidor = new ServidorAtualizacoes();

        System.out.println("Software: " + software.getNome());
        System.out.println("Versão atual: " + software.getVersaoAtual());

        if (software.verificarFalhaSeguranca()) {
            System.out.println("Falha de segurança identificada.");

            AtualizacaoSeguranca atualizacao = new AtualizacaoSeguranca(
                    "v2",
                    "Correção de falha de segurança"
            );

            atualizacao.prepararAtualizacao();
            servidor.publicarAtualizacao(atualizacao);
            software.atualizarVersao(atualizacao.getVersaoDestino());

            System.out.println("Software atualizado para: " + software.getVersaoAtual());
        }

        servidor.listarAtualizacoes();
    }
}