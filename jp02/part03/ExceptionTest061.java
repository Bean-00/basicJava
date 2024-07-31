package jp02.part03;

/*
 * FileName : ExcpetionTest06.java 
 */
public class ExceptionTest061 {

	///Field
	private int sum;
	private int avg;
	
	///Constructor	
	public ExceptionTest061(){
	}

	///Method
	public void sum(String[] args){
		for(int i = 0 ; i<args.length ; i++){
			sum += Integer.parseInt(args[i]);
		}
		System.out.println("�� : "+sum);
	}
	public void avg(int z){
		avg = sum / z;
		System.out.println("��� : "+avg);
	}

	///main method
	public static void main(String[] args){
		
		//���ڰ� ���� �Ǵ� ::  data ������ validate check
		if(args.length == 0){
			System.out.println("usage : java num1 num2 num3....");
			System.exit(0);
		}

		//Exception Ȱ�� �������� �Ǵ� :: validate check
		try{
		  for(int i = 0 ; i<args.length ; i++){
			Integer.parseInt(args[i]);
		  }
		}catch(NumberFormatException nfe){
		   System.out.println("usage : ���ڰ��� �����̿��� �մϴ�.");
		   System.exit(0);
		}

		ExceptionTest061 et = new ExceptionTest061();
		et.sum(args);
		et.avg(args.length);
		
		System.out.println("main Method End....");
		
	}//end of main
	
}//end of class