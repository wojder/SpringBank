package pl.training.domain;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = 5024852160469560479L;

    private Long id;
    private String street;
    private String house;
    private String zipcode;
    private String city;
    private AddressType addressType;
    private boolean active;

    public Address() {
    }

    public Address(String street, String house, String zipcode, String city, AddressType addressType) {
        this.street = street;
        this.house = house;
        this.zipcode = zipcode;
        this.city = city;
        this.addressType = addressType;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (active ? 1231 : 1237);
        result = prime * result + ((addressType == null) ? 0 : addressType.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((house == null) ? 0 : house.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Address other = (Address) obj;
        if (active != other.active) {
            return false;
        }
        if (addressType != other.addressType) {
            return false;
        }
        if (city == null) {
            if (other.city != null) {
                return false;
            }
        } else if (!city.equals(other.city)) {
            return false;
        }
        if (house == null) {
            if (other.house != null) {
                return false;
            }
        } else if (!house.equals(other.house)) {
            return false;
        }
        if (street == null) {
            if (other.street != null) {
                return false;
            }
        } else if (!street.equals(other.street)) {
            return false;
        }
        if (zipcode == null) {
            if (other.zipcode != null) {
                return false;
            }
        } else if (!zipcode.equals(other.zipcode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", street=" + street + ", house=" + house + ", zipcode=" + zipcode + ", city="
                + city + ", addressType=" + addressType + ", active=" + active + "]";
    }

}
