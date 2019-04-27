package hr.java.web.novak.moneyapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString(exclude = "users")
public class Role extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

//    public void addUser(User user){
//        this.users.add(user);
//        user.getRoles().add(this);
//    }
//
//    public void removeUser(User user){
//        this.users.remove(user);
//        user.getRoles().remove(this);
//    }
}
