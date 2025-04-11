package StudentManagementSystemwithOOPs;

public class SportsActivityFee implements Payable{

    private final double equipmentCharges;
    private final double tournamentFees;
    private final double teamUniformCosts;
    private final double discountForStatePlayers;
    private double finalSportsActivityFeesAmount;

    public SportsActivityFee(double equipmentCharges, double tournamentFees, double teamUniformCosts, double discountForStatePlayers) {
        super();
        this.equipmentCharges = equipmentCharges;
        this.tournamentFees = tournamentFees;
        this.teamUniformCosts = teamUniformCosts;
        this.discountForStatePlayers = discountForStatePlayers;
    }

    @Override
    public double calculatePayment() {
        finalSportsActivityFeesAmount = equipmentCharges + tournamentFees + teamUniformCosts - discountForStatePlayers;
        return finalSportsActivityFeesAmount;
    }

    @Override
    public void generateReciept() {
        System.out.println("......Sports Fees Reciept generating......");
        System.out.println("Equipment Charges: "+equipmentCharges);
        System.out.println("Tournament Fees: "+tournamentFees);
        System.out.println("Team Uniform Costs: "+teamUniformCosts);
        System.out.println("Discount for State Players: -"+discountForStatePlayers);
        System.out.println("Total Sports Fees to be paid is: "+ finalSportsActivityFeesAmount);
        System.out.println("......GOOD DAY......");
    }

    @Override
    public double getDiscount() {
        return discountForStatePlayers;
    }
}
