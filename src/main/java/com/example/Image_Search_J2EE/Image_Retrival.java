package com.example.Image_Search_J2EE;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Image_Retrival {
    public static void main(String[] args) {
        List imageUrlList = new ArrayList();
        File imageDir = new File("C:\\Users\\Vicky\\Documents\\Projects\\Image_Search_J2EE\\src\\main\\webapp\\images");
        for(File imageFile : imageDir.listFiles()){
            String imageFileName = imageFile.getName();

            // add this images name to the list we are building up
            imageUrlList.add("images/"+imageFileName);

        }
        System.out.println(imageUrlList);
    }

}
