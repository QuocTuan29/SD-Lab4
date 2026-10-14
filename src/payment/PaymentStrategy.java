package payment;

/**
 * Strategy interface: interface nho, chi khai bao hanh vi thanh toan.
 * Thiet ke theo Interface Segregation Principle (ISP).
 */
public interface PaymentStrategy {
    void pay(double amount);
}
