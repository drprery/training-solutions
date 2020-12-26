package week09d03;

import java.util.Random;

public class Person {
    private String name;
    private int age;
    private Present present;
    private Present[] presents={Present.TOY,Present.ELECTRONIC,Present.HOUSEKEEPING,Present.DECORATION};

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPresent(){
        Random random=new Random();
        int presentNumber=0;

        while(true){
            presentNumber= random.nextInt(4);
            if(age>14 && presentNumber==0){
                continue;
            }
            break;
        }
        present=presents[presentNumber];
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }
}
