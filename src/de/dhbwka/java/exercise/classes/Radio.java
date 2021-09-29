package de.dhbwka.java.exercise.classes;

public class Radio {

    private boolean state; // True = on; false = off
    private int volume; // 0-10 in Percent
    private double frequency; // Frequency that is listened to
    private static int MAX_FREQUENCY = 110;
    private static int MIN_FREQUNCY = 85;

    public Radio() {
        frequency = 96.7;
        volume = 7;
        state = true;
    }

    public Radio(boolean state, int volume, double frequency) {
        this.frequency = frequency;
        this.volume = volume;
        this.state = state;
    }

    public void turnOff() {
        state = false;
    }

    public void turnOn() {
        state = true;
    }

    public void increaseVolume() {
        if (volume < 10) {
            volume++;
        }
    }

    public void increaseVolume(int volume) {
        if (this.volume + volume < 10) {
            this.volume += volume;
        }
    }

    public void decreaseVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void decreaseVolume(int volume) {
        if (this.volume + volume > 0) {
            this.volume -= volume;
        }
    }

    public void setFrequency(double frequency) {
        if (frequency > MIN_FREQUNCY && frequency < MAX_FREQUENCY) {
            this.frequency = frequency;
        } else {
            this.frequency = 99.9;
        }
    }

    public String getState() {
        if (state) {
            return "an";
        } else {
            return "aus";
        }
    }

    public String toString() {
        return "Radio ist: " + getState() + ", Freq: " + frequency + ", Vol: " + volume;
    }

    public static void main(String[] args) {
        Radio radio = new Radio(false, 7, 93.5);
        System.out.println(radio);
        radio.turnOn();
        System.out.println(radio);
        radio.increaseVolume();
        radio.increaseVolume();
        System.out.println(radio);
        radio.increaseVolume();
        radio.increaseVolume();
        System.out.println(radio);
        radio.decreaseVolume();
        System.out.println(radio);
        radio.setFrequency(97.8);
        System.out.println(radio);
        radio.setFrequency(112.7);
        System.out.println(radio);
        radio.turnOff();
        System.out.println(radio);

    }

}
