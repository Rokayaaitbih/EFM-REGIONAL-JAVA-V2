import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Boutique {;
    private ArrayList<Produit> produits;

    public Boutique() {
        produits = new ArrayList<>();
    }

    public int indiceDe(int code) {
        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getCode() == code) {
                return i;
            }
        }
        return -1;
    }

    public void ajouter(Produit p) throws Exception {
        if (indiceDe(p.getCode()) != -1) {
            throw new Exception("Le produit existe déjà dans la boutique.");
        }
        produits.add(p);
    }

    public boolean supprimer(int code) {
        int index = indiceDe(code);
        if (index != -1) {
            produits.remove(index);
            return true;
        }
        return false;
    }

    public boolean supprimer(Produit p) {
        return produits.remove(p);
    }

    public int nombreProduitsEnSolde() {
        int count = 0;
        for (Produit p : produits) {
            if (p instanceof ProduitEnSolde) {
                count++;
            }
        }
        return count;
    }

    public void enregistrer(String chemin) throws IOException {
        FileWriter writer = new FileWriter(chemin);
        for (Produit p : produits) {
            writer.write(p.toString() + "\n");
        }
        writer.close();
    }
}
