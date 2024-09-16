package app.Security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Register {
    private String name;
    private String email;
    private String pw;
    private float price;

    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pw='" + pw + '\'' +
                ", price=" + price +
                '}';
    }
}
