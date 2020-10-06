package com.example.countriesapi;

import java.util.List;

public class Countries {

        private String name;
        private List<String> topLevelDomain;
        public String alpha2Code;
        public String alpha3Code;
        public List<String> callingCodes;
        public String capital;
        public List<String> altSpellings;
        public String region;
        public String subregion;

    public void setPopulation(int population) {
        this.population = population;
    }

    public int population;
        public List<Double> latlng;
        public String demonym;
        public int area;
        public double gini;
        public List<String> timezones;
        public List<String> borders;
        public String nativeName;
        public String numericCode;
        public List<Currency> currencies;
        public List<Language> languages;
        public Translations translations;
        public String flag;
        public List<RegionalBlock> regionalBlocs;
        public String cioc;


    public String getName() {
        return name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public int getPopulation() {
        return population;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public int getArea() {
        return area;
    }

    public double getGini() {
        return gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public Translations getTranslations() {
        return translations;
    }

    public String getFlag() {
        return flag;
    }

    public List<RegionalBlock> getRegionalBlocs() {
        return regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }
}
