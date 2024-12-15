package pcatance.flowerpicker.flower.control;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import pcatance.flowerpicker.errorhandling.checked.FlowerException;
import pcatance.flowerpicker.flower.repository.FlowerCacheRepository;
import pcatance.flowerpicker.flower.repository.FlowerDbRepository;
import pcatance.flowerpicker.flower.repository.FlowerRepository;

import java.util.List;
import java.util.UUID;

@RequestScoped
public class FlowerService {

    @Inject
    FlowerCacheRepository flowerCacheRepository;

    @Inject
    FlowerDbRepository flowerDbRepository;

    public List<FlowerModel> getFlowers(final boolean useCache) throws FlowerException {
        return this.select(useCache).getFlowers();
    }

    public FlowerModel getFlower(final UUID id, final boolean useCache) throws FlowerException {
        return this.select(useCache).getFlower(id);
    }

    private FlowerRepository select(final boolean useCache) {
        return useCache ? flowerCacheRepository : flowerDbRepository;
    }
}
