package payment;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toan bang PayPal: " + formatAmount(amount));
        // Thuc te: xac thuc tai khoan PayPal va tao giao dich.
    }

    private String formatAmount(double amount) {
        return String.format("%,.0f VND", amount);
    }
}
