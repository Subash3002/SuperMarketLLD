public class Main {
    public static void main(String[] args) {
        Admin admin=Admin.getInstance();
        admin.addProduct("Apple",50,10,Category.FRUIT);
        admin.addProduct("Milk",100,5,Category.GROCERY);

        admin.viewExistingProducts();

        admin.updateProductPrice("Apple",65);
        admin.updateProductQuantity("Milk",20);

        admin.viewExistingProducts();

        admin.updateDiscount(15);

        User user=new User("Subash");
        user.viewProducts();

        user.buyProduct("Apple",50);
        user.buyProduct("Milk",2);

        user.viewCart();

        user.placeOrder();

        user.viewOrders();

        user.viewProducts();

        user.viewCart();


    }
}