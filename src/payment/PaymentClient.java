package payment;

/**
 * Client minh hoa cach su dung va thay doi strategy luc runtime.
 */
public class PaymentClient {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        System.out.println("=== DEMO HE THONG THANH TOAN ===");

        paymentService.setPaymentStrategy(new CreditCardPayment());
        paymentService.pay(1_500_000);

        paymentService.setPaymentStrategy(new PayPalPayment());
        paymentService.pay(2_500_000);

        paymentService.setPaymentStrategy(new EWalletPayment());
        paymentService.pay(500_000);

        paymentService.setPaymentStrategy(new BankTransferPayment());
        paymentService.pay(10_000_000);

        System.out.println("=== KET THUC ===");
    }
}
