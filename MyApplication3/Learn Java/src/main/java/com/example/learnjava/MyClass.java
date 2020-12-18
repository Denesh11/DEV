package com.example.learnjava;
public class MyClass {
    public static void main(String[] args) {
        Microphone microphone = new Microphone("Blue yeti","Blue",122333);
        microphone.setColor("brown");
        microphone.setName("blue yt");
        microphone.setModel(123);


        System.out.println("New Mic: "+microphone.getModel());


        microphone.turnOn();
        microphone.setVolume();
        microphone.turnOff();


        System.out.println(microphone.showDescription());

        Microphone newMic = new Microphone("NewMic" ,"Green",123);
        Microphone otherMic = new Microphone();
        otherMic.setColor("Other Mic");

        System.out.println(otherMic.getColor());

        Microphone grandMic = new Microphone("Grand","yellow");

    }
    }
