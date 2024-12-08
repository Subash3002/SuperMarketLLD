import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCounter=0;
    private String orderId;

    private List<AddedProduct> productsBought;

    private float total;

    public Order(List<AddedProduct> productsBought) {
        this.productsBought = new ArrayList<>(productsBought);
        this.orderId=generateOrderId();
        this.total=calculateTotal();
    }

    public String generateOrderId(){
        orderCounter++;
        return String.valueOf(orderCounter);
    }

    public float calculateTotal(){
        float tot=0f;
        for(AddedProduct product:productsBought)tot+=product.getProductPrice()*product.getAddedQuantity();
        return tot;
    }

    public void generateBill(){
        float discounted=(SuperMarketSystem.getCurrentDiscount()*0.01f)*this.total;
        System.out.println("Total Bill = "+this.total);
        System.out.println("Discount Percent = "+SuperMarketSystem.getCurrentDiscount()+" %");
        System.out.println("Amount Discounted = "+String.format("%.2f",discounted));
        System.out.println("Total Bill after Discount = "+(this.total-discounted));
    }

    public String getOrderId() {
        return orderId;
    }

    public List<AddedProduct> getProductsBought() {
        return productsBought;
    }

    public float getTotal() {
        return total;
    }
}
