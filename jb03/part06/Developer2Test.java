package jb03.part06;

public class Developer2Test {
    public static void main(String[] args) {
        Developer2 developer = new Developer2();

        System.out.println("이름은: " + developer.name);
        System.out.println("직업은: " + developer.job);
        System.out.println("평균 수입은" + developer.avgIncome);
        System.out.println("PJT 경력은: " + developer.projectCarrer);

        System.out.println("=========================");

        String name = developer.getName();
        String job = developer.getJob();
        int avgIncome = developer.getAvgIncome();
        System.out.println("이름은 " + name);
        System.out.println("직업은 " + job);
        System.out.println("평균 수입은: " + avgIncome);

        System.out.println("평균 경력은: " + developer.getProjectCarrer());

    }


}