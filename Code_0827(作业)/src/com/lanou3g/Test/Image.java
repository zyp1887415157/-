package com.lanou3g.Test;

public class Image {
    private String imageName;
    private String imageType;
    private String imagePath;


    @Override
    public String toString() {
        return "Image{" +
                "imageName='" + imageName + '\'' +
                ", imageType='" + imageType + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
