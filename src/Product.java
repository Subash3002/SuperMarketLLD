public class Product {
    private String productName;
    private float productPrice;
    private int productQuantity;
    private Category productCategory;

    public Product(String productName, float productPrice, int productQuantity, Category productCategory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString(){
        return "Name: " + productName + ", Price: " + productPrice +", Quantity: " + productQuantity + ", Category: " + productCategory;
    }
}
