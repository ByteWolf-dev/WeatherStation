package at.htl.control;

import at.htl.model.Measurement;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class MeasurementRepository implements PanacheRepository<Measurement> {

    // Custom method to find measurements by sensorId
    public List<Measurement> findBySensorId(Long sensorId) {
        return find("sensor.id", sensorId).list();  // Use the "sensor.id" to access the Sensor's ID
    }
}
