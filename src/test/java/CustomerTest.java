import org.junit.Before;
import org.junit.Test;


import static junit.framework.Assert.assertEquals;

public class CustomerTest {

    Customer customer;
    PaymentType paymentType;
    Product product;

    @Before
    public void before() {
        paymentType = new PaymentType("CreditCard", 200.00, true);
        customer = new Customer("James Bond", paymentType);
        product = new Product("CodeClan IPA", 1.99,4);
    }

    @Test
    public void getCustomerName() {
        assertEquals("James Bond", customer.getCustomerName());

    }

    @Test
    public void getTotalNumberOfPaymentTypes() {
        assertEquals(3, customer.getTotalNumberOfPaymentTypes());
    }

    @Test
    public void getPaymentType() {
        customer.selectPaymentType("CreditCard");
        assertEquals("CreditCard", paymentType.getPaymentMethod());
    }

    @Test
    public void defaultCardDefaultStateIsTrue(){
        customer.getDefaultPayment();
        boolean state = customer.getDefaultPayment();
        assertEquals(true, state);
    }

    @Test
    public void getBalanceFromPaymentType() {
        assertEquals(200.00, customer.getBalanceFromPaymentType());

    }

    @Test
    public void buyProduct() {
        customer.selectPaymentType ("CreditCard");
        customer.buyProduct (1.99, 3);
        double total = customer.getBalanceFromPaymentType();
        assertEquals(394.03,total,0.01) ;
    }

    @Test
    public void getTotalPurchasedItems(){
        assertEquals(1,customer.getPurchaseProduct(new Product("CodeClan IPA",1.99,4)));
    }

    @Test
    public void refundItemTest() {
        customer.selectPaymentType("Cash");
        assertEquals(53.98, customer.refundProduct(1.99, 2));

    }


}