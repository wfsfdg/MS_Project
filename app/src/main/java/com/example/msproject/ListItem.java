package com.example.msproject;

public class ListItem {
    private byte[] imgdata;
    private String textdata1;

    public String gettext1()
    {
        return textdata1;
    }
    public void settext1(String text)
    {
        this.textdata1=text;
    }

    public byte[] getimg()
    {
        return imgdata;
    }
    public void setimg(byte[] img)
    {
        this.imgdata=img;
    }
    ListItem(byte[] img,String text1)
    {
        this.imgdata=img;
        this.textdata1=text1;
    }


}

