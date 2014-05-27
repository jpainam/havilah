/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publics.garment;

/**
 *
 * @author jpainam
 * Created : 14 Nov 2013
 * Modification : 14 Nov 2013
 */
public class Garment {
    protected int garmentNo;
    private String stockName;
    private double price;
    private double priceBump; 
    public Garment(){
        stockName = new String();
        price = 0.0;
        priceBump = 0.0;
    }
    public Garment(int no, String stockName, double price, double priceb){
        this.garmentNo = no;
        this.stockName = stockName;
        this.price = price;
        this.priceBump = priceb;
    }
    public Garment(String t, double p, double pb){
        this.stockName = t;
        this.price = p;
        this.priceBump = pb;
    }
    public int getGarmentNo() {
        return this.garmentNo;
    }

    public String getStockName() {
        return this.stockName;
    }

    public double getPrice() {
        return this.price;
    }

    public double getPriceBump() {
        return this.priceBump;
    }

    public void setGarmentNo(int garmentNo) {
        this.garmentNo = garmentNo;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPriceBump(double priceBump) {
        this.priceBump = priceBump;
    }

    @Override
    public String toString() {
        return "Garment{" + "garmentNo=" + garmentNo + ", stockName=" + stockName + ","
                + " price=" + price + ", priceBump=" + priceBump + '}';
    }
    
}
