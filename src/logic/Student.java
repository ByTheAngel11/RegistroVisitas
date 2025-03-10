package logic;

public class Student {
    private String email;
    private String names;
    private String surnames;
    private String enrollment;

    public Student(String email, String names, String surnames, String enrollment) {
        this.email = email;
        this.names = names;
        this.surnames = surnames;
        this.enrollment = enrollment;
    }

    public Student() {
        this.email = "";
        this.names = "";
        this.surnames = "";
        this.enrollment = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String toString(){
        return "Email: " + email + " Names: " + names + " Surnames: " + surnames + " Enrollment: " + enrollment + "\n";
    }





}
