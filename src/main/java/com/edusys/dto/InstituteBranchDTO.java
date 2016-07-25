package com.edusys.dto;
public class InstituteBranchDTO {
    private int id;
    private String name;
    private String address;
    private int cityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstituteBranchDTO that = (InstituteBranchDTO) o;

        if (id != that.id) return false;
        if (cityId != that.cityId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + cityId;
        return result;
    }

    @Override
    public String toString() {
        return "InstituteBranchDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
