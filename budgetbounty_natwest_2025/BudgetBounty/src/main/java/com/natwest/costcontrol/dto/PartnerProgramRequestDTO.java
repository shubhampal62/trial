package com.natwest.costcontrol.dto;

import java.math.BigDecimal;

public class PartnerProgramRequestDTO {
    private String programName;
    private String programType;
    private String description;
    private BigDecimal conversionRate;
    private Integer minimumPoints;
    private String partnerId;

    public PartnerProgramRequestDTO() {}

    public PartnerProgramRequestDTO(String programName, String programType, String description,
                                     BigDecimal conversionRate, Integer minimumPoints, String partnerId) {
        this.programName = programName;
        this.programType = programType;
        this.description = description;
        this.conversionRate = conversionRate;
        this.minimumPoints = minimumPoints;
        this.partnerId = partnerId;
    }

    public String getProgramName() {
        return programName;
    }
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramType() {
        return programType;
    }
    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }
    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Integer getMinimumPoints() {
        return minimumPoints;
    }
    public void setMinimumPoints(Integer minimumPoints) {
        this.minimumPoints = minimumPoints;
    }

    public String getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
}
