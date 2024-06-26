package Sistema;

public class Menu {

    public static void menuLogin() {
        System.out.println("\nSelecione uma das opçoes a seguir: ");
        System.out.println("\n1) Login");
        System.out.println("\n2) Novo cadastro");
        System.out.println("\n0) Sair");
    }

    public static void menuDeck() {
        System.out.println("\n1) cadastrar novo deck");
        System.out.println("\n2) ver decks cadastrados");
        System.out.println("\n3) ver decks incompletos");
        System.out.println("\n4) editar decks incompletos");
        System.out.println("\n5) Menu batalhas simuladas");
        System.out.println("\n0) Voltar para o menu anterior");
    }

    public static void menuEditarDeckIncompleto() {
        System.out.println("\n1) adicionar carta ao deck");
        System.out.println("\n2) remover carta do deck");
        System.out.println("\n3) ver cartas do deck");
        System.out.println("\n0) voltar para o menu anterior");
    }

}
