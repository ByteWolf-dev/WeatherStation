package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Location extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    public Sensor sensor;

    @Column(nullable = false)
    public String name;

    public String description;
}
