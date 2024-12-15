package pcatance.flowerpicker.flower.boundary;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pcatance.flowerpicker.errorhandling.checked.FlowerException;
import pcatance.flowerpicker.flower.control.FlowerService;

import java.util.UUID;

import static pcatance.flowerpicker.constants.Paths.ALL_PATH;
import static pcatance.flowerpicker.constants.Paths.FLOWER_PATH;
import static pcatance.flowerpicker.constants.Paths.INTERNAL_PATH;
import static pcatance.flowerpicker.constants.QueryParams.CACHE_PARAM;
import static pcatance.flowerpicker.constants.QueryParams.ID_PARAM;


@RequestScoped
@Path(INTERNAL_PATH + FLOWER_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class FlowerResource {

    @Inject
    FlowerService flowerService;

    @GET
    @Path(ALL_PATH)
    public Response getFlowers(@QueryParam(CACHE_PARAM) final boolean useCache) {
        try {
            final var flowers = flowerService.getFlowers(useCache);
            return Response.ok(flowers).build();

        } catch (FlowerException ex) {
            return Response.status(ex.getStatus()).entity(ex.getMessage()).build();

        }
    }

    @GET
    @Path("/{" + ID_PARAM + "}")
    public Response getFlowers(@QueryParam(ID_PARAM) final UUID id,
                               @QueryParam(CACHE_PARAM) final boolean useCache) {
        try {
            final var flower = flowerService.getFlower(id, useCache);
            return Response.ok(flower).build();

        } catch (FlowerException ex) {
            return Response.status(ex.getStatus()).entity(ex.getMessage()).build();

        }
    }
}
