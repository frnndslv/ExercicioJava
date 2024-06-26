package Models;

public class CartaDeDefesa extends Carta {

    int block;

    public CartaDeDefesa() {

    }

    public CartaDeDefesa(String nomeDaCarta, String descricaoDacarta, int raridade, int custoDemana, int poder,
            int block) {
        super(nomeDaCarta, descricaoDacarta, raridade, custoDemana, poder);

    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "\nCarta De Defesa [nomeDaCarta=" + nomeDaCarta + "\nBlock=" + block + "\nDescrição Da carta="
                + descricaoDacarta + "Raridade=" + raridade + "\nCustoDemana=" + custoDemana + "\nPoder=" + poder
                + "]";
    }

}
