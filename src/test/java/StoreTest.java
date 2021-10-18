import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StoreTest {
    @Test
    public void codeChallengeSolution() throws Exception {
        County miamiDadeCounty = new County("Miami-Dade", 0.06, 0.25);
        County browardCounty = new County("Broward", 0.07, 0.30);
        County palmBeachCounty = new County("Palm Beach", 0.08, 0.30);
        Product product = new Product("Super Cool Product", "coolerMectin", 30.00);
        Store coolerMectinStore = new Store();

        coolerMectinStore.stockProducts(product, 300);
        coolerMectinStore.sellProducts(product, miamiDadeCounty, 100);
        coolerMectinStore.sellProducts(product, browardCounty, 100);
        coolerMectinStore.sellProducts(product, palmBeachCounty, 100);

        System.out.println(coolerMectinStore.printStoreState());
    }

    @Test
    public void testStockProducts() {
        Store store = new Store();
        store.stockProducts(new Product("brand", "name", 50), 10);
        store.stockProducts(new Product("brand2", "name2", 25), 20);
        assertEquals("Total Cost should include all products", 1000, store.getTotalCost(), 0);
    }

    @Test
    public void testSellProducts() throws Exception {
        County mockCounty = new County("mockCounty", 0.10, 1.00);
        Product mockProduct = new Product("brand", "name", 100);
        Store store = new Store();

        store.stockProducts(mockProduct, 100);
        store.sellProducts(mockProduct, mockCounty, 50);
        assertEquals("Half of items should be sold.",
                "The store has 50 items with a cost of $10000.00."
                        + "  Gross sales of $11000.00, taxes of $1000.00 for a profit of: $0.00", store.printStoreState());
        store.sellProducts(mockProduct, mockCounty, 50);
        assertEquals("All items should be sold.",
                "The store has 0 items with a cost of $10000.00."
                        + "  Gross sales of $22000.00, taxes of $2000.00 for a profit of: $10000.00", store.printStoreState());

    }

    @Test
    public void testSellProducts_throwsExceptionWhenOutOfProduct() {
        County mockCounty = new County("mockCounty", 0.10, 1.00);
        Product mockProduct = new Product("brand", "name", 100);
        Store store = new Store();
        try {
            store.sellProducts(mockProduct, mockCounty, 10);
        } catch (Exception oope) {
            assertEquals("Out of Inventory for Product: "
                    + "Product{brandName='brand', productName='name', costPrice=100.0}", oope.getMessage());
        }
    }

    @Test
    public void emptyStore()
    {
        Store store = new Store();
        assertEquals(0, store.getTotalCost(), 0);
        assertEquals(0, store.getTaxesDue(), 0);
        assertEquals(0, store.getGrossSales(), 0);
        assertEquals(0, store.getNetProfit(), 0);
        assertEquals("Store State should be initialized to zero.",
            "The store has 0 items with a cost of $0.00."
                    + "  Gross sales of $0.00, taxes of $0.00 for a profit of: $0.00", store.printStoreState());
    }

}
