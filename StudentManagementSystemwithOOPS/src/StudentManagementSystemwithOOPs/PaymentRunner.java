package StudentManagementSystemwithOOPs;

public class PaymentRunner {
    public static void main(String[] args) {
        Payable payable = new Tuitionfee(50000,10000,5000);
        payable.calculatePayment();
        payable.processPayment(PaymentMode.CASH);
        System.out.println("Discount is: "+payable.getDiscount());
        payable.generateReciept();

        Payable payable2 = new SportsActivityFee(5000,3000,2000,1000);
        payable2.calculatePayment();
        payable.processPayment(PaymentMode.CARD);
        System.out.println("Discount is: "+payable2.getDiscount());
        payable2.generateReciept();

        Payable payable3 = new TransportFees(1000,500,3);
        payable3.calculatePayment();
        payable.processPayment(PaymentMode.UPI);
        System.out.println("Discount is: "+payable3.getDiscount());
        payable3.generateReciept();

        Payable payable4 = new LibraryFee(500,200,100);
        payable4.calculatePayment();
        payable4.processPayment(PaymentMode.BITCOIN);
        System.out.println("Discount is: "+payable4.getDiscount());
        payable4.generateReciept();

        System.out.println(PaymentMode.BITCOIN);
        System.out.println(PaymentMode.BITCOIN.getDescription());

        int index = PaymentMode.CARD.ordinal();
        System.out.println(index);

        PaymentMode p = PaymentMode.valueOf("UPI");
        System.out.println(p);

        PaymentMode modes[] = PaymentMode.values();
        for(PaymentMode mode:modes){
            System.out.println(mode);
        }
    }
}
