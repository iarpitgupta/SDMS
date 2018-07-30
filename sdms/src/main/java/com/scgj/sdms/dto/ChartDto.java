package com.scgj.sdms.dto;

public class ChartDto {
    private Long xAxis;
    private Long yAxis;

    public Long getxAxis() {
        return xAxis;
    }

    public Long getyAxis() {
        return yAxis;
    }

    public ChartDto(Long xAxis, Long yAxis) {

        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
}
