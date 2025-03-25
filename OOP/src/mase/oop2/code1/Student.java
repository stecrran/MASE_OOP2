// Name: Stephen Curran
package mase.oop2.code1;

// The default sort is by 'id'
public class Student implements Comparable<Student> {
    private String name, id;
    private Integer age;
    private Double height;

    public Student(String name, String id, Integer age, Double height) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
    



    // DO NOT AMEND THIS toString()
    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", id=" + id + ", age=" + age + ", height=" + height + '}';
    }


    @Override
    public int compareTo(Student other) {
        return this.id.compareTo(other.id);
    }

}

