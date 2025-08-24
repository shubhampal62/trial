package com.natwest.costcontrol.dto;

public class PartnerResponseDTO {
    private String partnerId;
    private String name;
    private String apiKey;

    public PartnerResponseDTO() {}

    public PartnerResponseDTO(String partnerId, String name, String apiKey) {
        this.partnerId = partnerId;
        this.name = name;
        this.apiKey = apiKey;
    }

    public String getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getApiKey() {
        return apiKey;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
