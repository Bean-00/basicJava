package AssignmentFolder.day0805;

public class SmartPhone extends CellPhone {
    private boolean isMonthlyFixedRate;
    private int monthlyFixedFee;

    public SmartPhone(String phoneNumber, int totalFee) {
        super(phoneNumber, totalFee);
    }

    public SmartPhone(String phoneNumber, int feePerCallTime,
                      boolean isMonthlyFixedRate, int monthlyFixedFee) {
        super(phoneNumber, feePerCallTime);
        this.isMonthlyFixedRate = isMonthlyFixedRate;
        this.monthlyFixedFee = monthlyFixedFee;
    }

    public void calculationTotalFee() {
        if (this.isMonthlyFixedRate) {
            setTotalFee(this.monthlyFixedFee);
            System.out.println("고객님은 " + this.monthlyFixedFee + " 정액 요금제입니다.");
        } else {
            super.calculationTotalFee();
        }
    }
}
