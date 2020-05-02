package org.iitbact.erp.requests;

import java.sql.Date;

public class PostPatientClinicalHistBean extends BaseRequest {
    private boolean symptomAtTimeofAddmission;
    private Date onsetSymptoms;
    private Object primarySymptom;
    private Object secondarySymptom;
    private Object preExistingConditions;

    public boolean isSymptomAtTimeofAddmission() {
        return symptomAtTimeofAddmission;
    }

    public Object getPreExistingConditions() {
        return preExistingConditions;
    }

    public void setPreExistingConditions(Object preExistingConditions) {
        this.preExistingConditions = preExistingConditions;
    }

    public Object getSecondarySymptom() {
        return secondarySymptom;
    }

    public void setSecondarySymptom(Object secondarySymptom) {
        this.secondarySymptom = secondarySymptom;
    }

    public Object getPrimarySymptom() {
        return primarySymptom;
    }

    public void setPrimarySymptom(Object primarySymptom) {
        this.primarySymptom = primarySymptom;
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
}