import java.util.Random;
class Guerreiro extends Jogador {

    public Guerreiro(String nome) {
        super(150, 10, 14, nome);
    }

    @Override
    public int atacar(int dano, int armadura) {
        Random rand = new Random();
        int dado = rand.nextInt(20) + 1;

        if (dado >= armadura) {
            dano = rand.nextInt(dano) + 1;
            System.out.println("Você acertou o inimigo! O dado que rolou foi " + dado + ", e causou " + dano + " de dano!");
            return dano;
        } else {
            System.out.println("Você errou o ataque! O dado que rolou foi " + dado);
            return 0;
        }
    }
}

class Mago extends Jogador {
    public Mago(String nome) {
        super(125, 12, 12, nome);
    }
    @Override
    public int atacar(int dano, int armadura) {
        Random rand = new Random();
        int dado = rand.nextInt(20) + 1;

        if (dado >= armadura) {
            dano = rand.nextInt(dano) + 1;
            System.out.println("Você acertou o inimigo! O dado que rolou foi " + dado);
            return dano;
        } else {
            System.out.println("Você errou o ataque! O dado que rolou foi " + dado);
            return 0;
        }
    }
}

class Druida extends Jogador {

    public Druida(String nome) {
        super(150, 12, 14, nome);
    }

    @Override
    public int atacar(int dano, int armadura) {
        Random rand = new Random();
        int dado = rand.nextInt(20) + 1;

        if (dado >= armadura) {
            dano = rand.nextInt(dano) + 1;
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
        super(130, 11, 13, "Grognar, o ABOMINÁVEL");
    }

    @Override
    public int atacar(int dano, int armadura) {
        Random rand = new Random();
        int dado = rand.nextInt(20) + 1;

        if (dado >= armadura) {
            dano = rand.nextInt(dano) + 1;
            System.out.println("O inimigo te acertou! O dado que rolou foi " + dado);
            return dano;
        } else {
            System.out.println("Inimigo errou o ataque! O dado que rolou foi " + dado);
            return 0;
        }
    }

    public void verificarVida(int dano) {
        int vida = this.getVida();
        setVida(vida -= dano);

        if (vida <= 0) {
            System.out.printf("Seu inimigo sofreu %d de dano%nSeu inimigo morreu!!%n!!! VITORIA !!!%n", dano);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        } else {
            System.out.printf("Seu inimigo sofreu %d de dano%nVida atual do inimigo: %d%n", dano, getVida());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}

