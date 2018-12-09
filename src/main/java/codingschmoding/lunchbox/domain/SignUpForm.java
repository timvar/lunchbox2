package codingschmoding.lunchbox.domain;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignUpForm {
    @NotNull
    @Size(min=4, max=30, message = "* username must have 4-30 characters")
    private String username = "";

    @NotNull
    @Size(min=4, max=30, message = "* password must have 4-30 characters")
    private String password = "";

    @NotNull
    @Size(min=4, max=30, message = "* password must have 4-30 characters")
    private String passwordCheck = "";


    private String role = "USER";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
    
}