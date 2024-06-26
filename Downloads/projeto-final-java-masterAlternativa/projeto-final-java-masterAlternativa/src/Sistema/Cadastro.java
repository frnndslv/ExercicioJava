package Sistema;

import Console.Console;
import Models.Jogador;
import Models.Deck;

public class Cadastro {

    public static Jogador cadastrarJogador() {

        Jogador jogadortemporario = new Jogador();
        System.out.println("\nPor favor digite o nome de usuario: ");
        jogadortemporario.setNome(Console.lerString());
        System.out.println("\nJogador cadastrado com sucesso!");
        return jogadortemporario;

    }

    public static Deck cadastrarNovoDeck() {
        Deck deckTemporario = new Deck();
        System.out.println("\nPor favor digite o nome do seu Deck: ");
        deckTemporario.setNomeDoDeck(Console.lerString());
        deckTemporario.setListadecartas(null);
        System.out.println("\nDeck cadastrado com sucesso!");
        return deckTemporario;

    }
}
