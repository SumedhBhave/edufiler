package com.edusys.dto.request;

import java.sql.Timestamp;

public class StudentRequestDTO {
    private int id;
    private String name;
    private String address;
    private String imagePath;
    private String mobile;
    private String college;
    private Timestamp admissionDate;
    private Timestamp dateOfBirth;
    private String gender;
    private String parentName;
    private String parentOccupation;
    private String parentRelation;
    private String parentPhone;
    private int instituteBranchId;

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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Timestamp getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Timestamp admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentOccupation() {
        return parentOccupation;
    }

    public void setParentOccupation(String parentOccupation) {
        this.parentOccupation = parentOccupation;
    }

    public String getParentRelation() {
        return parentRelation;
    }

    public void setParentRelation(String parentRelation) {
        this.parentRelation = parentRelation;
    }

    public int getInstituteBranchId() {
        return instituteBranchId;
    }

    public void setInstituteBranchId(int instituteBranchId) {
        this.instituteBranchId = instituteBranchId;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentRequestDTO that = (StudentRequestDTO) o;

        if (id != that.id) return false;
        if (instituteBranchId != that.instituteBranchId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (imagePath != null ? !imagePath.equals(that.imagePath) : that.imagePath != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (college != null ? !college.equals(that.college) : that.college != null) return false;
        if (admissionDate != null ? !admissionDate.equals(that.admissionDate) : that.admissionDate != null)
            return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (parentName != null ? !parentName.equals(that.parentName) : that.parentName != null) return false;
        if (parentOccupation != null ? !parentOccupation.equals(that.parentOccupation) : that.parentOccupation != null)
            return false;
        if (parentRelation != null ? !parentRelation.equals(that.parentRelation) : that.parentRelation != null)
            return false;
        return parentPhone != null ? parentPhone.equals(that.parentPhone) : that.parentPhone == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (college != null ? college.hashCode() : 0);
        result = 31 * result + (admissionDate != null ? admissionDate.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (parentName != null ? parentName.hashCode() : 0);
        result = 31 * result + (parentOccupation != null ? parentOccupation.hashCode() : 0);
        result = 31 * result + (parentRelation != null ? parentRelation.hashCode() : 0);
        result = 31 * result + (parentPhone != null ? parentPhone.hashCode() : 0);
        result = 31 * result + instituteBranchId;
        return result;
    }

    @Override
    public String toString() {
        return "StudentRequestDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", mobile='" + mobile + '\'' +
                ", college='" + college + '\'' +
                ", admissionDate=" + admissionDate +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentOccupation='" + parentOccupation + '\'' +
                ", parentRelation='" + parentRelation + '\'' +
                ", parentPhone='" + parentPhone + '\'' +
                ", instituteBranchId=" + instituteBranchId +
                '}';
    }
}
