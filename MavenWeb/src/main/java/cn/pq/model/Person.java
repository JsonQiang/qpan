package cn.pq.model;

import javax.validation.constraints.Size;

public class Person {


    private int age;

    @Size(max=15,min=5,message="长度不合法")
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
