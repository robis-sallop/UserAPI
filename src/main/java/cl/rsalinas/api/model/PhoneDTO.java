package cl.rsalinas.api.model;

public class PhoneDTO {

    private long phone_id;
    private Integer number;
    private Integer citycode;
    private Integer countrycode;

    public PhoneDTO(long phone_id, Integer number, Integer citycode, Integer countrycode) {
        this.phone_id = phone_id;
        this.number = number;
        this.citycode = citycode;
        this.countrycode = countrycode;
    }

    public long getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(long phone_id) {
        this.phone_id = phone_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCitycode() {
        return citycode;
    }

    public void setCitycode(Integer citycode) {
        this.citycode = citycode;
    }

    public Integer getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(Integer countrycode) {
        this.countrycode = countrycode;
    }

    @Override
    public String toString() {
        return "PhoneDTO{" +
                "phone_id=" + phone_id +
                ", number=" + number +
                ", citycode=" + citycode +
                ", countrycode=" + countrycode +
                '}';
    }
}
