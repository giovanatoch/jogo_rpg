import java.util.Random;

public class Guerreiro extends Jogador {
    Random random = new Random();
    int ataqueRandom = random.nextInt(12) + 1;
    public Guerreiro() {
        super(12, 8);

    }

    public int ataque() {
        return this;
    }
}
