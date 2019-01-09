package com.example.lolaabudu.datamanipulation;

import java.util.Arrays;

class CodeRgbaHex {

    private int[] rgba;
    private String hex;

    public int[] getRgba(){
        return rgba;
    }

    public String getHex(){
        return hex;
    }

    public void setRgba(int[] rgba){
        this.rgba=rgba;
    }

    public void setHex(String hex){
        this.hex=hex;
    }

    //override toString method and make it return what you want; this allows the code: hex and rgba to show up in the Textview
    @Override
    public String toString() {
        return hex+" \n" + Arrays.toString(rgba);
    }
}
