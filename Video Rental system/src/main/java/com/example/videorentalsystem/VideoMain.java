package com.example.videorentalsystem;

import java.util.Scanner;

public class VideoMain {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        showmenu();
        VideoController videoController = new VideoController();
        VideoDTO videoDTO = new VideoDTO();

        videoController.Inventory(scan,videoDTO);

    }

    public static void showmenu(){

    }
}