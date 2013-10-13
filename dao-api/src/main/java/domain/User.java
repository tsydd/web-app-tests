package domain;

import javax.persistence.Entity;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
@Entity
public class User extends LongIdEntity {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
