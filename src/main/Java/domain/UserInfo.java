package domain;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Second_Name")
    private String secondName;
    @Column(name = "Gender")
    private String gender;

/*    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LastJob> jobs = new ArrayList<>();*/

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Login login;

    @ManyToMany(mappedBy = "userInfoList",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Role> roles = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

/*    public List<LastJob> getJobs() {
        return jobs;
    }

    public void setJobs(List<LastJob> jobs) {
        this.jobs = jobs;
    }*/

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return id == userInfo.id &&
                name.equals(userInfo.name) &&
                secondName.equals(userInfo.secondName) &&
                gender.equals(userInfo.gender) &&
              //  jobs.equals(userInfo.jobs) &&
                login.equals(userInfo.login) &&
                roles.equals(userInfo.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, secondName, gender/*, jobs*/, login, roles);
    }
}
