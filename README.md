![Banner RPG JAVA](https://i.imgur.com/LluE8xX.png)
#

## 1 - Proposta
<p>
    O jogo de RPG em Java é uma aplicação simples onde o jogador interage via console. O método iniciarJogo() da classe principal JogoRPG é chamado para começar o jogo. O jogador escolhe entre duas classes de personagens: Guerreiro ou Mago, criando uma instância apropriada da classe Jogador. Uma batalha então inicia contra um inimigo representado pela classe Inimigo. O jogo continua em um loop de ataques até que a vida de um dos personagens chegue a zero. Após a batalha, uma mensagem é exibida indicando se o jogador venceu ou foi derrotado, baseado na vida restante do jogador. A lógica do jogo é orientada a objetos, facilitando a adição de novas funcionalidades como mais classes de personagens, itens e habilidades especiais.
</p>

## 2 - Diagrama de classe
![Foto do diagrama de clase](https://i.imgur.com/VR3kdw8.png)

## 3 - Regra de Negócio
- Início do Jogo:
  - O jogo começa com uma mensagem de boas-vindas ao jogador.
  - O jogador é solicitado a escolher uma classe de personagem (Guerreiro ou Mago).
  - Com base na escolha do jogador, um objeto do tipo Jogador é instanciado com as características específicas da classe escolhida.
- Inicialização do Jogo:
  - O jogo exibe as características iniciais do jogador e do inimigo, incluindo vida, ataque e armadura.
  - O jogador escolhe um número de 1 a 10 para determinar quem inicia o jogo. Se o número escolhido pelo jogador for igual ao número escolhido pelo inimigo, o jogador deve escolher novamente até obter um número diferente.
- Turnos do Jogo:
  - O jogo alterna entre os turnos do jogador e do inimigo.
  - Em cada turno, o jogador ataca o inimigo usando o método atacar do objeto Jogador, passando o ataque do jogador e a armadura do inimigo como parâmetros.
  - O inimigo ataca o jogador da mesma forma, usando o método atacar do objeto Inimigo.
  - Se o ataque do jogador for bem-sucedido (ou seja, o dado rolado for maior ou igual à armadura do inimigo), o inimigo sofre dano.
  - Se o ataque do inimigo for bem-sucedido, o jogador sofre dano.
  - Se a vida de um personagem cair para 0 ou menos, o jogo termina com uma mensagem de vitória ou derrota, dependendo de quem morreu primeiro.
- Fim do Jogo:
  - O jogo termina quando um dos personagens (jogador ou inimigo) morre.
  - Se o jogador morrer, o jogo exibe uma mensagem de "Game Over".
  - Se o inimigo morrer, o jogo exibe uma mensagem de "Vitória".
 
