package org.example;

public class Main {
    public static void main(String[] args) {

        try {
            MyFrame myFrame = new MyFrame();
            myFrame.setVisible(true);

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

    }


}

