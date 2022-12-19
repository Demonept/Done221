package hiber.model;

import javax.persistence.*;
@Entity
@Table(name = "schema_name.car")
public class Car {
    @Id
    private Long id;
    @Column
    private String model;
    @Column
    private int serial;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    public Car() {
    }

    public Car(String model, int serial) {
        this.model = model;
        this.serial = serial;
    }

    public Car(String model, int serial, User user) {
        this.model = model;
        this.serial = serial;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getSerial() {
        return serial;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serial=" + serial +
                '}';
    }
}
