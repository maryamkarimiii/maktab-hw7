package ir.maktab.hw7.modle;

public class medicine {
    private String name;
    private String producerCompany;
    private Boolean supportByInsurance;
    private Boolean RX;
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

    public Boolean getSupportByInsurance() {
        return supportByInsurance;
    }

    public void setSupportByInsurance(Boolean supportByInsurance) {
        this.supportByInsurance = supportByInsurance;
    }

    public Boolean getRX() {
        return RX;
    }

    public void setRX(Boolean RX) {
        this.RX = RX;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
