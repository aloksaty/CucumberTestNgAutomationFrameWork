package com.alok.aut.pojoClass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "data",
            "ad"
    })


    public class TestClass {
        @JsonProperty("data")
        private Data data;
        @JsonProperty("ad")
        private Ad ad;

        @JsonProperty("data")
        public Data getData() {
            return data;
        }

        @JsonProperty("data")
        public void setData(Data data) {
            this.data = data;
        }

        @JsonProperty("ad")
        public Ad getAd() {
            return ad;
        }

        @JsonProperty("ad")
        public void setAd(Ad ad) {
            this.ad = ad;
        }

        @Override
        public String toString() {
            return  this.data.toString()+this.ad.toString();
        }

    }

