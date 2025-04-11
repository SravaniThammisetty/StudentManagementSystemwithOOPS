package StudentManagementSystemwithOOPs;

public class LibraryFee implements Payable{

    private final int basicSubscription;
    private final int additionalBookCharges;
    private final int lateReturnPenalties;
    private double finalLibraryFee;

    public LibraryFee(int basicSubscription, int additionalBookCharges, int lateReturnPenalties) {
        this.basicSubscription = basicSubscription;
        this.additionalBookCharges = additionalBookCharges;
        this.lateReturnPenalties = lateReturnPenalties;
    }

    @Override
    public double calculatePayment() {
        finalLibraryFee = basicSubscription + additionalBookCharges + lateReturnPenalties;
        return finalLibraryFee;
    }

    @Override
    public boolean processPayment(PaymentMode paymentMode) {
        if(paymentMode == PaymentMode.BITCOIN){
            System.out.println("Processing Payment............");
            System.out.println("Payment Successful");
            return true;
        }
        else {
            System.err.println("Something went wrong...........");
            return false;
        }
    }

    @Override
    public void generateReciept() {
        System.out.println("......Library Fees Reciept generating......");
        System.out.println("Basic Subscription: "+basicSubscription);
        System.out.println("Additional Book Charges: "+additionalBookCharges);
        System.out.println("Late Return Penalties: "+lateReturnPenalties);
        System.out.println("Total Transport Fees to be paid is: "+ finalLibraryFee);
        System.out.println("......GOOD DAY......");
    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
