package Contents.Document;

import Contents.CFile;
import Enums.Gender;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**
 * The Passport class represents a passport document.
 */
public class Passport extends Document {
    // Additional Attributes
    private String IIN;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private Gender gender;
    private String citizenship;
    private Boolean isResident;
    private String nationality;

    // Constructors

    /**
     * Full constructor to initialize all attributes of the passport.
     *
     * @param IIN          The Individual Identification Number (IIN) of the passport holder.
     * @param lastName     The last name of the passport holder.
     * @param firstName    The first name of the passport holder.
     * @param middleName   The middle name of the passport holder.
     * @param birthDate    The birth date of the passport holder.
     * @param gender       The gender of the passport holder.
     * @param citizenship  The citizenship of the passport holder.
     * @param isResident   A boolean indicating whether the passport holder is a resident.
     * @param nationality  The nationality of the passport holder.
     * @param caption      The caption of the passport.
     * @param docNumber    The document number of the passport.
     * @param description  The document description.
     * @param issuer       The issuer address of the passport.
     * @param issueDate    The issue date of the passport (can be null).
     * @param expireDate   The expire date of the passport (can be null).
     * @param docCopies    The set of document copies associated with this passport (can be null).
     */
    public Passport(String IIN, String lastName, String firstName, String middleName,
                    Date birthDate, Gender gender, String citizenship, Boolean isResident,
                    String nationality, String caption, String description, String docNumber, Address issuer,
                    Date issueDate, Date expireDate, HashSet<CFile> docCopies) {
        super(caption, description, docNumber, issuer, issueDate, expireDate, docCopies);
        this.IIN = IIN;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.citizenship = citizenship;
        this.isResident = isResident;
        this.nationality = nationality;
    }

    /**
     * Constructor to initialize of the passport.
     *
     * @param IIN          The Individual Identification Number (IIN) of the passport holder.
     * @param lastName     The last name of the passport holder.
     * @param firstName    The first name of the passport holder.
     * @param middleName   The middle name of the passport holder.
     * @param birthDate    The birth date of the passport holder.
     * @param gender       The gender of the passport holder.
     * @param citizenship  The citizenship of the passport holder.
     * @param isResident   A boolean indicating whether the passport holder is a resident.
     * @param nationality  The nationality of the passport holder.
     * @param caption      The caption of the passport.
     * @param docNumber    The document number of the passport.
     * @param issuer       The issuer address of the passport.
     */
    public Passport(String IIN, String lastName, String firstName, String middleName,
                    Date birthDate, Gender gender, String citizenship, Boolean isResident,
                    String nationality, String caption, String docNumber, Address issuer) {
        super(caption, docNumber, issuer);
        this.IIN = IIN;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.citizenship = citizenship;
        this.isResident = isResident;
        this.nationality = nationality;
    }

    // Override toString() for better string representation

    @Override
    public String toString() {
        return "Passport{" +
                "IIN='" + IIN + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", citizenship=" + citizenship +
                ", isResident=" + isResident +
                ", nationality=" + nationality +
                "} " + super.toString();
    }

    // Override hashCode() for proper hash code generation

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), IIN, lastName, firstName, middleName,
                birthDate, gender, citizenship, isResident, nationality);
    }

    // Override equals() for proper object equality comparison

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Passport passport = (Passport) obj;
        return Objects.equals(IIN, passport.IIN) &&
                super.equals(obj); // Call to superclass equals method
    }
}

