package com.mycompany.springbasic1102.di;

public class Student {  //pojo
    private String name;
    private Integer age;
    private Teacher teacher;
    
    public void init(){
        System.out.println("init");
    }
    public void destroy(){
        System.out.println("destroy");
    }

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name 
                + ", age=" + age 
                + ", teacher=" + (teacher==null?"":teacher.getName()) + '}';
    }
}
