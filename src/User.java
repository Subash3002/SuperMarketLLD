import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AddedProduct{
    private String productName;
    private int addedQuantity;

    private float productPrice;

    public float getProductPrice() {
        return productPrice;
    }

    public AddedProduct(String productName, int addedQuantity, float productPrice) {
        this.productName = productName;
        this.addedQuantity = addedQuantity;
        this.productPrice=productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getAddedQuantity() {
        return addedQuantity;
    }
}

public class User {
    private String userName;
    private HashMap<String,Order> orders;
    private List<AddedProduct> productsAdded;

    public User(String userName) {
        this.userName = userName;
        this.orders = new HashMap<>();
        productsAdded=new ArrayList<>();
    }


    public void buyProduct(String productName,int quantity){
        PurchaseResponse response = SuperMarketSystem.buyProduct(productName, quantity);
        switch (response) {
            case PRODUCT_NOT_FOUND:
                System.out.println("Product not available.");
                break;
            case INSUFFICIENT_STOCK:
                System.out.println("Stock is less than your need.");
                break;
            case SUCCESS:
                System.out.println("Product bought successfully.");
                productsAdded.add(new AddedProduct(productName,quantity,SuperMarketSystem.getProductCatlog().get(productName).getProductPrice()));
                break;
        }
    }

    public void placeOrder(){
        Order order=new Order(productsAdded);
        orders.put(order.getOrderId(),order);
        order.generateBill();
        productsAdded.clear();
    }

    public void viewCart(){
        if(productsAdded.isEmpty()){
            System.out.println("Your cart is Empty,Add products first.");
            return;
        }
        productsAdded.stream().forEach(product-> System.out.println(product.getProductName()+" "+product.getProductPrice()+" "+product.getAddedQuantity()));
    }

    public void viewOrders(){
        System.out.println("Your orders are : ");
        orders.values().stream()
                .forEach(order->{
                    System.out.println("Order Id = "+order.getOrderId());
                    order.getProductsBought().stream()
                            .forEach(product-> System.out.println(product.getProductName()+" "+product.getProductPrice()+" "+product.getAddedQuantity()));
                } );
    }

    public void viewProducts(){
        SuperMarketSystem.viewProducts();
    }



}
