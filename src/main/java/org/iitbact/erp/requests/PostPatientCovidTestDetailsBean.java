package org.iitbact.erp.requests;

import java.sql.Date;

public class PostPatientCovidTestDetailsBean extends BaseRequest {
    private boolean sampleCollected;
    private Date collectionDate;
    private String collectionCenter;
    private String testedAt;
    private boolean resultAvailable;
    private String lab;
    private String result;

    public boolean isSampleCollected() {
        return sampleCollected;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public boolean isResultAvailable() {
        return resultAvailable;
    }

    public void setResultAvailable(boolean resultAvailable) {
        this.resultAvailable = resultAvailable;
    }

    public String getTestedAt() {
        return testedAt;
    }

    public void setTestedAt(String testedAt) {
        this.testedAt = testedAt;
    }

    public String getCollectionCenter() {
        return collectionCenter;
    }

    public void setCollectionCenter(String collectionCenter) {
        this.collectionCenter = collectionCenter;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public void setSampleCollected(boolean sampleCollected) {
        this.sampleCollected = sampleCollected;
    }

}