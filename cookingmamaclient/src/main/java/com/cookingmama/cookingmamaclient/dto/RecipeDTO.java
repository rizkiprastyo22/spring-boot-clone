package com.cookingmama.cookingmamaclient.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
@Data

public class RecipeDTO {

    // inisialisasi data untuk menampung api
    @Id
    private Long id;
    private String name;
    private String howto;
    private String ingredients;
    private Boolean publik;
    private String userid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHowto() {
        return howto;
    }

    public void setHowto(String howto) {
        this.howto = howto;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Boolean getPublik() {
        return publik;
    }

    public void setPublik(Boolean publik) {
        this.publik = publik;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
