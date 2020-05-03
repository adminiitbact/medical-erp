package org.iitbact.erp.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.TypeDef;
import org.iitbact.erp.requests.PostPatientCovidTestDetailsBean;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@Table(name = "patient_covid_test_details")
@NamedQuery(name = "PatientCovidTestDetails.findAll", query = "SELECT c from PatientCovidTestDetails c")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class PatientCovidTestDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean sampleCollected;
    private Date collectionDate;
    private String collectionCenter;
    private String testedAt;
    private boolean resultAvailable;
    private String lab;
    private String result;
    private String patientid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public boolean isSampleCollected() {
        return sampleCollected;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
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

    public PatientCovidTestDetails(final PostPatientCovidTestDetailsBean request) throws ParseException {
        this.setSampleCollected(request.isSampleCollected());
        this.setCollectionDate(request.getCollectionDate());
        this.setCollectionCenter(request.getCollectionCenter());
        this.setTestedAt(request.getTestedAt());
        this.setResultAvailable(request.isResultAvailable());
        this.setLab(request.getLab());
        this.setResult(request.getResult());
        this.setPatientid(request.getPatientid());
    }
}