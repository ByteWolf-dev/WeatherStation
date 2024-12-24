package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Measurement extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    public Sensor sensor;

    public LocalDateTime timestamp;

    public float temperature;

    public float humidity;

    public float pressure;
}
