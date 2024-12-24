package at.htl.boundary;

import at.htl.control.SensorRepository;
import at.htl.model.Sensor;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "sensors")
public interface SensorResource extends PanacheRepositoryResource<SensorRepository, Sensor, Long> {
}
