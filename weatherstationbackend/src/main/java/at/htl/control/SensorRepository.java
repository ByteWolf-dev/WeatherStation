package at.htl.control;

import at.htl.model.Sensor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SensorRepository implements PanacheRepository<Sensor> {
}
