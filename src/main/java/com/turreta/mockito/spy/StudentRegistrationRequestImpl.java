package com.turreta.mockito.spy;

public class StudentRegistrationRequestImpl implements StudentRegistrationRequest {

    private StudentBean studentSearchCriteria;

    public void setStudentSearchCriteria(StudentBean studentCriteria) {
        this.studentSearchCriteria = studentCriteria;
    }

    public StudentBean getStudentSearchCriteria() {
        return this.studentSearchCriteria;
    }

}
