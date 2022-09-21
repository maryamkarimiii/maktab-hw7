package ir.maktab.hw7.modle;

public class Medicine {
    private Integer id;
    private String name;
    private String producerCompany;
    private String classification;
    private Integer dose;
    private Boolean supportByInsurance;
    private Boolean OTC;
    private Integer price;
    private Boolean isExist;
    private Prescription prescription;

    public Medicine() {
    }

    public Medicine(Integer id, String name, String producerCompany, String classification, Integer dose,
                    Boolean supportByInsurance, Boolean OTC, Integer price, Boolean isExist) {
        this.id = id;
        this.name = name;
        this.producerCompany = producerCompany;
        this.classification = classification;
        this.dose = dose;
        this.supportByInsurance = supportByInsurance;
        this.OTC = OTC;
        this.price = price;
        this.isExist = isExist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getExist() {
        return isExist;
    }

    public void setExist(Boolean exist) {
        isExist = exist;
    }

}
