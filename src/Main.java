//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Jogador jogador = new Jogador(12,10);
        Guerreiro guerreiro = new Guerreiro();

        jogador.atacar();
        jogador.estaVivo(100);
    }
}