package AssignmentFolder.day0807;

public class limitExcessException extends Exception {
    final String message = "잔고부족 출금불가 합니다.";
//    limitExcessException(){
//        System.out.println(this.message);
//    }

    public String getMessage(){
        return this.message;
    }
}
