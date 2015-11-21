package org.koushik.javabrains.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.Type; // for @CollectionId

/**
 * Test Hibernate model class, There are two distinct ways for hibernate to
 * define the columns of a table. 1 is with HBM configuration files, 2 with
 * annotations. We well demonstrate annotations. So, basically the annotations
 * labels with an @ symbol in from of them are directives to tell hibernate what
 * the table, and column names are and a few other things to indicate
 * relationships to other tables... Annotation Notes:
 * 
 * @Id creates a primary key: natural key (like email address, loginId),
 *     seragate key (like serial number or Id) have no business use and
 *     hibernate can populate the values on insert.
 * @GeneratedValue(strategy = GenerationType.AUTO) generates the primary key
 *                          value automatically on insert.
 * @Basic not required, hibernate will default without it.
 * @Transient tells hibernate to NOT consider this member var persistent.
 * @Temporal(TemporalType.DATE) Takes the timestamp off the date.
 * @Lob can increase the default varchar of 255 characters
 * @Column you can name the column of the database, different than the member
 *         var name
 * @Embedded place a value object inside this object on table create.
 * @AttributeOverride allows to change the field names in the embedded object.
 * @ElementCollection tells hibernate to persist the collection as a separate
 *                    table. Not that indifferent than a OneToMany relationship.
 * @JoinTable allows to name the table of the collection, and the name of the
 *            joined column in that collection table
 * @GenericGenerator
 * @CollectionId forces the collection to have a primary key - Hibernate is the
 *               implementor. This required three attributes, the column name,
 *               the generator and the type
 * @ManyToMany will create a mapping table that contains id's from each of two
 *             related tables, but with an inverse relationship, hibernate will
 *             create two mapping tables, but there is a way to tell hibernate
 *             to create just one. mappedBy attribute will prevent this and
 *             tells hibernate exaclty what field in the other table to do the
 *             mapping.
 * @OneToMany creates a mapping table similar to ManyToMany But we don't have to
 *            have this mapping. @OneToMany(mappedBy="user") in place
 *            of @JoinTable(name="USER_ACCOUNT",
 *            joinColumns=@JoinColumn(name="USER_ID"), will eliminate mapping
 *            and just put the foreign key in the account table
 * @OneToOne creates a foreign key in the user object pointing to the table that
 *           contains the relationship to the other table.
 * @NotFound Tells hibernate to ignore a not found @OneTo... (cascade =
 *           CascadeType.ALL) Tells hibernate to save all the entities in the
 *           collection even if they hvae not been saved manually
 * @Inheritance used for inheritance tables, prob won't use. See Vehicle2 class
 * @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) strategy is key in
 *             inheritance, but I doubt we will use database relation
 *              table set up,
 * @DiscriminatorColumn again for inheritance, prob won't use, See Vehicle2
 *                      class
 * @NamedQuery(name="UserDetails2.byId", query=
 *           "from UserDetails2 where userId = ?") or create a native SQL 
 *           query as a named query. 8 @NamedNativeQuery(name=
 *           "UserDetails.byName", query="select * from UserDetails2 where userName = ?"
 *          , resultClass=UserDetails2.class )
 * 
 */

// @Entity tells hibernate to use this class to create the table.

@Entity
@Table(name = "USER_DETAIL")
public class UserDetails {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Basic
	@Transient
	private String noPersistantField = "Not to be placed in DB";

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Embedded
	private Department department;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMAIL_ID")
	private Email email;

	@OneToMany(mappedBy = "user") // prevents mapping table
	private Collection<Account> accounts = new ArrayList<Account>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID") , inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID") )
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

	@Temporal(TemporalType.DATE)
	@Column(name = "JOINED_DATE") // gets rid of timestamp, keeps the date
	private Date joinedDate;

	@ElementCollection // JPA spec
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID") )
	@GenericGenerator(name = "hilo-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long") )
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

	// Getter and Setters below

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = (ArrayList<Address>) listOfAddresses;
	}

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getNoPersistantField() {
		return noPersistantField;
	}

	public void setNoPersistantField(String noPersistantField) {
		this.noPersistantField = noPersistantField;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}

}
