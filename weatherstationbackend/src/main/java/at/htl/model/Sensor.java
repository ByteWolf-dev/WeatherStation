package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sensor extends PanacheEntity {
    @Column(nullable = false)
    public String type;

    public String model;

    public LocalDateTime installationDate;

    public boolean status;
}
