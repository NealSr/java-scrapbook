/**
 * A County POJO.
 */
public class County {
    /**
     * The County Name.
     */
    public String name;

    /**
     * The tax rate as a decimal.
     */
    public double taxRate;

    /**
     * The markup for Products in this county as a decimal.
     */
    public double countyMarkup;

    /**
     * Default Constructor.
     * @param name the County Name.
     * @param taxRate the County Tax Rate.
     * @param countyMarkup the markup for the county.
     */
    public County(String name, double taxRate, double countyMarkup) {
        this.name = name;
        this.taxRate = taxRate;
        this.countyMarkup = countyMarkup;
    }
}
