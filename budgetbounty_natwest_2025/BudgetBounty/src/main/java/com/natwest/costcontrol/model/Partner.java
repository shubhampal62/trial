package com.natwest.costcontrol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "partner")
public class Partner {

    @Id
    @Column(name = "partner_id", length = 36)
    private String partnerId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "api_key", length = 200)
    private String apiKey;

    // Constructors
    public Partner() {}

    public Partner(String partnerId, String name, String apiKey) {
        this.partnerId = partnerId;
        this.name = name;
        this.apiKey = apiKey;
    }

    // Getters and Setters
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
