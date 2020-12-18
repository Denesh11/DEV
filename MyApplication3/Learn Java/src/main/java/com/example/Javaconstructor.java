package com.example;

public class Javaconstructor {
    public static void main(String[] args) {
        person person =new person("Bruce Wayne",22);
        System.out.println(person.name);

        hero batman = new hero("Bat man",43,545);
        System.out.println(batman.name);
    }
}
