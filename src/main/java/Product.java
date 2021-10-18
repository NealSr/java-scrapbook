/**
 * A Product for sale.
 */
public class Product {
    public String brandName;
    public String productName;
    public double costPrice;

    /**
     * Default constructor.
     * @param brandName the public brand name.
     * @param productName the internal product name.
     * @param costPrice the initial cost of the product.
     */
    public Product(String brandName, String productName, double costPrice) {
        this.brandName = brandName;
        this.productName = productName;
        this.costPrice = costPrice;
    }

    /**
     * Calculates the price of a product after a decimal markup.
     * @param markup the percent to markup as a decimal.
     *
     * @return the price after markup.
     */
    public double getPriceWithMarkup(double markup) {
        return costPrice * (markup + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;

        if (Double.compare(product.costPrice, costPrice) != 0) {
            return false;
        }
        if (brandName != null ? !brandName.equals(product.brandName) : product.brandName != null) {
            return false;
        }
        return productName != null ? productName.equals(product.productName) : product.productName == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brandName != null ? brandName.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        temp = Double.doubleToLongBits(costPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "brandName='" + brandName + '\'' +
                ", productName='" + productName + '\'' +
                ", costPrice=" + costPrice +
                '}';
    }
}
