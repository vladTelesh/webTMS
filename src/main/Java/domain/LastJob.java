package domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "last_job")
public class LastJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    private String job;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User_Id")
    private UserInfo user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastJob lastJob = (LastJob) o;
        return id == lastJob.id &&
                job.equals(lastJob.job) &&
                user.equals(lastJob.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, job, user);
    }
}
