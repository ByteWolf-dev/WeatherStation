package at.htl.boundary;

import at.htl.control.LocationRepository;
import at.htl.model.Location;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "locations")
public interface LocationResource extends PanacheRepositoryResource<LocationRepository, Location, Long> {
}
