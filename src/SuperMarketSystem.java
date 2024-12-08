import java.util.HashMap;

enum PurchaseResponse{
    PRODUCT_NOT_FOUND,
    INSUFFICIENT_STOCK,
    SUCCESS
}

public class SuperMarketSystem{
    private static SuperMarketSystem instance;

    private static HashMap<String,Product> productCatlog;

    public static HashMap<String, Product> getProductCatlog() {
        return productCatlog;
    }

    public static float currentDiscount=0;

    private SuperMarketSystem(){
        productCatlog=new HashMap<>();
    }

    public static SuperMarketSystem getInstance(){
        if(instance==null){
            instance=new SuperMarketSystem();
        }
        return instance;
    }

    public void addProduct(Product product){
        productCatlog.put(product.getProductName(),product);
        System.out.println("Product added: "+product);
    }

    public void deleteProduct(String productName){
        if(productCatlog.containsKey(productName)){
            productCatlog.remove(productName);
            System.out.println("Product deleted");
        }else{
            System.out.println("Product not found");
        }
    }

    public void modifyProduct(String productName,int productQuantity){
        Product product=productCatlog.get(productName);
        if(product!=null){
            product.setProductQuantity(productQuantity);
            System.out.println("Product Quantity Updated "+product);
        }
    }

    public void modifyProduct(String productName,float productPrice){
        Product product=productCatlog.get(productName);
        if(product!=null){
            product.setProductPrice(productPrice);
            System.out.println("Product Price Updated "+product);
        }
    }

    public static void viewProducts(){
        System.out.println("Product List");
        productCatlog.values().stream()
                .forEach(product -> System.out.println(product));
    }

    public static PurchaseResponse buyProduct(String productName,int quantity){
        Product product=productCatlog.get(productName);
        if(product==null)return PurchaseResponse.PRODUCT_NOT_FOUND;
        if(product.getProductQuantity()<quantity)return PurchaseResponse.INSUFFICIENT_STOCK;
        product.setProductQuantity(product.getProductQuantity()-quantity);
        return PurchaseResponse.SUCCESS;
    }

    public static float getCurrentDiscount() {
        return currentDiscount;
    }
    public void updateDiscount(float discount){
        currentDiscount=discount;
    }


}
