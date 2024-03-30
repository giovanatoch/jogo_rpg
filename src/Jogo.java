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
            scanner.nextLine();

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

        System.out.println("Vamos jogar os dados para ver quem começa?");
        System.out.println("Aperte Enter para jogar:");
        scanner.nextLine();

        int dadoJogador = rand.nextInt(6) + 1;
        int dadoInimigo = rand.nextInt(6) + 1;
        System.out.println("Seu dado caiu no número " + dadoJogador + "!");
        System.out.println("O dado do inimigo caiu no número " + dadoInimigo + "!");

        boolean primeiroRound = true;

        while (dadoJogador == dadoInimigo) {
            System.out.println("\nVocês tiraram números iguais! Aperte Enter para jogar novamente: ");
            scanner.nextLine();
            dadoJogador = rand.nextInt(6) + 1;
            dadoInimigo = rand.nextInt(6) + 1;
        }

        if (dadoJogador > dadoInimigo) {
            System.out.println("\nVocê começa:");
        } else {
            System.out.println("\nSeu inimigo começa: ");
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
