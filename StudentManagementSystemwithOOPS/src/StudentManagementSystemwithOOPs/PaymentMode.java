package StudentManagementSystemwithOOPs;

public enum PaymentMode {
    CASH("payment via cash"),
    CARD("payment via credit card"),
    UPI("payment via google pay"),BITCOIN("payment via bitcoin");

    private String description;

    private PaymentMode(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

}
