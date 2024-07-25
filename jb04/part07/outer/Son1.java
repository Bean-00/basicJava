package jb04.part07.outer;

public class Son extends jb04.part07.Father {
    public Son() {
        System.out.println(this.name);
        System.out.println(bank);
        System.out.println(branch);
//        System.out.println(password);

        System.out.println(this.getBranch());
        System.out.println("은행 비밀번호: " + this.getPassword(0));
    }
}