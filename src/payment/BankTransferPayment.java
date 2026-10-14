package payment;

public class BankTransferPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toan bang chuyen khoan ngan hang: " + formatAmount(amount));
        // Thuc te: tao thong tin chuyen khoan va doi soat giao dich.
    }

    private String formatAmount(double amount) {
        return String.format("%,.0f VND", amount);
    }
}
