package com.edusys.dto.response;

public class LoginResponseDTO {
    private int id;
    private String userName;
    private String password;
    private int typeId;
    private String status;
    private String sessionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginResponseDTO that = (LoginResponseDTO) o;

        if (id != that.id) return false;
        if (typeId != that.typeId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return sessionId != null ? sessionId.equals(that.sessionId) : that.sessionId == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + typeId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", typeId=" + typeId +
                ", status='" + status + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
