public class PaymentType {
    private String paymentMethod;
    private double paymentBalance;
    private boolean defaultPayment;
    
    public PaymentType(String paymentMethod, double paymentBalance, boolean defaultPayment){
        this.paymentMethod = paymentMethod;
        this.paymentBalance = paymentBalance;
        this.defaultPayment = defaultPayment;

    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentBalance() {
        return paymentBalance;
    }

    public void setPaymentBalance(double paymentBalance) {
        this.paymentBalance = paymentBalance;
    }


    public boolean getDefaultPayment(){
        return this.defaultPayment;
    }

    public void setDefaultPayment(){
        this.defaultPayment = true;
    }
}