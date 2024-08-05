package AssignmentFolder.day0805;

public class CellPhoneMain {
    public static void main(String[] args) throws IllegalArgumentException {

        CellPhone myphone = new CellPhone("SCH-600");

        myphone.charge(20);
        myphone.printBattery();

        myphone.call(300);
        myphone.printBattery();

        myphone.charge(50);
        myphone.printBattery();

        myphone.call(40);
        myphone.printBattery();

        try {
            myphone.call(-20);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        CellPhone yourPhone = new CellPhone("SCH-600");

        if (myphone.equals(yourPhone)) {
            System.out.println("동일 모델입니다.");
        } else {
            System.out.println("다른 모델입니다.");
        }

    }
}
