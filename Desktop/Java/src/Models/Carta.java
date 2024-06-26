package Models;

public class Carta {

    protected String nomeDaCarta;
    protected String descricaoDacarta;
    protected int raridade;
    protected int custoDemana;
    protected int poder;

    public Carta() {
    }

    public Carta(String nomeDaCarta, String descricaoDacarta, int raridade, int custoDemana, int poder) {
        this.nomeDaCarta = nomeDaCarta;
        this.descricaoDacarta = descricaoDacarta;
        this.raridade = raridade;
        this.custoDemana = custoDemana;
        this.poder = poder;
    }

    public String getNomeDaCarta() {
        return nomeDaCarta;
    }

    public void setNomeDaCarta(String nomeDaCarta) {
        this.nomeDaCarta = nomeDaCarta;
    }

    public String getDescricaoDacarta() {
        return descricaoDacarta;
    }

    public void setDescricaoDacarta(String descricaoDacarta) {
        this.descricaoDacarta = descricaoDacarta;
    }

    public int getRaridade() {
        return raridade;
    }

    public void setRaridade(int raridade) {
        this.raridade = raridade;
    }

    public int getCustoDemana() {
        return custoDemana;
    }

    public void setCustoDemana(int custoDemana) {
        this.custoDemana = custoDemana;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    @Override
    public String toString() {
        return "\nCarta [nomeDaCarta=" + nomeDaCarta + "\nDescricao Da carta=" + descricaoDacarta + "\nRaridade="
                + raridade
                + "\nCustoDemana=" + custoDemana + "\nPoder=" + poder + "]";
    }

}
