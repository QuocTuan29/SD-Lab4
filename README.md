# PaymentSystem_Strategy_ISP

Java Project thuần dành cho Eclipse IDE 2024, tương thích Java 8 trở lên. Không cần Maven, Spring hay database.

## 1. Cấu trúc dự án

```text
PaymentSystem_Strategy_ISP/
├── src/
│   └── payment/
│       ├── PaymentStrategy.java
│       ├── CreditCardPayment.java
│       ├── PayPalPayment.java
│       ├── EWalletPayment.java
│       ├── BankTransferPayment.java
│       ├── PaymentService.java
│       └── PaymentClient.java
├── .project
├── .classpath
└── README.md
```

## 2. Cách import vào Eclipse 2024

1. Giải nén file ZIP vào thư mục bạn muốn lưu.
2. Mở Eclipse.
3. Chọn **File > Import... > General > Existing Projects into Workspace**.
4. Chọn **Select root directory**, trỏ tới thư mục `PaymentSystem_Strategy_ISP` vừa giải nén.
5. Chọn project và nhấn **Finish**.
6. Mở `src/payment/PaymentClient.java`.
7. Nhấn chuột phải vào file > **Run As > Java Application**.
8. Xem kết quả tại tab **Console**.

Nếu Eclipse yêu cầu chọn JRE, vào **Project > Properties > Java Build Path > Libraries** và chọn JRE/JDK đã cài (Java 8 trở lên).

## 3. Kết quả dự kiến

```text
=== DEMO HE THONG THANH TOAN ===
Thanh toan bang the tin dung: 1,500,000 VND
Thanh toan bang PayPal: 2,500,000 VND
Thanh toan bang vi dien tu: 500,000 VND
Thanh toan bang chuyen khoan ngan hang: 10,000,000 VND
=== KET THUC ===
```

## 4. Phân tích thiết kế cũ

Code ban đầu dùng `if-else` và chuỗi `method` trong `PaymentService` để quyết định phương thức thanh toán. Cách này có các hạn chế:

- **Vi phạm OCP:** thêm phương thức mới phải sửa `PaymentService`.
- **Khó bảo trì và kiểm thử:** logic của nhiều phương thức tập trung trong một hàm.
- **Dùng String để định danh:** có thể nhập sai chính tả và chỉ phát hiện lúc chạy.
- **Trách nhiệm bị tập trung:** `PaymentService` vừa lựa chọn vừa thực hiện logic cho nhiều loại thanh toán.
- **Khó tái sử dụng:** không thể tách riêng từng thuật toán thanh toán.

## 5. Strategy Pattern được áp dụng như thế nào?

- `PaymentStrategy`: Strategy interface, định nghĩa hành vi chung `pay(double amount)`.
- `CreditCardPayment`, `PayPalPayment`, `EWalletPayment`, `BankTransferPayment`: Concrete Strategies, mỗi class xử lý một phương thức thanh toán.
- `PaymentService`: Context, giữ một tham chiếu `PaymentStrategy` và ủy quyền việc thanh toán cho strategy hiện tại.
- `PaymentClient`: Client, chọn strategy phù hợp và gọi thanh toán.

Có thể thay đổi phương thức lúc chạy bằng `setPaymentStrategy(...)`. Khi thêm phương thức mới, chỉ cần tạo class mới `implements PaymentStrategy`, không cần thêm nhánh `if-else` vào `PaymentService`.

## 6. Áp dụng ISP

`PaymentStrategy` chỉ có đúng một hành vi mà mọi phương thức thanh toán đều cần: `pay(double amount)`. Interface không chứa các hàm riêng như `validateCreditCard()`, `loginPayPal()` hay `checkWalletBalance()` vì không phải mọi phương thức đều sử dụng chúng. Chi tiết riêng thuộc về class cụ thể.

## 7. Ghi chú

Đây là chương trình minh họa thiết kế hướng đối tượng. Các class hiện in thông báo ra Console; phần kết nối ngân hàng, PayPal, ví điện tử và xử lý giao dịch thật chưa được triển khai. Với hệ thống thực tế, nên dùng `BigDecimal` thay cho `double` khi biểu diễn tiền.
