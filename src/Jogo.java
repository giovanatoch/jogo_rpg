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

        System.out.println("✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄⋅✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋄⋆⋄✧⋄⋆⋅⋆⋄⋅✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄⋅✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧⋄⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧⋅⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧⋅⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧");
        System.out.println("""
                ▀██▀▀▀▀█  ▀██                 █▀▀██▀▀█                 ▀██         ▀██▀▀█▄   ▀██▀▀█▄   ▄▄█▀▀▀▄█ \s
                 ██  ▄     ██   ▄▄▄▄    ▄▄▄▄     ██      ▄▄▄▄    ▄▄▄▄   ██ ▄▄       ██   ██   ██   ██ ▄█▀     ▀ \s
                 ██▀▀█     ██  ▀▀ ▄██  ██▄ ▀     ██    ▄█▄▄▄██ ▄█   ▀▀  ██▀ ██      ██▀▀█▀    ██▄▄▄█▀ ██    ▄▄▄▄\s
                 ██        ██  ▄█▀ ██  ▄ ▀█▄▄    ██    ██      ██       ██  ██      ██   █▄   ██      ▀█▄    ██ \s
                ▄██▄▄▄▄▄█ ▄██▄ ▀█▄▄▀█▀ █▀▄▄█▀   ▄██▄    ▀█▄▄▄▀  ▀█▄▄▄▀ ▄██▄ ██▄    ▄██▄  ▀█▀ ▄██▄      ▀▀█▄▄▄▀█ \s
                """);
        System.out.println("✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄⋅✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋄⋆⋄✧⋄⋆⋅⋆⋄⋅✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄⋅✧⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧⋄⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧⋅⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧⋅⋄⋆⋅⋆⋄✧⋄⋆⋅⋆⋄✧");

        System.out.println("Bem-vindo ao jogo de RPG!");

        System.out.println("===================================");
        System.out.println("Qual o seu nome?");
        String nome = scanner.nextLine();
        System.out.println("===================================");

        boolean exit = false;
        while (!exit) {

            System.out.printf("Escolha sua classe, %s: %n", nome);
            System.out.println("1. Guerreiro");
            System.out.println("2. Mago");
            if (scanner.hasNextInt()) {
                int escolha = scanner.nextInt();
                if (escolha >= 1 && escolha <= 2) {
                    switch (escolha) {
                        case 1:
                            System.out.println("Você escolheu o personagem Guerreiro.");
                            jogador = new Guerreiro(nome);
                            exit = true;
                            break;
                        case 2:
                            System.out.println("Você escolheu o personagem Mago.");
                            jogador = new Mago(nome);
                            exit = true;
                            break;
                    }
                }else{
                    System.out.println("Escolha inválida. Tente novamente.");
                }
            }else {
                String entradaInvalida = scanner.next();
                System.out.println("Você digitou letra: " + entradaInvalida + ". Por favor, digite um número.");
            }
        }

        System.out.println("A batalha está prestes a começar!");
        System.out.println("===================================");

        if (jogador instanceof Mago ) {
            System.out.printf("""
                                      .
                                       .
                             /^\\     .
                        /\\   "V"
                       /__\\   I      O  o             | Jogador: %s\s
                      //..\\\\  I     .                 | Vida: %d \s
                      \\].`[/  I                       | Dano: %d      \s
                      /l\\/j\\  (]    .  O              | Armadura: %d \s
                     /. ~~ ,\\/I          .
                     \\\\L__j^\\/I       o
                      \\/--v}  I     o   .
                      |    |  I   _________
                      |    |  I c(`       ')o
                      |    l  I   \\.     ,/
                    _/j  L l\\_!  _//^---^\\\\_
                    """, jogador.getNome(), jogador.getVida(), jogador.getAtaque(), jogador.getArmadura());
        }

        if (jogador instanceof Guerreiro ) {
            System.out.printf("""
                          _,.
                        ,` -.)
                       ( _/-\\\\-._
                      /,|`--._,-^|            ,
                      \\_| |`-._/||          ,'|
                        |  `-, / |         /  /
                        |     || |        /  /           | Jogador: %s
                         `r-._||/   __   /  /            | Vida: %d
                     __,-<_     )`-/  `./  /             | Dano: %d  \s
                    '  \\   `---'   \\   /  /              | Armadura: %d
                        |           |./  /
                        /           //  /
                    \\_/' \\         |/  /
                     |    |   _,^-'/  /
                     |    , ``  (\\/  /_
                      \\,.->._    \\X-=/^
                      (  /   `-._//^`
                       `Y-.____(__}
                    """, jogador.getNome(), jogador.getVida(), jogador.getAtaque(), jogador.getArmadura());
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.printf("""
                           _......._
                       .-'.'.'.'.'.'.`-.
                    /.'.'               '.\\
                    |.'    _.--...--._     |
                    \\    `._.-.....-._.'   /
                    |     _..- .-. -.._   |                | Inimigo: %s
                 .-.'    `.   ((@))  .'   '.-.             | Vida: %d
                ( ^ \\      `--.   .-'     / ^ )            | Dano: %d
                 /          .'     '.  .-    \\             | Armadura: %d
                ( _.\\    \\ (_`-._.-'_)    /._\\)
                 `-' \\   ' .--.          / `-'
                     |  / /|_| `-._.'\\   |
                     |   |       |_| |   /-.._
                 _..-\\   `.--.______.'  |
                     \\`.              .'
                          `-..___..-`
                 """, inimigo.getNome(), inimigo.getVida(), inimigo.getAtaque(), inimigo.getArmadura());

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
