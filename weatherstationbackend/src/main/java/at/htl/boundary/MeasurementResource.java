package at.htl.boundary;

import at.htl.model.Measurement;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.Collections;
import java.util.List;

@ResourceProperties(path = "measurements")
public interface MeasurementResource extends PanacheEntityResource<Measurement, Long> {

    @GET
    @Path("/sensor/{sensorId}")
    default List<Measurement> getMeasurementsBySensorId(@PathParam("sensorId") Long sensorId) {
        return Measurement.find("sensor.id = :sensorId", Collections.singletonMap("sensorId", sensorId)).list();
    }
}
