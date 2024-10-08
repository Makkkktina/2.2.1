package hiber.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    @MapsId
    @OneToOne(mappedBy = "car")
    @JoinColumn(name = "car_id")
    private User user;

    public Car() {
    }

    public Car(String model, int series, User user) {
        this.model = model;
        this.series = series;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
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
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car = (Car) o;
//        return id == car.id && series == car.series && Objects.equals(model, car.model) && Objects.equals(user, car.user);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, model, series, user);
//    }
}