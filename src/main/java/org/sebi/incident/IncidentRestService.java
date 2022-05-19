package org.sebi.incident;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@RegisterRestClient(configKey="incident-api")
@Path("rest")
public interface IncidentRestService {
    @GET
    @Path("/incidents")
    List<Incident> getIncidents(@QueryParam("api_key") String apiKey);
}
