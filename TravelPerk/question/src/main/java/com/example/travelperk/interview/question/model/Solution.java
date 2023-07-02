package com.example.travelperk.interview.question.model;


import java.util.List;
import java.util.Map;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {

    public Solution(){};

    class Photo {
    private String photoName;
    private String location;
    private String time;
    private String modifiedName;
    private int index;
    
    public Photo(){}
    

    public Photo(String photoName, String location, String time, String modifiedName, int index) {
        this.photoName = photoName;
        this.location = location;
        this.time = time;
        this.modifiedName = modifiedName;
        this.index = index;
    }


    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getModifiedName() {
        return modifiedName;
    }

    public void setModifiedName(String modifiedName) {
        this.modifiedName = modifiedName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    }


    public String solution(String S) {
        String [] photos = S.split("\n");
        Map<String, List<Photo>> photoMap = preparePhotoMap(photos);
        sortListByTime(photoMap);
        String[] finalNames = getFinalNames(photoMap, photos.length);
        StringBuilder result = getResult(finalNames);
        return result.toString();
    }


    private StringBuilder getResult(String[] finalNames) {
        StringBuilder result = new StringBuilder();
        for(String name:finalNames) {
            result.append(name);
            result.append("\n");
        }
        return result;
    }


    private String[] getFinalNames(Map<String, List<Photo>> photoMap, int length) {
        String[] finalNames = new String[length];
        for(String location : photoMap.keySet()) {
            List<Photo> photos = photoMap.get(location);
            for(int i=0;i<photos.size();i++) {
                String photoNumber = preparePhotoNumber(i,photos.size());
                String photoExtension = photos.get(i).getPhotoName().split("\\.")[1];
                String modifiedName = location+photoNumber+"."+photoExtension;
                finalNames[photos.get(i).getIndex()] = modifiedName; 
            }
        }
        
        return finalNames;
    }


    private String preparePhotoNumber(int i, int size) {
        int leadingZeros = Integer.toString(size).length()-Integer.toString(i+1).length();
        StringBuilder number = new StringBuilder();
        for(int j =1;j<=leadingZeros;j++) {
            number.append(0);
        }
        int photoNumber = i+1;
        number.append(photoNumber);
        return number.toString();
    }


    private void sortListByTime(Map<String, List<Photo>> photoMap) {
        for(String location : photoMap.keySet()) {
            List<Photo> photos = photoMap.get(location);

            /*Collections.sort(photos, new Comparator<Photo>() {
                @Override
                public int compare(Photo o1, Photo o2) {
                    return o1.getTime().compareTo(o2.getTime());
                }
            });*/
            Collections.sort(photos, Comparator.comparing(Photo::getTime));

        }
    }


    private Map<String, List<Photo>> preparePhotoMap(String[] photos) {
        Map<String,List<Photo>> photoMap= new HashMap<>();
        List<Photo> photoList = null;
        for(int i = 0; i<photos.length;i++) {
            String photoString = photos[i];
            String [] photoInfo = photoString.split(",");
            Photo photo = createPhoto(photoInfo,i);
            if(photoMap.containsKey(photo.getLocation())) {
                photoList = photoMap.get(photo.getLocation());
            } else {
                photoList = new ArrayList<>();
            }

            photoList.add(photo);
            photoMap.put(photo.getLocation(), photoList);
        }
        return photoMap;
    }


    private Photo createPhoto(String[] photoInfo, int index) {
        return new Photo(photoInfo[0], photoInfo[1], photoInfo[2], "", index);
    }
}