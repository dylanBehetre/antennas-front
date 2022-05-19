package org.sebi.incident;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("rest")
public class IncidentResource {
    @RestClient IncidentRestService incidentRestClient;
    @ConfigProperty(name = "APIKEY", defaultValue = "PaasHat") String apiKey;

    @GET()
    @Path("incidents")
    @Fallback(fallbackMethod = "fallbackGetIncidents")
    public List<Incident> getIncidents() {
        return incidentRestClient.getIncidents(apiKey);
    }
    
    public List<Incident> fallbackGetIncidents() {
        return List.of(
            new Incident().setDate(new Date())
                       .setDescription("fallback")
                       .setStatus(false));
    }
}

