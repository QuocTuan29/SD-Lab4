package payment;

public class EWalletPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toan bang vi dien tu: " + formatAmount(amount));
        // Thuc te: kiem tra so du vi va xac nhan giao dich.
    }

    private String formatAmount(double amount) {
        return String.format("%,.0f VND", amount);
    }
}
