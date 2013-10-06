package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
* @author Dmitry Tsydzik
* @since Date: 02.10.13
*/
@Entity
public class TestEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    private String name;

    public TestEntity() {
    }

    public TestEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
