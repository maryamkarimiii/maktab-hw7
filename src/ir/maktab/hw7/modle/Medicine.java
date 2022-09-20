package ir.maktab.hw7.modle;

public class Medicine {
    private String name;
    private String producerCompany;
    private String classification;
    private Boolean supportByInsurance;
    private Boolean OTC;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducerCompany() {
        return producerCompany;
    }

    public void setProducerCompany(String producerCompany) {
        this.producerCompany = producerCompany;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Boolean getSupportByInsurance() {
        return supportByInsurance;
    }

    public void setSupportByInsurance(Boolean supportByInsurance) {
        this.supportByInsurance = supportByInsurance;
    }

    public Boolean getOTC() {
        return OTC;
    }

    public void setOTC(Boolean OTC) {
        this.OTC = OTC;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
