package jb03.part05;

public class Developer1 {
    String name = "홍길동";
    String job = "개발자";
    int avgIncome = 100;
    int projectCarrer;

    public void particiapateProject() {
        System.out.println("프로그램 개발로 수입 증가, 경력 쌓음");
        avgIncome++;
        projectCarrer++;
    }

    public void particiapateProject(String project) {
        System.out.println(project + "==> project 참여로 수입증가, 경력쌓음");
        avgIncome++;
        projectCarrer++;
    }

    public void instruct() {
        System.out.println("강의를 통한 수입 증가");
        avgIncome++;
    }

    public void instruct(int lectureCount) {
        System.out.println(lectureCount + "개 강의를 통한 수입 증가");
        avgIncome += lectureCount;
    }

}