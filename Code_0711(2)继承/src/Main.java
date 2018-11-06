import com.lanou3g.homework.Child;
import com.lanou3g.homework.Family;
import com.lanou3g.homework.Man;
import com.lanou3g.homework.Woman;

public class Main {
    public static void main(String[] args) {


        Child child = new Child();
        Man man = new Man();
        Woman woman = new Woman();
        Family family = new Family(man, woman, child);

        woman.setName("大红");
        man.setName("大明");
        child.setName("小明");

        child.dohomework();
        woman.cook();
        man.work();
        family.play();

//        man.setWife(woman);
//        man.setSon(child);
//
//        child.setMother(woman);
//        child.setFather(man);


//        woman.setHusband(man);
//        woman.setSon(child);


    }
}
