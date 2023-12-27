package Contents.Document;

import Contents.CFile;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a document with attributes such as caption, description, document number, issuer,
 * issue date, expire date, and a set of document copies.
 */
public class Document implements Serializable {

    private String caption;
    private String description;
    private String docNumber;
    private Address issuer;
    private Date issueDate;
    private Date expireDate;
    private HashSet<CFile> docCopies;

    /**
     * Default constructor with minimal information.
     */
    public Document() {
        // Default initialization
    }

    /**
     * Constructor with essential information.
     *
     * @param caption    The caption of the document.
     * @param docNumber   The document number.
     * @param issuer      The issuer address of the document.
     */
    public Document(String caption, String docNumber, Address issuer) {
        this.caption = caption;
        this.docNumber = docNumber;
        this.issuer = issuer;
    }

    /**
     * Constructor with all information.
     *
     * @param caption    The caption of the document.
     * @param description The description of the document.
     * @param docNumber   The document number.
     * @param issuer      The issuer address of the document.
     * @param issueDate   The issue date of the document (can be null).
     * @param expireDate  The expire date of the document (can be null).
     * @param docCopies   The set of document copies associated with this document (can be null).
     */
    public Document(String caption, String description, String docNumber, Address issuer,
                    Date issueDate, Date expireDate, HashSet<CFile> docCopies) {
        this.caption = caption;
        this.description = description;
        this.docNumber = docNumber;
        this.issuer = issuer;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
        this.docCopies = docCopies;
    }

    /**
     * Displays the content of the document.
     * This method simulates viewing the document.
     */
    public void viewDocument() {
        System.out.println("Viewing document: " + caption);
        // Logic to display the content of the document
    }

    /**
     * Returns a string representation of the document.
     *
     * @return A string representation of the document.
     */
    @Override
    public String toString() {
        return "Document{" +
                "caption='" + caption + '\'' +
                ", description='" + description + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", issuer=" + issuer +
                ", issueDate=" + issueDate +
                ", expireDate=" + expireDate +
                ", docCopies=" + docCopies +
                '}';
    }

    /**
     * Generates a hash code for the document.
     *
     * @return The hash code for the document.
     */
    @Override
    public int hashCode() {
        return Objects.hash(caption, description, docNumber, issuer, issueDate, expireDate, docCopies);
    }

    // Getters and Setters

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Address getIssuer() {
        return issuer;
    }

    public void setIssuer(Address issuer) {
        this.issuer = issuer;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public HashSet<CFile> getDocCopies() {
        return docCopies;
    }

    public void setDocCopies(HashSet<CFile> docCopies) {
        this.docCopies = docCopies;
    }
}

