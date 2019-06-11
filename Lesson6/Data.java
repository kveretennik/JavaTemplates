package ru.constantin;

public class Data {

    private Long dataId;
    private String dataDesc;

    public Data (Long dataId, String dataDesc) {
        this.dataId = dataId;
        this.dataDesc = dataDesc;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }

    public Long getDataId() {
        return dataId;
    }
}