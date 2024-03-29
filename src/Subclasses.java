import java.util.Random;
class Guerreiro extends Jogador {
    public Guerreiro() {
        super(150, 8, 14);
    }

    @Override
    public int atacar() {
        Random rand = new Random();
        int dado = rand.nextInt(20) + 1;
        if (dado >= getArmaduraInimigo()) {
            int dano = rand.nextInt(8) + 1;
            System.out.println("Você acertou o inimigo! O dado que rolou foi " + dado + ", e causou " + dano + " de dano!");
            return dano;
        } else {
            System.out.println("Você errou o ataque! O dado que rolou foi " + dado);
            return 0;
        }
    }
}

class Mago extends Jogador {
    public Mago() {
        super(100, 12, 12);
    }
    @Override
    public int atacar() {
        Random rand = new Random();
        int dado = rand.nextInt(20) + 1;
        if (dado >= getArmaduraInimigo()) {
            int dano = rand.nextInt(12) + 1;
            System.out.println("Você acertou o inimigo! O dado que rolou foi " + dado + ", e causou " + dano + " de dano!");
            return dano;
        } else {
            System.out.println("Você errou o ataque! O dado que rolou foi " + dado);
            return 0;
        }
    }
}

//INIMIGOS
class Inimigo extends Jogador {
    public Inimigo() {
        super(120, 12, 12);
    }

    @Override
    public int getArmaduraInimigo() {
        return super.getArmadura();
    }

    public int getVidaInimigo() {
        return super.vida;
    }

    @Override
    public int atacar() {
        Random rand = new Random();
        int dado = rand.nextInt(20) + 1;
        if (dado >= getArmaduraJogador()) {
            int dano = rand.nextInt(12) + 1;
            System.out.println("Você acertou o inimigo! O dado que rolou foi " + dado + ", e causou " + dano + " de dano!");
            return dano;
        } else {
            System.out.println("Você errou o ataque! O dado que rolou foi " + dado);
            return 0;
        }
    }
}

