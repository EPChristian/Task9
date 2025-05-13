package com.dmdev.streams;

import java.io.*;

public class PersonRunner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person original = new Person("Вася", 36, new Address("Новороссийск"));
        Person copy = Utils.deepCopy(original);

        System.out.println("До изменений:");
        System.out.println("Original: " + original);
        System.out.println("Copy:     " + copy);

        // Меняем адрес только в копии
        copy.getAddress().setCity("Москва");

        System.out.println("После изменений в копии:");
        System.out.println("Original: " + original);
        System.out.println("Copy:     " + copy);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))){
            oos.writeObject(original);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))){
        Person p = (Person) ois.readObject();
        System.out.println(p);
        }
    }
}