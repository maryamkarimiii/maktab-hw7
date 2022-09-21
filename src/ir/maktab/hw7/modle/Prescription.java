package ir.maktab.hw7.modle;

import ir.maktab.hw7.modle.enums.PrescriptionStatus;

import java.util.Date;
import java.util.List;

public class Prescription {
    private Integer id;
    private Date date;
    private Patient patient;
    private Doctor doctor;
    private PrescriptionStatus prescriptionStatus;
    private List<Medicine>medicines;

    public Prescription() {
    }

    public Prescription(Integer id, Date date, Patient patient, Doctor doctor, PrescriptionStatus prescriptionStatus) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.prescriptionStatus = prescriptionStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public PrescriptionStatus getPrescriptionStatus() {
        return prescriptionStatus;
    }

    public void setPrescriptionStatus(PrescriptionStatus prescriptionStatus) {
        this.prescriptionStatus = prescriptionStatus;
    }

    public List<Medicine> getMedicines(List<Medicine> medicines) {
        return this.medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
