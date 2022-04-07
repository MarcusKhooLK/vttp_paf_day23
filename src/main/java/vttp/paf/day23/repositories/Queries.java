package vttp.paf.day23.repositories;

public interface Queries {
    public static final String SQL_INSERT_CONTACT = "insert into bff (email, name, phone, dob, status, pass_phrase) values (?, ?, ?, ?, ?, sha1(?));";
    public static final String SQL_SELECT_CONTACT_BY_PRI_KEY = "select email from bff where email = ?;";
    public static final String SQL_SELECT_ALL = "select * from bff;";
    public static final String SQL_DELETE_CONTACT_BY_PRI_KEY = "delete from bff where email = ?";
}
