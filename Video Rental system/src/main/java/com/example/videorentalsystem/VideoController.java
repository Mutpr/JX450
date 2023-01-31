package com.example.videorentalsystem;

import java.lang.reflect.Array;
import java.util.*;

public class VideoController {

    //DB 연결하고 상점 번호 확인해서 가지고 있는 비디오 확인하는 메소드
    public void Inventory(Scanner scan, VideoDTO videoDTO) {
        scan = new Scanner(System.in);
        videoDTO = new VideoDTO();
        ArrayList video = new ArrayList<>();

        int selectnumber = scan.nextInt();


        System.out.println(videoDTO.getVid_title(selectnumber));
        System.out.println(videoDTO.getVid_description(selectnumber));
        System.out.println(videoDTO.getVid_category(selectnumber));
        System.out.println(videoDTO.getLang(selectnumber));

        Iterator elements = video.iterator();
        String actor = videoDTO.getVid_actor(selectnumber);
        while (elements.hasNext()) {
            video.add(actor);
                System.out.println(video.get(i));

        }
    }

    //비디오 빌려준 날짜, 비디오 정보

    //비디오의 영화, 출연 배우 정보, 비디오 지원 언어, 카테고리

    //menu

}