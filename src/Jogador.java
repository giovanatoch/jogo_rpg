import java.util.Random;
public class Jogador {
    Random random = new Random();

    private int vida;
    private int ataque;
    private int armadura;

    public Jogador(int armadura, int ataque) {
        this.vida = 100; // Valor inicial de vida
        this.ataque = ataque; // Valor inicial de ataque
        this.armadura = armadura;
    }

    public int atacar() {
        int dado = random.nextInt(20) + 1;

        if (dado >= 12) {
            System.out.printf("Você tirou no dado: %d %nO inimigou sofreu esse dano: %d%n", dado, ataque);
            return ataque;
        } else {
            System.out.printf("Você tirou no dado: %d %nO inimigou não sofreu dano.%n", dado);
            return 0;
        }
    }

    public boolean estaVivo(int dano) {
        if (dano >= vida) {
            System.out.println("Você morreu.");
            return true;
        } else {
            vida -= dano;
            System.out.println("Você sofreu isso de dano: " + dano + "\n Sua vida atual: " + vida );
            return false;
        }
    }

    public int getVida() {
        return vida;
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

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
}

