public class Admin {
    private final SuperMarketSystem superMarketSystem;

    private static Admin instance;

    private Admin(){
        superMarketSystem=SuperMarketSystem.getInstance();
    }

    public static Admin getInstance(){
        if(instance==null){
            instance=new Admin();
        }
        return instance;
    }

    public void addProduct(String productName,float productPrice,int productQuantity,Category category){
        Product product=new Product(productName,productPrice,productQuantity,category);
        superMarketSystem.addProduct(product);
    }

    public void updateProductQuantity(String productName,int productQuantity){
        superMarketSystem.modifyProduct(productName,productQuantity);
    }

    public void updateProductPrice(String productName,float productPrice){
        superMarketSystem.modifyProduct(productName,productPrice);
    }

    public void viewExistingProducts(){
        SuperMarketSystem.viewProducts();
    }

    public void updateDiscount(float discount){
        superMarketSystem.updateDiscount(discount);
    }

}
