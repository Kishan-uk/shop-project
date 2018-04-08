import java.util.ArrayList;

public class Customer {

    private String CustomerName;
    private ArrayList<PaymentType> paymentList;
    private ArrayList<Product> purchasedProducts;
    private PaymentType payment;


    public Customer(String name, PaymentType payment){

        this.CustomerName = name;

        paymentList = new ArrayList<PaymentType>();
        paymentList.add(new PaymentType("CreditCard", 400.00, true)) ;
        paymentList.add(new PaymentType("DebitCard", 200.00, false));
        paymentList.add(new PaymentType("Cash", 50.00, false));

        purchasedProducts = new ArrayList<Product>();

        this.payment = payment;
    }

    public String getCustomerName() {
        return this.CustomerName;
    }

    public int getTotalNumberOfPaymentTypes() {
        return paymentList.size();
    }

    public void selectPaymentType(String paymentMethod) {
        for(PaymentType paymentType: paymentList  ){
            if(paymentType.getPaymentMethod() == paymentMethod){
                payment = paymentType;
            }
        }

    }

    public boolean getDefaultPayment() {
        return payment.getDefaultPayment();
    }

    public double getBalanceFromPaymentType() {
        return payment.getPaymentBalance();
    }

    public int getPurchaseProduct(Product newProduct) {
        purchasedProducts.add(newProduct);
        return purchasedProducts.size();
    }

    public void buyProduct(double price, int quantity) {
        double total = 0;
        total = payment.getPaymentBalance() - (price * quantity) ;
        payment.setPaymentBalance(total);
    }

    public double refundProduct(double price, int quantity) {
        double total = 0;
        total = payment.getPaymentBalance() + (price*quantity) ;
        payment.setPaymentBalance(total);
        return total;
    }

}