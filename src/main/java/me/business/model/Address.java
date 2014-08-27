package me.business.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

	@ManyToOne(targetEntity = Country.class)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", insertable = true, nullable = true, unique = false, updatable = true)
	private Country country;

	@OneToMany(targetEntity = PersonAddress.class, mappedBy = "addressId")
	private Collection<PersonAddress> personAddressCollection;

	@Column(name = "STREET", length = 100)
	private String street;

	@Column(name = "POST_CODE", length = 50)
	private String postCode;

	@Column(name = "ADDRESS_TYPE", length = 50)
	private String addressType;

	@Column(name = "ADDRESS_ID", nullable = false, precision = 20)
	@Id
	@SequenceGenerator(name = "AddressSeq", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AddressSeq")
	private Long addressId;

	@Column(name = "CITY", length = 100)
	private String city;

	@Column(name = "CREATED_ON", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "MODIFIED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;

	@Column(name = "DISTRICT_NAME", length = 100)
	private String districtName;

	public Address() {

	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public Long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Collection<PersonAddress> getPersonAddressCollection() {
		return this.personAddressCollection;
	}

	public void setPersonAddressCollection(Collection<PersonAddress> personAddressCollection) {
		this.personAddressCollection = personAddressCollection;
	}

}
