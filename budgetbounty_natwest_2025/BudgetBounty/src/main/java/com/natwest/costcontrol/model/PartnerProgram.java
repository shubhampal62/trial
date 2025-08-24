package com.natwest.costcontrol.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "partner_programs")
public class PartnerProgram {

    @Id
    @Column(name = "program_id", length = 36)
    private String programId;

    @Column(name = "program_name", nullable = false)
    private String programName;

    @Column(name = "program_type", nullable = false)
    private String programType;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "conversion_rate", nullable = false, precision = 10, scale = 4)
    private BigDecimal conversionRate;

    @Column(name = "minimum_points", nullable = false)
    private Integer minimumPoints;

    @Column(name = "partner_id", length = 36)
    private String partnerId;

    // Constructors
    public PartnerProgram() {}

    public PartnerProgram(String programId, String programName, String programType,
                           String description, BigDecimal conversionRate,
                           Integer minimumPoints, String partnerId) {
        this.programId = programId;
        this.programName = programName;
        this.programType = programType;
        this.description = description;
        this.conversionRate = conversionRate;
        this.minimumPoints = minimumPoints;
        this.partnerId = partnerId;
    }

    // Getters and Setters
    public String getProgramId() {
        return programId;
    }
    public void setProgramId(String programId) {
        this.programId = programId;
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
