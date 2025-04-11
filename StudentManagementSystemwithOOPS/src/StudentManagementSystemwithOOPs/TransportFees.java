package StudentManagementSystemwithOOPs;

public class TransportFees implements Payable{

    private final double baseFee;
    private final double siblingDiscount;
    private final int paymentMonths;
    private double finalTransportFees;

    public TransportFees(double baseFee, double siblingDiscount, int paymentMonths) {
        this.baseFee = baseFee;
        this.siblingDiscount = siblingDiscount;
        this.paymentMonths = paymentMonths;
    }

    @Override
    public double calculatePayment() {
        finalTransportFees = (baseFee * paymentMonths) - siblingDiscount;
        return finalTransportFees;
    }

    @Override
    public void generateReciept() {
        System.out.println("......Transport Fees Reciept generating......");
        System.out.println("Base Fee: "+baseFee);
        System.out.println("Payment for Months: "+paymentMonths);
        System.out.println("Sibling Discount: "+siblingDiscount);
        System.out.println("Total Transport Fees to be paid is: "+ finalTransportFees);
        System.out.println("......GOOD DAY......");
    }

    @Override
    public double getDiscount() {
        return siblingDiscount;
    }
}
