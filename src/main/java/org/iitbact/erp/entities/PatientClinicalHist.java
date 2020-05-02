package org.iitbact.erp.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.iitbact.erp.requests.PostPatientClinicalHistBean;

import java.text.ParseException;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@Table(name = "patient_clinical_hist")
@NamedQuery(name = "PatientClinicalHist.findAll", query = "SELECT c from PatientClinicalHist c")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class PatientClinicalHist implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private boolean symptomAtTimeofAddmission;
    private Date onsetSymptoms;

    @Type(type = "json")
    @Column(name = "primary_symptoms", columnDefinition = "json")
    private Object primarySymptom;

    @Type(type = "json")
    @Column(name = "secondary_symptoms", columnDefinition = "json")
    private Object secondarySymptom;

    @Type(type = "json")
    @Column(name = "pre_existing_conditions", columnDefinition = "json")
    private Object preExistingConditions;

    public boolean isSymptomAtTimeofAddmission() {
        return symptomAtTimeofAddmission;
    }

    public Date getOnsetSymptoms() {
        return onsetSymptoms;
    }

    public void setOnsetSymptoms(Date onsetSymptoms) {
        this.onsetSymptoms = onsetSymptoms;
    }

    public void setSymptomAtTimeofAddmission(boolean symptomAtTimeofAddmission) {
        this.symptomAtTimeofAddmission = symptomAtTimeofAddmission;
    }

    public Object getPreExistingMedicalCondition() {
        return preExistingConditions;
    }

    public void setPreExistingMedicalCondition(Object preExistingMedicalCondition) {
        this.preExistingConditions = preExistingMedicalCondition;
    }

    public Object getPrimary() {
        return primarySymptom;
    }

    public void setPrimary(Object data) {
        this.primarySymptom = data;
    }

    public Object getSecondary() {
        return secondarySymptom;
    }

    public void setSecondary(Object data) {
        this.secondarySymptom = data;
    }

    public PatientClinicalHist(final PostPatientClinicalHistBean request) throws ParseException {
        this.setSymptomAtTimeofAddmission(request.isSymptomAtTimeofAddmission());
        this.setOnsetSymptoms(request.getOnsetSymptoms());
        this.setPrimary(request.getPrimarySymptom());
        this.setSecondary(request.getSecondarySymptom());
        this.setPreExistingMedicalCondition(request.getPreExistingConditions());
    }
}