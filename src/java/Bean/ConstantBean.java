/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Phong Vu
 */
public class ConstantBean {
    private int constantID;
    private String constantName;
    private String value;
    private String unit;
    private String description;
    private String sign;
    private String readingConvention;

    public ConstantBean() {
    }

    public ConstantBean(int constantID, String constantName, String value, String unit, String description, String sign, String readingConvention) {
        this.constantID = constantID;
        this.constantName = constantName;
        this.value = value;
        this.unit = unit;
        this.description = description;
        this.sign = sign;
        this.readingConvention = readingConvention;
    }

    public int getConstantID() {
        return constantID;
    }

    public void setConstantID(int constantID) {
        this.constantID = constantID;
    }

    public String getConstantName() {
        return constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getReadingConvention() {
        return readingConvention;
    }

    public void setReadingConvention(String readingConvention) {
        this.readingConvention = readingConvention;
    }

    @Override
    public String toString() {
        return "ConstantBean{" + "constantID=" + constantID + ", constantName=" + constantName + ", value=" + value + ", unit=" + unit + ", description=" + description + ", sign=" + sign + ", readingConvention=" + readingConvention + '}';
    }
    
    
}
