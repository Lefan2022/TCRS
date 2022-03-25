package com.example.tcrs;

//Profile object for drivers
public class DriverProfile extends Profile{
    String FirstName = null;
    String LastName =null;
    String Password = null;
    String LicenseNo = null;
    double Balance = 0;
    TicketsHistory TicketHistory = null;

    public DriverProfile(){}

    public String getFirstName() {
        return this.FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public String getPassword() {
        return this.Password;
    }

    public String getLicenseNo() {
        return this.LicenseNo;
    }

    public double getBalance() {
        return this.Balance;
    }

    public TicketsHistory getTH() {
        return this.TicketHistory;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public void setLicenseNo(String licenseNo) {
        this.LicenseNo = licenseNo;
    }

    public void setBalance(double balance) {
        this.Balance = balance;
    }
}
