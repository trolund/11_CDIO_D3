package data.dto;

import java.util.ArrayList;
import java.util.List;

public class OperatorDTO {

    private int oprId;
    private String oprNavn;
    private String oprIni;
    private String oprCpr;
    private String oprPassword;
    private List<String> oprRoles; // Vi skal lave en ekstra tabel som indeholder roller.

    public OperatorDTO(int oprId, String oprNavn, String oprIni, String oprCpr, String oprPassword, List<String> oprRoles)  {
        this.oprId = oprId;
        this.oprIni = oprIni;
        this.oprNavn = oprNavn;
        this.oprCpr = oprCpr;
        this.oprPassword = oprPassword;
        this.oprRoles = oprRoles;
    }

    public OperatorDTO() {
        this.oprRoles = new ArrayList<>();
    }

    public int getOprId() {
        return oprId;
    }

    public void setOprId(int oprId) {
        this.oprId = oprId;
    }

    public String getOprNavn() {
        return oprNavn;
    }

    public void setOprNavn(String oprNavn) {
        this.oprNavn = oprNavn;
    }

    public String getOprIni() {
        return oprIni;
    }

    public void setOprIni(String oprIni) {
        this.oprIni = oprIni;
    }

    public String getOprCpr() {
        return oprCpr;
    }

    public void setOprCpr(String oprCpr) {
        this.oprCpr = oprCpr;
    }

    public String getOprPassword() {
        return oprPassword;
    }

    public void setOprPassword(String oprPassword) {
        this.oprPassword = oprPassword;
    }

    public List<String> getOprRoles() {
        return oprRoles;
    }

    public void setOprRoles(List<String> oprRoles) {
        this.oprRoles = oprRoles;
    }

}