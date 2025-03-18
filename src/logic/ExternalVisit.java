package logic;

import java.sql.Timestamp;

public class ExternalVisit {
    private int visitNumber;
    private String visitSubject;
    private Timestamp entryDate;
    private Timestamp exitDate;
    private String email;

    public ExternalVisit(int visitNumber, String visitSubject, Timestamp entryDate, Timestamp exitDate, String email) {
        this.visitNumber = visitNumber;
        this.visitSubject = visitSubject;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.email = email;
    }

    public ExternalVisit(String visitSubject, Timestamp entryDate, Timestamp exitDate, String email) {
        this.visitNumber = 0;
        this.visitSubject = visitSubject;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.email = email;
    }

    public ExternalVisit(String visitSubject, Timestamp entryDate, String email) {
        this.visitNumber = 0;
        this.visitSubject = visitSubject;
        this.entryDate = entryDate;
        this.exitDate = null;
        this.email = email;
    }

    public int getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(int visitNumber) {
        this.visitNumber = visitNumber;
    }

    public String getVisitSubject() {
        return visitSubject;
    }

    public void setVisitSubject(String visitSubject) {
        this.visitSubject = visitSubject;
    }

    public Timestamp getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Timestamp entryDate) {
        this.entryDate = entryDate;
    }

    public Timestamp getExitDate() {
        return exitDate;
    }

    public void setExitDate(Timestamp exitDate) {
        this.exitDate = exitDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "VisitaExterno{" + "numeroVisita=" + visitNumber + ", asuntoVisita=" + visitSubject + ", fechaEntrada=" + entryDate + ", fechaSalida=" + exitDate + ", correo=" + email + '}';
    }
}