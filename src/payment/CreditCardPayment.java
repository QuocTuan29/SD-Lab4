package payment;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toan bang the tin dung: " + formatAmount(amount));
        // Thuc te: kiem tra thong tin the va goi cong thanh toan.
    }

    private String formatAmount(double amount) {
        return String.format("%,.0f VND", amount);
    }
}
