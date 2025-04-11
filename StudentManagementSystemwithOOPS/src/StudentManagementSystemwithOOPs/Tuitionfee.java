package StudentManagementSystemwithOOPs;

public class Tuitionfee implements Payable{

    private final double baseFee;
    private final double scholarshipDeduction;
    private final double earlyPaymentDiscount;
    private double finalTuitionFeesAmount;

    public Tuitionfee(double baseFee, double scholarshipDeduction, double earlyPaymentDiscount) {
        super();
        this.baseFee = baseFee;
        this.scholarshipDeduction = scholarshipDeduction;
        this.earlyPaymentDiscount = earlyPaymentDiscount;
    }

    @Override
    public double calculatePayment() {
        finalTuitionFeesAmount = baseFee - scholarshipDeduction - earlyPaymentDiscount;
        return finalTuitionFeesAmount;
    }

    @Override
    public void generateReciept() {
        System.out.println("......Tuition Fee Reciept generating......");
        System.out.println("Base Fees: "+baseFee);
        System.out.println("Scholarship Deduction: -"+scholarshipDeduction);
        System.out.println("Early Payment Discount: -"+earlyPaymentDiscount);
        System.out.println("Total Fees to be paid is: "+ finalTuitionFeesAmount);
        System.out.println("......GOOD DAY......");
    }

    @Override
    public double getDiscount() {
        return (scholarshipDeduction + earlyPaymentDiscount);
    }
}
