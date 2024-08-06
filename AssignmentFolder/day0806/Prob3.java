package AssignmentFolder.day0806;

public class Prob3 {
    static String getInfomation(String url, int startIndex) {
        char[] urlArray = url.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = startIndex; urlArray[i] != '&'; i++) {
            result.append(urlArray[i]);
        }
        return result.toString();
    }

    static String getParameter(String url, String paramName) {
        StringBuilder resultsb = new StringBuilder();

        if (paramName.equals("prodName")) {
            return resultsb.append(getInfomation(url, url.lastIndexOf("prodName") + 9)).toString();
        } else if (paramName.equals("address")) {
            return resultsb.append(getInfomation(url, url.lastIndexOf("address") + 8)).toString();
        }

        return "그런 정보는 없습니다";
    }

    public static void main(String[] args) {
        String url1 = "http://localhost/order?prodld=PROD-001&prodName=갤럭시3&price=980000";

        String prodName = getParameter(url1, "prodName");
        System.out.println("제품 이름: " + prodName);

        String url2 = "http://localhost/registUser?userld=UWER-001&userName=홍길동&address=서울시 강남구&userAge=26";

        String userAddress = getParameter(url2, "address");
        System.out.println("회원 주소: " + userAddress);

    }
}