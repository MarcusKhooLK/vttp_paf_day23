package vttp.paf.day23.model;

import java.sql.Date;

import org.springframework.util.MultiValueMap;

public class Contact {

    private String email;
    private String name;
    private String phone;
    private Date dob;
    private String status;
    private String passphrase;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getPassphrase() {
        return passphrase;
    }
    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public static Contact create(MultiValueMap<String, String> form) {
        Contact c = new Contact();
        c.setEmail(form.getFirst("email"));
        c.setName(form.getFirst("name"));
        c.setPhone(form.getFirst("phone"));
        c.setDob(Date.valueOf(form.getFirst("dob")));
        System.out.println(c.getDob());
        c.setStatus(form.getFirst("status"));
        c.setPassphrase(form.getFirst("passphrase"));
        return c;
    }

}
