package ir.maktab.hw7.modle;

public class Medicine {
    private String name;
    private String producerCompany;
    private String classification;
    private Integer dose;
    private Boolean OTC;
    private Integer price;
    private Boolean isExist;
    private Integer prescription_id;

    public Medicine() {
    }

    public Medicine( String name, String producerCompany, String classification, Integer dose,
                    Boolean supportByInsurance, Boolean OTC, Integer price, Boolean isExist, Integer prescription_id) {
        this.name = name;
        this.producerCompany = producerCompany;
        this.classification = classification;
        this.dose = dose;
        this.OTC = OTC;
        this.price = price;
        this.isExist = isExist;
        this.prescription_id = prescription_id;
    }

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

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
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

    public Boolean getExist() {
        return isExist;
    }

    public void setExist(Boolean exist) {
        isExist = exist;
    }

    public Integer getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(Integer prescription_id) {
        this.prescription_id = prescription_id;
    }
}
