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
package com.axelor.contact.db.repo;

import com.axelor.contact.db.Contact;
import com.axelor.db.JpaRepository;
import com.axelor.db.Query;

public class ContactRepository extends JpaRepository<Contact> {

	public ContactRepository() {
		super(Contact.class);
	}

	public Contact findByName(String fullName) {
		return Query.of(Contact.class)
				.filter("self.fullName = :fullName")
				.bind("fullName", fullName)
				.fetchOne();
	}

	public Contact findByEmail(String email) {
		return Query.of(Contact.class)
				.filter("self.email = :email")
				.bind("email", email)
				.fetchOne();
	}

}

