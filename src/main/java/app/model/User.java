package app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String fullname;
    @JsonManagedReference
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private List<Role> roles;

    public User( String username, String fullname ,String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }
}