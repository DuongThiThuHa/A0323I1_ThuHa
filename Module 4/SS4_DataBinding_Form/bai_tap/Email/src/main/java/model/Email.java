package model;

public class Email {
    private String emailID;
    private String language;
    private int pageSize;
    private boolean haveSpamsFilter;
    private String signature;

    public String getMailID() {
        return emailID;
    }

    public void setMailID(String mailID) {
        this.emailID = mailID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isHaveSpamsFilter() {
        return haveSpamsFilter;
    }

    public void setHaveSpamsFilter(boolean haveSpamsFilter) {
        this.haveSpamsFilter = haveSpamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Email(String emailID, String language, int pageSize, boolean haveSpamsFilter, String signature) {
        this.emailID = emailID;
        this.language = language;
        this.pageSize = pageSize;
        this.haveSpamsFilter = haveSpamsFilter;
        this.signature = signature;
    }

    public Email() {
    }
}

