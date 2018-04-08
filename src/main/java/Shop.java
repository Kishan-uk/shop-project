import java.util.ArrayList;

public class Shop {

    private ArrayList<Product> products;
    private ArrayList<Product> purchasedProducts;
    private double sales;
    private double refunds;
    private int orderItemQuantity;



    public Shop(double sales, double refunds) {

        this.products = new ArrayList<Product>();
        this.sales = sales;
        this.refunds = refunds;
        this.purchasedProducts = new ArrayList<>();
        this.orderItemQuantity = orderItemQuantity;
    }

    public double getShopSales() {
        return sales;
    }

    public void setShopSales(double shopSales) {
        this.sales = shopSales;
    }

    public double getShopRefunds() {
        return refunds;
    }

    public void setShopRefunds(double shopRefunds) {
        this.refunds = shopRefunds;
    }

    public int getNumberOfProducts () {
        return products.size();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getOrderItemQuantity() {
        return orderItemQuantity;
    }


    public void makeSaleToCustomer(Product product, Customer customer, int orderItemQuantity) {

        if (products.contains(product)) {
            if (product.getQuantity() > 0) {
                customer.buyProduct(product.getPrice(),orderItemQuantity);
                purchasedProducts.add(product);
                sales = sales + (product.getPrice() * orderItemQuantity);
                int newQuantity = product.getQuantity() - orderItemQuantity ;
                product.setQuantity(newQuantity);
            }

            if (product.getQuantity() == 0) {
                products.remove(product);
            }
        }
    }
    public void  giveRefundToCustomer(Product product, Customer customer, int orderItemQuantity) {

        if (purchasedProducts.contains(product)) {
            customer.refundProduct(product.getPrice(), orderItemQuantity);
            products.add(product);
            purchasedProducts.remove(product);
            refunds = refunds + (product.getPrice() * orderItemQuantity);
            int newQuantity = product.getQuantity() + orderItemQuantity;
            product.setQuantity(newQuantity);

        }
    }

    public double totalIncome() {
        return sales - refunds;

    }

}