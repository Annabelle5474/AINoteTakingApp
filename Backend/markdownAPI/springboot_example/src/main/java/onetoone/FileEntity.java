package onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import io.swagger.v3.oas.annotations.media.Schema;
import onetoone.Access.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Schema(description = "Represents a table that has owners and the files they own.")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "files", cascade = CascadeType.ALL)
    private Set<AccessEntity> accessEntities = new HashSet<>();

    private Long userID;

    private String fileName;

    public FileEntity() {}

    public FileEntity(String fileName, Long userID)
    {
        this.fileName = fileName;
        this.userID = userID;
    }

    public Long getId(){
        return userID;
    }

    public Long getfileId(){
        return id;
    }

    public String getName(){
        return fileName;
    }

    public Set<AccessEntity> getAccessEntities() {
        return accessEntities;
    }

    public void addAccessEntity(AccessEntity accessEntity) {
        this.accessEntities.add(accessEntity);
        accessEntity.getFiles().add(this);
    }

}
