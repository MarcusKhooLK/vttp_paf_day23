package vttp.paf.day23.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.paf.day23.model.Contact;

@Repository
public class ContactRepository {
    
    @Autowired
    private JdbcTemplate template;

    public boolean addContact(final Contact c) {

        int added = template.update(Queries.SQL_INSERT_CONTACT,
                    c.getEmail(), c.getName(), c.getPhone(), c.getDob(), c.getStatus(), c.getPassphrase());

        return added > 0;

    }

    public boolean removeContact(final Contact c) {
        int removed = template.update(Queries.SQL_DELETE_CONTACT_BY_PRI_KEY, c.getEmail());

        return removed > 0;
    }

    public boolean contactExists(final String email) {
        final SqlRowSet result = template.queryForRowSet(Queries.SQL_SELECT_CONTACT_BY_PRI_KEY,
            email);
        return result.next();
    }

    public List<Contact> getAllContacts() {
        final SqlRowSet result = template.queryForRowSet(Queries.SQL_SELECT_ALL);

        List<Contact> contacts = new ArrayList<>();
        while(result.next()) {
            Contact c = new Contact();
            c.setEmail(result.getString("email"));
            c.setName(result.getString("name"));
            c.setPhone(result.getString("phone"));
            c.setDob(result.getDate("dob"));
            c.setStatus(result.getString("status"));

            contacts.add(c);
        }

        return contacts;
    }
}
