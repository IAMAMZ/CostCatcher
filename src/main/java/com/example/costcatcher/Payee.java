package com.example.costcatcher;

public class Payee {

    private int payeeId;

    private String payeeName;

    private String contactNumber;

    private String email;

    private String streetAddress;


    private String postalCode;


    private String Country;

    public int getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(int payeeId) {

        if( payeeId<= 0 ){
            throw new IllegalArgumentException("Id cannot be negative or zero");
        }
        this.payeeId = payeeId;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        // payee should start with a letter
        if (!payeeName.matches("^([A-Z]|[a-z])"))
            throw new IllegalArgumentException("payee name must start with a letter");
        this.payeeName = payeeName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {

        // trim the address
        streetAddress = streetAddress.trim();
        // must start with a numbers and then letters
        if(!streetAddress.matches("^\\d+\\s*[A-Za-z]+[A-Za-z\\s]*$"))
            throw  new IllegalArgumentException("Street address must be the form (digts Street name)");
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }




    public Payee(int payeeId, String payeeName, String contactNumber, String email, String streetAddress, String postalCode, String country) {
        this.payeeId = payeeId;
        this.payeeName = payeeName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        Country = country;
    }
}
