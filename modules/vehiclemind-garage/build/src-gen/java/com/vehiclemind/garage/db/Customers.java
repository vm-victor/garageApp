/*
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * */
package com.vehiclemind.garage.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.db.annotations.HashKey;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;

@Entity
@Cacheable
@Table(name = "GARAGE_CUSTOMERS", indexes = { @Index(columnList = "name") })
public class Customers extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GARAGE_CUSTOMERS_SEQ")
	@SequenceGenerator(name = "GARAGE_CUSTOMERS_SEQ", sequenceName = "GARAGE_CUSTOMERS_SEQ", allocationSize = 1)
	private Long id;

	@NotNull
	private String name;

	@HashKey
	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	private String email;

	@Widget(massUpdate = true)
	@Size(max = 20)
	private String phone;

	@Widget(massUpdate = true)
	@Size(max = 20)
	private String adress;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Devices> devices;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public Customers() {
	}

	public Customers(String name) {
		this.name = name;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public List<Devices> getDevices() {
		return devices;
	}

	public void setDevices(List<Devices> devices) {
		this.devices = devices;
	}

	/**
	 * Add the given {@link Devices} item to the {@code devices}.
	 *
	 * <p>
	 * It sets {@code item.customer = this} to ensure the proper relationship.
	 * </p>
	 *
	 * @param item
	 *            the item to add
	 */
	public void addDevice(Devices item) {
		if (getDevices() == null) {
			setDevices(new ArrayList<>());
		}
		getDevices().add(item);
		item.setCustomer(this);
	}

	/**
	 * Remove the given {@link Devices} item from the {@code devices}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeDevice(Devices item) {
		if (getDevices() == null) {
			return;
		}
		getDevices().remove(item);
	}

	/**
	 * Clear the {@code devices} collection.
	 *
	 * <p>
	 * If you have to query {@link Devices} records in same transaction, make
	 * sure to call {@link javax.persistence.EntityManager#flush() } to avoid
	 * unexpected errors.
	 * </p>
	 */
	public void clearDevices() {
		if (getDevices() != null) {
			getDevices().clear();
		}
	}

	public String getAttrs() {
		return attrs;
	}

	public void setAttrs(String attrs) {
		this.attrs = attrs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (!(obj instanceof Customers)) return false;

		final Customers other = (Customers) obj;
		if (this.getId() != null || other.getId() != null) {
			return Objects.equals(this.getId(), other.getId());
		}

		if (!Objects.equals(getEmail(), other.getEmail())) return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(-679437259, this.getEmail());
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", getId())
			.add("name", getName())
			.add("email", getEmail())
			.add("phone", getPhone())
			.add("adress", getAdress())
			.omitNullValues()
			.toString();
	}
}
