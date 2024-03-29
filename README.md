![Banner Git Cheat](https://i.imgur.com/dHpKwAf.png)
#

## 1 - Proposta
<p>
    O jogo de RPG em Java é uma aplicação simples onde o jogador interage via console. O método iniciarJogo() da classe principal JogoRPG é chamado para começar o jogo. O jogador escolhe entre duas classes de personagens: Guerreiro ou Mago, criando uma instância apropriada da classe Jogador. Uma batalha então inicia contra um inimigo representado pela classe Inimigo. O jogo continua em um loop de ataques até que a vida de um dos personagens chegue a zero. Após a batalha, uma mensagem é exibida indicando se o jogador venceu ou foi derrotado, baseado na vida restante do jogador. A lógica do jogo é orientada a objetos, facilitando a adição de novas funcionalidades como mais classes de personagens, itens e habilidades especiais.
</p>

## 2 - Diagrama de classe

## 3 - Regra de Negócio
### Classe JogoRPG:

Método main(String[] args): Inicia o jogo.
### 1- Classe Jogo:

Atributos jogador e inimigo.
Método iniciarJogo(): Começa uma batalha entre jogador e inimigo.
### 2- Classe Jogador:

Atributos vida, ataque, armadura.
Método atacar(Inimigo inimigo): Reduz a vida do inimigo.
Método estaVivo(): Verifica se o jogador está vivo.

### 3- Classes Guerreiro e Mago (subclasses de Jogador):

Métodos específicos de cada classe.
### 4- Classe Inimigo:

Atributos vida e ataque.
Método atacar(Jogador jogador): Reduz a vida do jogador.
Método vidaAtual(): Verifica se o inimigo está vivo.
