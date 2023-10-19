package com.example.costcatcher;

public class Payee {

    private int payeeId;

    private String payeeName;

    private String contactNumber;

    private String email;

    private String streetAddress;


    private String postalCode;


    private String country;

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
        if (!payeeName.matches("^[A-Za-z].+"))
            throw new IllegalArgumentException("payee name must start with a letter");
        this.payeeName = payeeName;
    }

    public String getContactNumber() {
        return contactNumber;
    }


    /**
     * Phone number must be between 4 and 15 digits, cannot be empty or null
     * @param contactNumber
     */
    public void setContactNumber(String contactNumber) {

        if ((contactNumber==null) || (!contactNumber.matches("\\d{4,15}")))
            throw new IllegalArgumentException("number cannot be null or empty, and must be between 4 and 15 digits");

        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Email must contain @ and .
     * @param email
     */
    public void setEmail(String email) {
        if ((email==null) || (!email.matches("^.+@.+\\.+$")))
            this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {

        // trim the address
        streetAddress = streetAddress.trim();
        // must start with a numbers and then letters
        if(!streetAddress.matches("^\\d+\\s*[A-Za-z,-]+[A-Za-z\\s,-]*"))
            throw  new IllegalArgumentException("Street address must be the form (digits Street name)");
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    /**
     *  Postal code length must be between 2 and 10 characters (inclusive)
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        if((postalCode==null) || (!postalCode.matches(".{2,10}")))
            throw new IllegalArgumentException("Postal code must be between 2 and 10 characters (inclusive)");
        this.postalCode = postalCode;
    }

    /**
     *  Country must not contain digits and must be between 3 and 60 characters
     * @return
     */
    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {
        if( ( country==null) ||(!country.matches("\\D{3,60}")) )
            throw new IllegalArgumentException("Country must not contain digits and must be between 3 and 60 characters");
        this.country = country;
    }




    public Payee(int payeeId, String payeeName, String contactNumber, String email, String streetAddress, String postalCode, String country) {
        setPayeeId( payeeId);
        setPayeeName( payeeName);
        setContactNumber( contactNumber);
        setEmail( email);
        setStreetAddress( streetAddress);
        setPostalCode( postalCode);
        setCountry( country);
    }
    /**
     * Overloaded constructor to ignore payee id in payee creation
     *
     */
    public Payee( String payeeName, String contactNumber, String email, String streetAddress, String postalCode, String country) {
        setPayeeName( payeeName);
        setContactNumber( contactNumber);
        setEmail( email);
        setStreetAddress( streetAddress);
        setPostalCode( postalCode);
        setCountry( country);
    }
}