import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private Jogador jogador;
    private final Inimigo inimigo;

    // Criação e atribuição da variavel inimigo
    public Jogo() {
        this.jogador = null;
        this.inimigo = new Inimigo();
    }
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    // Metodo responsavel por retornar variaveis de nome e subclasse escolhidas pelo Jogador, variaveis de Inimigo,quem começa a batalha, e looping de batalha
    public void iniciarJogo() {

        String nome = mostrarNomeJogador();

        boolean exit = false;

        retornarEscolhaJogador(nome, exit);

        if (jogador instanceof Mago) {
            System.out.printf("""
                                      .
                                       .
                             /^\\     .
                        /\\   "V"
                       /__\\   I      O  o             | Jogador(a): %s\s
                      //..\\\\  I     .                | Vida: %d \s
                      \\].`[/  I                       | Dano: %d      \s
                      /l\\/j\\  (]    .  O             | Armadura: %d \s
                     /. ~~ ,\\/I          .
                     \\\\L__j^\\/I       o
                      \\/--v}  I     o   .
                      |    |  I   _________
                      |    |  I c(`       ')o
                      |    l  I   \\.     ,/
                    _/j  L l\\_!  _//^---^\\\\_
                    """, jogador.getNome(), jogador.getVida(), jogador.getAtaque(), jogador.getArmadura());
        }

        if (jogador instanceof Guerreiro) {
            System.out.printf("""
                          _,.
                        ,` -.)
                       ( _/-\\\\-._
                      /,|`--._,-^|            ,
                      \\_| |`-._/||          ,'|
                        |  `-, / |         /  /
                        |     || |        /  /           | Jogador(a): %s
                         `r-._||/   __   /  /            | Vida: %d
                     __,-<_     )`-/  `./  /             | Dano: %d  \s
                    '  \\   `---'   \\   /  /            | Armadura: %d
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

        if (jogador instanceof Druida) {
            System.out.printf("""
                                       ;
                                       `,
                                      ' :.
                                __      `;.
                              /' /\\   ,   \\                          
                            /   |ee|      `;
                           (    |_,| ,     `,                  | Jogador(a): %s
                            )  , \\ '       `:                 | Vida: %d
                           |    ""\""----,__,_.____,_  \s      | Dano: %d  \s
                           ;      _     |--,_;    '            | Armadura: %d
                          ,     ,' `"---'  ,: 
                          |    ,  : /,     ,'
                          |       ,/'     ,;
                          |   '   :|  ,   /'
                          ,        |    ,;
                         ,         |  , :'
                         |         `   ,'
                        ,'          `  ;
                    __==' ___, pb __/_
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
                ( ^ \\      `--.   .-'     / ^ )           | Dano: %d
                 /          .'     '.  .-    \\            | Armadura: %d
                ( _.\\    \\ (_`-._.-'_)    /._\\)
                 `-' \\   ' .--.          / `-'
                     |  / /|_| `-._.'\\   |
                     |   |       |_| |   /-.._
                 _..-\\   `.--.______.'  |
                     \\`.              .'
                          `-..___..-`
                 """, inimigo.getNome(), inimigo.getVida(), inimigo.getAtaque(), inimigo.getArmadura());

        System.out.println("===================================");
        boolean primeiroRound = sortearQuemComecaOJogo();
        System.out.println("===================================");

        while (true) {
            if (primeiroRound) {
                inimigo.verificarVida(jogador.atacar(jogador.ataque, inimigo.armadura));
                if (inimigo.getVida() <= 0) {
                    break;
                }
                jogador.verificarVida(inimigo.atacar(inimigo.ataque, jogador.armadura));
                if (jogador.getVida() <= 0) {
                    break;
                }
            } else {
                jogador.verificarVida(inimigo.atacar(inimigo.ataque, jogador.armadura));
                if (jogador.getVida() <= 0) {
                    break;
                }
                inimigo.verificarVida(jogador.atacar(jogador.ataque, inimigo.armadura));
                if (inimigo.getVida() <= 0) {
                    break;
                }
            }
        }
    }

    // Metodo responsavel por retornar boas vindas e atribuir nome do jogador
    private String mostrarNomeJogador() {
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
        return nome;
    }

    // Metodo responsavel por retornar e atribuir a escolha de subclasse do Jogador
    private void retornarEscolhaJogador(String nome, boolean exit) {
        System.out.printf("Escolha sua classe, %s: %n", nome);
        System.out.println("1. Guerreiro(a)");
        System.out.println("2. Mago(a)");
        System.out.println("3. Druida");
        int escolha = 0;
        while (!exit) {
            try {
                String escolhaJogador = scanner.next();
                escolha = Integer.parseInt(escolhaJogador);
                if (escolha != 1 && escolha != 2 && escolha != 3) {
                    System.out.println("Número inválido, tente novamente! ");
                } else {
                    exit = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número novamente.");
            }
        }
        switch (escolha) {
            case 1:
                System.out.println("Você escolheu a classe Guerreiro(a).");
                jogador = new Guerreiro(nome);
                break;
            case 2:
                System.out.println("Você escolheu a classe personagem Mago(a).");
                jogador = new Mago(nome);
                break;
            case 3:
                System.out.println("Você escolheu a classe personagem Druida.");
                jogador = new Druida(nome);
                break;
            default:
                System.out.println("Escolha inválida. Tente novamente.");
        }

        System.out.println("A batalha está prestes a começar!");
        System.out.println("===================================");
    }

    // Metodo responsavel por verificar de forma aleatoria quem começa a batalha
    private boolean sortearQuemComecaOJogo() {

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
            return primeiroRound;
        } else {
            System.out.println("\nSeu inimigo começa: ");
            primeiroRound = false;
            return primeiroRound;
        }
    }
}

