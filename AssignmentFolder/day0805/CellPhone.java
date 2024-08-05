package AssignmentFolder.day0805;

public class CellPhone {
    private String phoneNumber;
    private int totalCallTime;
    private int totalFee;
    private int feePerCallTime;
    private String model;
    private double battery;

    public CellPhone(String model) {
        this.model = model;
    }

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

    public void charge(int time) throws IllegalArgumentException {
            this.battery += time * 3;
            if (time < 0) {
                throw new IllegalArgumentException("충전 시간 입력 오류");
            }
            System.out.println("충전 시간 : " + time);
    }

    public void printBattery() {
        System.out.println("남은 배터리양 : " + this.battery);
    }

    public void call(int time) throws IllegalArgumentException {
        this.battery -= time * 0.5;
        System.out.println(this.battery);
        try {
            if (time < 0) {
                throw new IllegalArgumentException("통화시간 입력 오류");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("통화시간이 잘못 입력되었습니다.");
        }
        System.out.println("남은 배터리양 : " + this.battery);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CellPhone) {
            return true;
        } else {
            return false;
        }
    }
}
