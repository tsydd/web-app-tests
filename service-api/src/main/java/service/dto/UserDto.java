package service.dto;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
public class UserDto extends LongIdDto {

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
