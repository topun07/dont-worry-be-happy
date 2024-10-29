package com.techelevator;

public class Television {
    // instance
    private boolean isOn;
    private int currentChannel;
    private int currentVolume;

    //constructor
    public Television(){
        this.isOn = false;
        this.currentChannel = 3;
        this.currentVolume = 2;
    }

    //getter


    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    //methods
    public void turnOff(){
        isOn = false;
    }
    public void turnOn(){
        isOn = true;
        currentChannel = 3;
        currentVolume = 2;
    }
    public void changeChannel(int newChannel) {
        if (isOn && newChannel >= 3 && newChannel <= 18) {
            currentChannel = newChannel;
        }
    }
public void channelUp(){
    if ((isOn)) {
        currentChannel++;
        if(currentChannel > 18){
            currentChannel = 3;
        }
    }
}
public void channelDown(){
        if (isOn){
            currentChannel--;
            if (currentChannel < 3){
                currentChannel = 18;
            }
        }
}
public void raiseVolume(){
        if (isOn && currentVolume < 10){
            currentVolume++;
            }
        }
        public void lowerVolume(){
        if(isOn && currentVolume > 0){
            currentVolume--;
        }
}
//testing
    public static void main(String[] args){
        Television tv = new Television();

        // turning on the tv
        tv.turnOn();
        System.out.println("is tv on? " + tv.isOn());
        System.out.println("current channel " + tv.getCurrentChannel());
        System.out.println("current volume " + tv.getCurrentVolume());

        //changing channel
        tv.changeChannel(8);
        System.out.println("current channel "+ tv.getCurrentChannel());

        //channel up
        tv.channelUp();
        System.out.println("current channel " + tv.getCurrentChannel());

        //channel down
        tv.channelDown();
        System.out.println("current channel " + tv.getCurrentChannel());

        //raise volume
        tv.raiseVolume();
        System.out.println("current volume " + tv.getCurrentVolume());

        //lower volume
        tv.lowerVolume();
        System.out.println("current volume " + tv.getCurrentVolume());

        // turning off the tv
        tv.turnOff();
        System.out.println("is the television on? " + tv.isOn());
    }
}