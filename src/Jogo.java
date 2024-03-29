import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private Jogador jogador;
    private final Inimigo inimigo;

    public Jogo() {
        this.jogador = null;
        this.inimigo = new Inimigo();
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Bem-vindo ao jogo de RPG!");

        boolean exit = false;
        while (!exit) {

            System.out.println("Escolha sua classe: ");
            System.out.println("1. Guerreiro");
            System.out.println("2. Mago");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Você escolheu o personagem Guerreiro.");
                    jogador = new Guerreiro();
                    exit = true;
                    break;
                case 2:
                    System.out.println("Você escolheu o personagem Mago.");
                    jogador = new Mago();
                    exit = true;
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }

        System.out.println("A batalha está prestes a começar!");
        System.out.println("===================================");
        System.out.printf("Jogador:%nVida: %d%nDano: %d%nArmadura: %d%n", jogador.getVida(),
                          jogador.getAtaque(), jogador.getArmadura());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.printf("Inimigo:%nVida: %d%nDano: %d%nArmadura: %d%n", inimigo.getVida(),
                          inimigo.getAtaque(), inimigo.getArmadura());
        System.out.println("===================================");

        System.out.println("Escolha um número de 1 a 10 para saber quem vai iniciar");

        int escolhaJogador = scanner.nextInt();
        int escolhaInimigo = rand.nextInt(10) + 1;
        boolean primeiroRound = true;

        while (escolhaJogador == escolhaInimigo) {
            System.out.println("Números iguais. Escolha novamente");
            escolhaJogador = scanner.nextInt();
            escolhaInimigo = rand.nextInt(10) + 1;
        }

        if (escolhaJogador > escolhaInimigo) {
            System.out.printf("Você escolheu %d e seu inimigo escolheu %d%nVocê começa%n", escolhaJogador,
                              escolhaInimigo);
        } else {
            System.out.printf("Você escolheu %d e seu inimigo escolheu %d%nSeu inimigo começa%n", escolhaJogador,
                              escolhaInimigo);
            primeiroRound = false;
        }
        System.out.println("===================================");


        while (true) {

            if (primeiroRound) {
                inimigo.vidaAtualInimigo(jogador.atacar(jogador.ataque, inimigo.armadura));
                if (inimigo.getVida() <= 0) {
                    break;
                }
                jogador.vidaAtual(inimigo.atacar(inimigo.ataque, jogador.armadura));
                if (jogador.getVida() <= 0) {
                    break;
                }
            } else {
                jogador.vidaAtual(inimigo.atacar(inimigo.ataque, jogador.armadura));
                if (jogador.getVida() <= 0) {
                    break;
                }
                inimigo.vidaAtualInimigo(jogador.atacar(jogador.ataque, inimigo.armadura));
                if (inimigo.getVida() <= 0) {
                    break;
                }
            }
        }
    }
}
