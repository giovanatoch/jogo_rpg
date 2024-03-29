abstract class Jogador {
    int vida;
    int ataque;
    int armadura;

    public Jogador(int vida, int ataque, int armadura) {
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    public abstract int atacar(int dano, int armadura);

    public void vidaAtual(int dano) {
        setVida(vida -= dano);

        if (vida <= 0) {
            System.out.printf("Você sofreu %d de dano%nVocê morreu!!%n!!! GAME OVER !!!%n", dano);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else {
            System.out.printf("Você sofreu %d de dano%nVida atual: %d%n", dano, getVida());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getArmadura() {
        return armadura;
    }

}

