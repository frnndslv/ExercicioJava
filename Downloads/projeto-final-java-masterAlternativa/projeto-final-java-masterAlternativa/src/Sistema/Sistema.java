package Sistema;

import java.util.ArrayList;
import java.util.List;

import Console.Console;
import Models.Jogador;
import Models.Carta;
import Models.CartasDoJogo;
import Models.Deck;

public class Sistema {
    // lista statica, pra que assim que inicializar o programa ja ter
    // uma lista ( mesmo que vazia) pra checar o login.
    static List<Jogador> jogadores = new ArrayList<Jogador>();
    static List<Deck> decks = new ArrayList<Deck>();
    static CartasDoJogo cartaDoJogo = new CartasDoJogo();

    static int posicaoindiceJogadorlogado = -1;

    // menu inicial
    public static void menuFluxo() {
        int op;
        System.out.println("\nTeste");
        cartaDoJogo.InicializarListaDeCartas();
        System.out.println("\nBem vindos ao slay the lascado ");

        do {

            Menu.menuLogin();
            op = Console.lerInt();
            switch (op) {
                case 1:
                    verificarLogin();
                    break;
                case 2:
                    jogadores.add(Cadastro.cadastrarJogador());
                    break;
                case 0:
                    sair();
                    break;
                default:
                    break;
            }

        } while (op != 0);
    }

    public static void menuDeck() {
        int op;
        do {
            Menu.menuDeck();
            op = Console.lerInt();
            switch (op) {
                case 1:
                    jogadores.get(posicaoindiceJogadorlogado).addDeckDoJogador(Cadastro.cadastrarNovoDeck());
                    editarDeck();
                    break;
                case 2:
                    verDecksCadastrados();
                    break;
                case 3:
                    verDecksIncompletos();
                    break;
                case 4:
                    editarDeck();
                    break;
                case 5:
                    verDecksCadastrados();
                    break;
                case 0:
                    break;

                default:
                    System.out.println("\nDigite uma opçao valida");
                    break;
            }
        } while (op != 0);

    }

    public static void sair() {
        System.out.println("\nAté a proxima! ");
    }

    public static void verificarLogin() {
        System.out.println("\nPor favor digite o nome de usuario cadastrado: ");
        String jogadorAserBuscado = Console.lerString();

        for (int i = 0; i < jogadores.size(); i++) {

            if (jogadores.get(i).getNome().equals(jogadorAserBuscado)) {
                posicaoindiceJogadorlogado = i;
            }
        }
        if (posicaoindiceJogadorlogado != -1) {
            System.out.println("\nLogado com sucesso!");
            menuDeck();
        } else {
            System.out.println("\nJogador nao cadastrado!");
            System.out.println("\nPor favor cadastre um usuario!");
        }

    }

    public static void editarDeck() {

        List<Deck> decksCadastrados = jogadores.get(posicaoindiceJogadorlogado).getListaDeDeckesDoJogador();

        System.out.println("\nSelecionar deck para editar");
        verDecksCadastrados();
        int numeroDoDeckIncompleto = Console.lerInt();

        Deck deckParaEditar = decksCadastrados.get(numeroDoDeckIncompleto - 1);

        int op;
        do {
            Menu.menuEditarDeckIncompleto();
            op = Console.lerInt();
            switch (op) {
                case 1:
                    adicionarCartaAoDeck(deckParaEditar);
                    break;
                case 2:
                    removerCartaDoDeck(deckParaEditar);
                    break;
                case 3:
                    visualizarCartasDoDeck(deckParaEditar);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nDigite uma opção valida");
                    break;
            }
        } while (op != 0);

        jogadores.get(posicaoindiceJogadorlogado).getListaDeDeckesDoJogador().set(numeroDoDeckIncompleto - 1,
                deckParaEditar);

    }

    public static void verDecksCadastrados() {
        Jogador jogadorLogado = jogadores.get(posicaoindiceJogadorlogado);
        List<Deck> deckDoJogador = jogadorLogado.getListaDeDeckesDoJogador();
        System.out.println("\nDecks Cadastrados");
        for (int i = 0; i < deckDoJogador.size(); i++) {
            System.out.print("\nDeck numero: " + (i + 1));
            System.out.println(" " + deckDoJogador.get(i).getNomeDoDeck());
        }
    }

    public static void verDecksIncompletos() {
        Jogador jogadorLogado = jogadores.get(posicaoindiceJogadorlogado);
        List<Deck> deckDoJogador = jogadorLogado.getListaDeDeckesDoJogador();
        System.out.println("\nDecks Incompletos");
        for (int i = 0; i < deckDoJogador.size(); i++) {
            if (deckDoJogador.get(i).getListadecartas() == null
                    || deckDoJogador.get(i).getListadecartas().size() < 15) {
                System.out.print("\nDeck numero: " + (i + 1));
                System.out.println(" " + deckDoJogador.get(i).getNomeDoDeck());
            }
        }
    }

    public static void verOpcoesDeCartas() {
        System.out.println("\nCartas que podem ser selecionadas: ");
        for (int i = 0; i < cartaDoJogo.listaDecartas.size(); i++) {
            System.out.println((i + 1) + ". " + cartaDoJogo.listaDecartas.get(i).toString());
        }
    }

    // esse metodo adiciona uma nova carta , seja num deck novo ou em um deck criado
    // e incompleto.
    // pego o deck coloco uma carta dentro dele setto ele e depois devolvo pro menu.
    public static Deck adicionarCartaAoDeck(Deck deck) {

        List<Carta> listaDeCartasDoDeck = deck.getListadecartas();

        if (listaDeCartasDoDeck == null) {
            listaDeCartasDoDeck = new ArrayList<Carta>();
        }

        if (listaDeCartasDoDeck.size() < 15) {
            verOpcoesDeCartas();
            System.out.println("\nDigite o numero da carta que você quer adicionar no deck: ");
            int numeroDaCarta = Console.lerInt();

            List<Carta> listaDeCartasDoJogo = cartaDoJogo.getCarta();

            listaDeCartasDoDeck.add(listaDeCartasDoJogo.get(numeroDaCarta - 1));

            deck.setListadecartas(listaDeCartasDoDeck);
        } else {
            System.out.println("\nO deck esta completo!");
        }
        return deck;
    }

    public static void visualizarCartasDoDeck(Deck deck) {
        List<Carta> listaDeCartasDoDeck = deck.getListadecartas();
        for (int i = 0; i < listaDeCartasDoDeck.size(); i++) {
            System.out.println((i + 1) + ". " + listaDeCartasDoDeck.get(i).toString());
        }
    }

    public static Deck removerCartaDoDeck(Deck deck) {

        List<Carta> listaDeCartasDoDeck = deck.getListadecartas();

        System.out.println("\nDigite o numero da carta que você quer remover no deck: ");
        int numeroDaCarta = Console.lerInt();
        listaDeCartasDoDeck.remove(numeroDaCarta - 1);
        deck.setListadecartas(listaDeCartasDoDeck);

        return deck;
    }

}
