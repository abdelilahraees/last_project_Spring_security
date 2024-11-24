package app.Security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Register {
    private String name;
    private String firstname;
    private String lasttname;
    private String email;
    private String pw;
}
