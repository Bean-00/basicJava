package AssignmentFolder.day0802;

public class CellPhone {
    private String phoneNumber;
    private int totalCallTime;
    private int totalFee;
    private int feePerCallTime;

    public CellPhone(String phoneNumber, int feePerCallTime) {
        this.phoneNumber = phoneNumber;
        this.feePerCallTime = feePerCallTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getTotalFee() {
        return this.totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getFeePerCallTime() {
        return feePerCallTime;
    }

    public int getTotalCallTime() {
        return totalCallTime;
    }

    public void call(String phoneNumber, int callTime) {
        this.callMethod(callTime);
        System.out.println(phoneNumber + " 번호로 " + callTime + " 통화함.");
    }

    public void callMethod(int callTime) {
        this.totalCallTime += callTime;
    }

    public void calculationTotalFee() {
        this.totalFee = this.totalCallTime * this.feePerCallTime;
    }
}
