import java.sql.SQLOutput;
import java.util.Scanner;

public class Jogo {
    private Jogador jogador;
    private Inimigo inimigo;

    public Jogo() {
        this.jogador = null;
        this.inimigo = new Inimigo();
    }

    public void iniciarJogo() {
        System.out.println("Bem-vindo ao jogo de RPG!");

        boolean exit = false;
        while(!exit){
            Scanner scanner = new Scanner(System.in);
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

        while(jogador.getVida(inimigo)) && inimigo.vidaAtual(jogador.atacar())) {
            if (!inimigo.vidaAtual(1)) {
                System.out.println("Matou o inimigo! UHUL!");
                break;
            }

        }
    }
}
