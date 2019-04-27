package hr.java.web.novak.moneyapp.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime created;
    private LocalDateTime modified;

    public boolean isNew() {
        return this.id == null;
    }

    public void updateTimeStamps() {
        modified = LocalDateTime.now();
        if (created == null) {
            created = LocalDateTime.now();
        }
    }
}
