package web.dto;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
public class LoginRequestDto {

    private String userName;
    private String password;
    private Boolean remember;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }
}
