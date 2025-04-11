package StudentManagementSystemwithOOPs;

public interface Payable {

    public abstract double calculatePayment();

    public default boolean processPayment(PaymentMode paymentMode){
        if(paymentMode == PaymentMode.CASH || paymentMode == PaymentMode.CARD || paymentMode == PaymentMode.UPI){
            System.out.println("Processing Payment............");
            System.out.println("Payment Successful");
            return true;
        }
        else {
            System.err.println("Something went wrong...........");
            return false;
        }
    }

    public abstract void generateReciept();

    public abstract double getDiscount();
}
