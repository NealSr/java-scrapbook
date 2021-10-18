import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void testGetPriceWithMarkup_noMarkup()
    {
        Product product = new Product("brandName", "productName", 100);
        assertEquals("No markup should return original price.", 100, product.getPriceWithMarkup(0), 0);
    }

    @Test
    public void testGetPriceWithMarkup_percentMarkup()
    {
        Product product = new Product("brandName", "productName", 100);
        assertEquals("50% markup should return 150.", 150, product.getPriceWithMarkup(0.50), 0);
    }

    @Test
    public void testGetPriceWithMarkup_largeMarkup()
    {
        Product product = new Product("brandName", "productName", 100);
        assertEquals("300% markup should return 4x original price.", 400, product.getPriceWithMarkup(3), 0);
    }
}
