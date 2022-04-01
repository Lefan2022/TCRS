package com.example.tcrs;

import android.os.Parcel;
import android.os.Parcelable;

//Profile object for drivers
public class DriverProfile implements Parcelable {
    String ID = null;
    String FirstName = null;
    String LastName =null;
    String Password = null;
    String LicenseNo = null;
    double Balance = 0;
    TicketsHistory TicketHistory = new TicketsHistory();

    //constructor
    public DriverProfile(){}

    protected DriverProfile(Parcel in) {
        ID = in.readString();
        FirstName = in.readString();
        LastName = in.readString();
        Password = in.readString();
        LicenseNo = in.readString();
        Balance = in.readDouble();
    }

    public static final Creator<DriverProfile> CREATOR = new Creator<DriverProfile>() {
        @Override
        public DriverProfile createFromParcel(Parcel in) {
            return new DriverProfile(in);
        }

        @Override
        public DriverProfile[] newArray(int size) {
            return new DriverProfile[size];
        }
    };

    //getters and setters
    public String getID(){
        return this.ID;
    }

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

    public void setID(String ID){
        this.ID = ID;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ID);
        parcel.writeString(FirstName);
        parcel.writeString(LastName);
        parcel.writeString(Password);
        parcel.writeString(LicenseNo);
        parcel.writeDouble(Balance);
    }
}
