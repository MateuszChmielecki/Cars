package pl.mateusz.Cars.entity;

import javax.persistence.*;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Group group;
    private String countryOfOrgins;

    public Brand(Long id, String name, Group group, String countryOfOrgins) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.countryOfOrgins = countryOfOrgins;
    }

    public Brand() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getCountryOfOrgins() {
        return countryOfOrgins;
    }

    public void setCountryOfOrgins(String countryOfOrgins) {
        this.countryOfOrgins = countryOfOrgins;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group=" + group +
                ", countryOfOrgins='" + countryOfOrgins + '\'' +
                '}';
    }
}
