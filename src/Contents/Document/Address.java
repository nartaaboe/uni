package Contents.Document;

import java.io.Serializable;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Address class represents a physical address.
 */
public class Address implements Serializable {
    // Attributes
    private String title;
    private String postalCode;
    private String country;
    private String region;
    private String city;
    private String district;
    private String street;

    /**
     * Full constructor to initialize all attributes of the address.
     *
     * @param title      The title or name associated with the address.
     * @param postalCode The postal code of the address.
     * @param country    The country of the address (an instance of the Country class).
     * @param region     The region or state of the address.
     * @param city       The city of the address.
     * @param district   The district or locality of the address.
     * @param street     The street or street address of the location.
     */
    public Address(String title, String postalCode, String country, String region,
                   String city, String district, String street) {
        this.title = title;
        this.postalCode = postalCode;
        this.country = country;
        this.region = region;
        this.city = city;
        this.district = district;
        this.street = street;
    }

    /**
     * Constructor to create an address with minimal required information.
     *
     * @param title      The title or name associated with the address.
     * @param postalCode The postal code of the address.
     * @param country    The country of the address.
     */
    public Address(String title, String postalCode, String country) {
        this.title = title;
        this.postalCode = postalCode;
        this.country = country;
    }

    /**
     * Constructor to create an address with only title and country.
     *
     * @param title   The title or name associated with the address.
     * @param country The country of the address.
     */
    public Address(String title, String country) {
        this.title = title;
        this.country = country;
    }

    /**
     * Default constructor. Initializes an empty address.
     */
    public Address() {
        // Default values or leave attributes uninitialized
    }

    // Other methods...

    /**
     * Displays the details of the address.
     */
    public void viewAddress() {
        System.out.println(toString());
    }

    // Override toString() for better string representation

    @Override
    public String toString() {
        return "Address{" +
                "title='" + title + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country=" + country +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    // Override hashCode() for proper hash code generation

    @Override
    public int hashCode() {
        return Objects.hash(title, postalCode, country, region, city, district, street);
    }

    // Override equals() for proper object equality comparison

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Address address = (Address) obj;
        return Objects.equals(title, address.title) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(country, address.country) &&
                Objects.equals(region, address.region) &&
                Objects.equals(city, address.city) &&
                Objects.equals(district, address.district) &&
                Objects.equals(street, address.street);
    }

    // Getter and Setter methods...

    /**
     * Gets the title of the address.
     *
     * @return The title of the address.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the address.
     *
     * @param title The new title for the address.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the postal code of the address.
     *
     * @return The postal code of the address.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code of the address.
     *
     * @param postalCode The new postal code for the address.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the country of the address.
     *
     * @return The country of the address.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country of the address.
     *
     * @param country The new country for the address.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the region of the address.
     *
     * @return The region of the address.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the region of the address.
     *
     * @param region The new region for the address.
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets the city of the address.
     *
     * @return The city of the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the address.
     *
     * @param city The new city for the address.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the district of the address.
     *
     * @return The district of the address.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets the district of the address.
     *
     * @param district The new district for the address.
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Gets the street of the address.
     *
     * @return The street of the address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street of the address.
     *
     * @param street The new street for the address.
     */
    public void setStreet(String street) {
        this.street = street;
    }
}

