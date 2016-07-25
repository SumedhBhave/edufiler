package com.edusys.response.bo;

public class LoginResponseBO {
    private String sessionId;

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

        LoginResponseBO that = (LoginResponseBO) o;

        return sessionId != null ? sessionId.equals(that.sessionId) : that.sessionId == null;

    }

    @Override
    public int hashCode() {
        return sessionId != null ? sessionId.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "LoginResponseBO{" +
                "sessionId='" + sessionId + '\'' +
                '}';
    }
}
