import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Store that sells Product.
 */
public class Store {
    private Map<Product, Integer> inventory = new HashMap<>();
    private double totalCost;
    private double grossSales;
    private double taxesDue;

    /**
     * Gets the totalCost of Products in inventory.
     * @return the totalCost.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Gets the grossSales of Products in the store.
     * @return the grossSales.
     */
    public double getGrossSales() {
        return grossSales;
    }

    /**
     * Gets the taxesDue from sales in the store.
     * @return the taxesDue.
     */
    public double getTaxesDue() {
        return taxesDue;
    }

    /**
     * Calculates the net profit after original cost and taxes.
     * @return the net profit.
     */
    public double getNetProfit() {
        return grossSales - taxesDue - totalCost;
    }

    /**
     * Stocks products for sale and updats Store inventory and prices.
     * @param product the Product to stock.
     * @param quantity the number of Products to stock.
     */
    public void stockProducts(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            stockProduct(product);
        }
    }

    /**
     * Calculates the sale price and sells Product from inventory.
     * @param product the Product to sell.
     * @param county the County to sell in for tax and markup purposes.
     * @param quantity the number of Products to sell.
     * @return the sale price after markup and taxes.
     * @throws Exception if product is not in stock.
     */
    public double sellProducts(Product product, County county, int quantity) throws Exception {
        double totalSale = 0;
        for (int i = 0; i < quantity; i++) {
            totalSale += sellProduct(product, county);
        }
        return totalSale;
    }

    /**
     * Stocks product and updates inventory and totalCost.
     * @param product the Product to stock.
     */
    private void stockProduct(Product product) {
        if (inventory.containsKey(product)) {
            inventory.put(product, inventory.get(product) + 1);
            totalCost += product.costPrice;
        } else {
            inventory.put(product, 1);
            totalCost += product.costPrice;
        }
    }

    /**
     * Sells product and updates inventory, totalCost, grossSales, and taxesDue.
     * @param product the Product to sell.
     * @param county the County to sell in.
     * @return the price of the item after markup and taxes.
     * @throws Exception if a product is not in stock.
     */
    private double sellProduct(Product product, County county) throws Exception {
        double itemPrice = product.getPriceWithMarkup(county.countyMarkup);
        double itemTax = itemPrice * county.taxRate;
        if (inventory.containsKey(product) && inventory.get(product) > 0) {
            // deduct from inventory
            inventory.put(product, inventory.get(product) - 1);
            grossSales += itemPrice;
            grossSales += itemTax;
            taxesDue += itemTax;
        } else {
            throw new Exception("Out of Inventory for Product: " + product.toString());
        }

        return itemPrice + itemTax;
    }

    public int getInventoryCount() {
        int totalItems = 0;
        for (Integer quantity : inventory.values()) {
            totalItems += quantity;
        }
        return totalItems;
    }

    /**
     * Prints a quick summary of the store inventory and sales.
     * @return a formatted String with store inventory and sales details.
     */
    public String printStoreState() {
        String format = "The store has %d items with a cost of $%.2f."
                + "  Gross sales of $%.2f, taxes of $%.2f for a profit of: $%.2f";
        return String.format(format, getInventoryCount(),
                getTotalCost(), getGrossSales(), getTaxesDue(), getNetProfit());
    }
}
