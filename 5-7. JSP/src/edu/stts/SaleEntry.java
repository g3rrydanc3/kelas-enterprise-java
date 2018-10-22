package edu.stts;

public class SaleEntry {
    private String itemId = "-";
    private double discount = -1.0;
    private int numItems = 0;

    public double getItemCost() {
        double cost;
        if (itemId.startsWith("A")){
            cost = 1000 * getDiscount();
        }
        else if (itemId.startsWith("B")){
            cost = 800 * getDiscount();
        }
        else{
            cost = 600 * getDiscount();
        }
        return cost;
    }

    public double getTotalCost(){
        return getItemCost() * getNumItems();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }
}
