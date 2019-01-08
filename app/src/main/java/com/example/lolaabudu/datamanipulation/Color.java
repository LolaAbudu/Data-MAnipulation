package com.example.lolaabudu.datamanipulation;

public class Color {

    private String color;
    private String category;
    private String type;
    private CodeRgbaHex code;

    public Color(){}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CodeRgbaHex getCode() {
        return code;
    }

    public void setCode(CodeRgbaHex code) {
        this.code = code;
    }
}
