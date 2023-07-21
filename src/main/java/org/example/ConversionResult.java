package org.example;

public class ConversionResult {
    private String oldFileName;
    private String newFileName;
    private String duration;
    private String oldSize;
    private String newSize;

    public ConversionResult(String oldFileName, String newFileName, String duration, String oldSize, String newSize) {
        this.oldFileName = oldFileName;
        this.newFileName = newFileName;
        this.duration = duration;
        this.oldSize = oldSize;
        this.newSize = newSize;
    }

    public ConversionResult() {

    }

    public String getOldFileName() {
        return oldFileName;
    }

    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getOldSize() {
        return oldSize;
    }

    public void setOldSize(String oldSize) {
        this.oldSize = oldSize;
    }

    public String getNewSize() {
        return newSize;
    }

    public void setNewSize(String newSize) {
        this.newSize = newSize;
    }
}
