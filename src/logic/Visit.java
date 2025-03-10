package logic;

import java.sql.Timestamp;

public class Visit {
    private int visitNumber;
    private String visitSubject;
    private Timestamp entryDate;
    private Timestamp exitDate;
    private String email;

    public Visit(int visitNumber, String visitSubject, Timestamp entryDate, Timestamp exitDate, String email) {
        this.visitNumber = visitNumber;
        this.visitSubject = visitSubject;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.email = email;
    }

    public Visit(String visitSubject, Timestamp entryDate, Timestamp exitDate, String email) {
        this.visitNumber = 0;
        this.visitSubject = visitSubject;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.email = email;
    }

    public Visit() {
        this.visitNumber = 0;
        this.visitSubject = "";
        this.entryDate = new Timestamp(System.currentTimeMillis());
        this.exitDate = new Timestamp(System.currentTimeMillis());
        this.email = "";
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
        return "Visita [numeroVisita=" + visitNumber + ", asuntoVisita=" + visitSubject + ", fechaEntrada=" + entryDate + ", fechaSalida=" + exitDate + ", correo=" + email + "]";
    }
}