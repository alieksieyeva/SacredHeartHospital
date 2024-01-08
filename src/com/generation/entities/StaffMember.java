package com.generation.entities;

import static com.generation.util.DbUtil.toQuote;

import java.time.LocalDate;

public class StaffMember extends Employee {
    
    private String role;
    private String email;
    private String deparment;
    
    public StaffMember(int id, String name, String surname, LocalDate dob, int monthSalary, int nMonths, String role,
            String email, String deparment) {
        super(id, name, surname, dob, monthSalary, nMonths);
        this.role = role;
        this.email = email;
        this.deparment = deparment;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDeparment() {
        return deparment;
    }
    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }

    public String toInsertQuery() {
        return "INSERT INTO StaffMember (name, surname, dob, monthSalary, nMonths, role, email, department)"+
        "VALUES( " + toQuote(name) + ", " + toQuote(surname) + ", " + toQuote(dob+"") + ", " + monthSalary + ", " + nMonths + ", " +
        toQuote(role) + ", " + toQuote(email) + ", " + toQuote(deparment) + ");";
    }

    @Override
    public boolean isValid() {
        return super.isValid() && !role.isBlank() && role!=null && !email.isBlank()
                && email!=null && !deparment.isBlank() && deparment!=null;
    }
    @Override
    public String toString() {
        return super.toString() + "StaffMember [role=" + role + ", email=" + email + ", deparment=" + deparment + "]";
    }
    public String toUpdateQuery() {
        return "UPDATE StaffMember SET name =" + toQuote(name) + ", surname = " + toQuote(surname) + ", dob=" + toQuote(dob+"") + ", monthSalary =" + monthSalary + ", nMonths =" + nMonths
        + ", role=" + toQuote(role) + ", email= " + toQuote(email) + ", department" + toQuote(deparment) + ");";
    }
    public String toDeleteQuery() {
        return "DELETE FROM StaffMember where id= "+this.id;
    }
    
    
}
