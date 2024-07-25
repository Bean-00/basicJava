package jb04.part07.outer;

public class Other {
    jb04.part07.Father unknown = new jb04.part07.Father();

    public Other() {
        System.out.println(this.unknown.name);
//        System.out.println(f.bank);
//        System.out.println(f.branch);
//        System.out.println(f.password);

        System.out.println(this.unknown.getBranch());
        System.out.println(unknown.getPassword(0));
    }
}
