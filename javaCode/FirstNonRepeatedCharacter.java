package javaCode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student{
    int age;
    String name;

    Student(int age, String name){
        this.age = age;
        this.name = name;
    }


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
public class FirstNonRepeatedCharacter {

    public Character returnNonRepeatedCharacter(List<Student> studentList){
        Map<Character, Integer> characterCount = new LinkedHashMap<>();
        studentList.stream().max(Comparator.comparingInt(Student::getAge)).get().getName().toUpperCase().chars()
                .mapToObj(c -> (char) c).peek(System.out::println).forEachOrdered(val -> characterCount.put(val, characterCount.getOrDefault(val, 0)+1));
        return characterCount.entrySet().stream().filter(val -> val.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse('\u0000');
    }

    public static void main(String[] args){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(10,"aabcdbc"));
        studentList.add(new Student(15, "Gagan"));

        FirstNonRepeatedCharacter firstNonRepeatedCharacter = new FirstNonRepeatedCharacter();
        Character val = firstNonRepeatedCharacter.returnNonRepeatedCharacter(studentList);
        System.out.println(val);
    }

}
