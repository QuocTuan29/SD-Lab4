package payment;

/**
 * Context cua Strategy Pattern.
 * PaymentService khong can biet chi tiet tung cach thanh toan.
 */
public class PaymentService {
    private PaymentStrategy paymentStrategy;

    public PaymentService() {
    }

    public PaymentService(PaymentStrategy paymentStrategy) {
        setPaymentStrategy(paymentStrategy);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        if (paymentStrategy == null) {
            throw new IllegalArgumentException("Phuong thuc thanh toan khong duoc null");
        }
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Chua chon phuong thuc thanh toan");
        }
        if (amount <= 0 || Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("So tien thanh toan phai lon hon 0");
        }
        paymentStrategy.pay(amount);
    }
}
