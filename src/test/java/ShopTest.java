import static org.junit.Assert.assertEquals;
import org.junit.*;

public class ShopTest {
    Customer customer;
    Product product;
    Product product2;
    Product product3;
    Shop shop;
    PaymentType paymentType;

    @Before
    public void before() {
        shop = new Shop(100.00, 0);
        paymentType = new PaymentType("CreditCard", 200.00, true);
        customer = new Customer("James Bond", paymentType);
        product = new Product("CodeClan IPA", 1.99, 4);
        product2 = new Product("CodeClan Sour", 2.99, 3);
        product3 = new Product("CodeClan Stout", 3.99, 5);
        shop.addProduct(product);
        shop.addProduct(product2);
        shop.addProduct(product3);

    }


    @Test
    public void canGetTotalSales() {
        assertEquals(100, shop.getShopSales(), 0.01);
    }

    @Test
    public void canGetNumberOfProductForSale() {
        int product =shop.getNumberOfProducts();
        assertEquals(3, product);
    }

    @Test
    public void makeSaleToCustomerTest() {
        shop.makeSaleToCustomer(product, customer, product.getQuantity());
        assertEquals(4, product.getQuantity());
        assertEquals(107.96, shop.getShopSales(), 0.01);
        assertEquals(192.04, customer.getBalanceFromPaymentType(), 0.01);

    }

    @Test
    public void giveRefundToCustomerTest() {
        shop.makeSaleToCustomer(product, customer, product.getQuantity());
        assertEquals(192.04, customer.getBalanceFromPaymentType(), 0.01);
        assertEquals(4, product.getQuantity());
        shop.giveRefundToCustomer(product, customer, product.getQuantity());
        assertEquals(7.96, shop.getShopRefunds(), 0.01);
        assertEquals(200, customer.getBalanceFromPaymentType(), 0.01);

    }

    @Test
    public void reportTotalIncomeTest(){
        shop.makeSaleToCustomer(product, customer, product.getQuantity());
        shop.makeSaleToCustomer(product2, customer, product2.getQuantity());
        shop.giveRefundToCustomer(product, customer, product.getQuantity());
        assertEquals(108.97, shop.totalIncome(), 0.01);
    }

}