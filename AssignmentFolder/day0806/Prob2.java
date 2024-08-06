//package AssignmentFolder.day0806;

public class Prob2 {
    String toEncoding(String decodedStr) {
        StringBuilder sb = new StringBuilder();
        char[] decodedArray = decodedStr.toCharArray();
        byte[] checkAscii = decodedStr.getBytes();
		
		if (decodedStr.length() == checkAscii.length)
		{
			return decodedStr;
		}

		for (int i = 0; i < decodedArray.length; i++) {
	
            byte[] temp = (Character.toString(decodedArray[i])).getBytes();
               if (temp.length > 1) {
                   sb.append((Integer.toHexString(temp[0]).toString()
                		   + Integer.toHexString(temp[1]).toString()).replace("ffffff", "%"));
               } else {
                   sb.append(decodedArray[i]);
               }
         }
		return sb.toString();
            
    }

    public static void main(String[] args) {
        Prob2 p = new Prob2();
        
        System.out.println("입력: KOREA");
        System.out.println("출력: " + p.toEncoding("KOREA"));
        
        System.out.println("입력: 홍길동");
        System.out.println("출력: " + p.toEncoding("홍길동"));
        
        System.out.println("입력: 홍 길 동");
        System.out.println("출력: " + p.toEncoding("홍 길 동"));
        
        System.out.println("입력: Hong 길 동");
        System.out.println("출력: " + p.toEncoding("Hong 길 동"));
        
        System.out.println("입력: 0319");
        System.out.println("출력: " + p.toEncoding("0319"));
        
        



    }
}