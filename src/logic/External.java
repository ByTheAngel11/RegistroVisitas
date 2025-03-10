package logic;

public class External {
    private String email;
    private String names;
    private String surnames;
    private String officialIdentification;

    public External(String email, String names, String surnames, String officialIdentification) {
        this.email = email;
        this.names = names;
        this.surnames = surnames;
        this.officialIdentification = officialIdentification;
    }

    public External() {
        this.email = "";
        this.names = "";
        this.surnames = "";
        this.officialIdentification = "";
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

    public String getOfficialIdentification() {
        return officialIdentification;
    }

    public void setOfficialIdentification(String officialIdentification) {
        this.officialIdentification = officialIdentification;
    }

    public String toString() {
        return "Email: " + email + ", Names: " + names + ", Surnames: " + surnames + ", Official Identification: " + officialIdentification;
    }
}
