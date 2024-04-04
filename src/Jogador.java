abstract class Jogador {
    int vida;
    int ataque;
    int armadura;
    String nome;

    // Construtor que contém variaveis obrigatorias para construção de Classes existentes na subclasses
    public Jogador(int vida, int ataque, int armadura, String nome) {
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
        this.nome = nome;
    }

    // Metodo abstrato para ser tratado de forma individual nas subclasses
    public abstract int atacar(int dano, int armadura);

    // Metodo responsavel por receber um dano via parametro do atacante e abater na vida do oponente
    public void verificarVida(int dano) {
        setVida(vida -= dano);

        if (vida <= 0) {
            System.out.printf("Você sofreu %d de dano%nVocê morreu!!%n!!! GAME OVER !!!%n", dano);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else {
            System.out.printf("Você sofreu %d de dano%nVida atual: %d%n", dano, getVida());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    // Metodo para retornar vida do Jogador e/ou Inimigo
    public int getVida() {
        return this.vida;
    }

    // Metodo para retornar nome do Jogador
    public String getNome() {
        return nome;
    }

    // Metodo para sobrescrever a vida do Jogador e/ou Inimigo
    public void setVida(int vida) {
        this.vida = vida;
    }

    // Metodo para retornar ataque do Jogador e/ou Inimigo
    public int getAtaque() {
        return ataque;
    }

    // Metodo para retornar armadura do Jogador e/ou Inimigo
    public int getArmadura() {
        return armadura;
    }

}

