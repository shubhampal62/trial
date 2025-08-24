package com.natwest.costcontrol.dto;

public class PartnerRequestDTO {
    private String name;
    private String apiKey;

    public PartnerRequestDTO() {}

    public PartnerRequestDTO(String name, String apiKey) {
        this.name = name;
        this.apiKey = apiKey;
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
