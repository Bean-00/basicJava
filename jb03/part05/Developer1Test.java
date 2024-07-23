package jb03.part05;

public class Developer1Test {
    public static void main(String[] args) {
        Developer1 developer1 = new Developer1();

        System.out.println("이름은: " + developer1.name);
        System.out.println("직업은: " + developer1.job);
        System.out.println("평균 수입은" + developer1.avgIncome);
        System.out.println("PJT 경력은: " + developer1.projectCarrer);

        System.out.println("=========================");

        developer1.particiapateProject();
        System.out.println("평균 수입은: " + developer1.avgIncome);
        System.out.println("project 참여 경력은: " + developer1.projectCarrer);

        System.out.println("=========================");

        developer1.instruct();
        System.out.println("평균수입은: " + developer1.avgIncome);

        System.out.println("=========================");

        String projectName = "한미은행";
        System.out.println("평균수입은: " + developer1.avgIncome);
        System.out.println(("Project 참여 경력은: " + developer1.projectCarrer));

        System.out.println("=========================");

        int lectureCount = 2;
        developer1.instruct(lectureCount);
        // hong1.instruct(2);
        System.out.println("평균 수입은: " + developer1.avgIncome);
    }
}