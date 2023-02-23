import java.util.Objects;

public class Produit {
    private Integer code;
    private double originalPrice;
    private double discountPercentage;

    public Produit(Integer code, double originalPrice) {
        this.code = code;
        this.originalPrice = originalPrice;
    }

    public Produit(Integer code, double originalPrice, double discountPercentage) {
        this.code = code;
        this.originalPrice = originalPrice;
        this.discountPercentage = discountPercentage;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double prixProduit() {
        if (discountPercentage > 0) {
            return originalPrice - (originalPrice * (discountPercentage / 100.0));
        } else {
            return originalPrice;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        return Objects.equals(this.code, other.code);
    }

    @Override
    public String toString() {
        return code + ";" + originalPrice + ";" + discountPercentage;
    }
}
