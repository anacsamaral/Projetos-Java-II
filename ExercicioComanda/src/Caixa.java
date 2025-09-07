import java.util.ArrayList;
import java.util.List;

class Caixa {
    private List<Comanda> comandas;

    public Caixa() {
        this.comandas = new ArrayList<>();
    }

    public void addComanda(Comanda comanda) {
        comandas.add(comanda);
    }

    public Comanda getComanda(int id) {
        return comandas.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}