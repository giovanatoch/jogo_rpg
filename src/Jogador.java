import java.util.Random;
abstract class Jogador {
    private int vida;
    private int ataque;
    private int armadura;

    public Jogador(int vida, int ataque, int armadura) {
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    public abstract int atacar();

    public boolean vidaAtual(int dano) {
        if (dano >= vida) {
            System.out.println("Você morreu.");
            return true;
        } else {
            vida -= dano;
            System.out.println("Você sofreu isso de dano: " + dano + "\n Sua vida atual: " + vida );
            return false;
        }
    }

    public int getVidaJogador() {
        return vida;
    }
    public void setVidaJogador(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getArmaduraJogador() {
        return armadura;
    }
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
}

