package pcatance.flowerpicker.flower.repository;

import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import pcatance.flowerpicker.errorhandling.checked.FlowerException;
import pcatance.flowerpicker.flower.control.FlowerModel;

import java.util.List;
import java.util.UUID;

@RequestScoped
public class FlowerCacheRepository implements FlowerRepository {

    @Inject
    FlowerDbRepository flowerDbRepository;

    @Override
    @CacheResult(cacheName = "flower-get-all")
    public List<FlowerModel> getFlowers() throws FlowerException {
        return this.flowerDbRepository.getFlowers();
    }

    @Override
    @CacheResult(cacheName = "flower-get-single")
    public FlowerModel getFlower(final UUID id) throws FlowerException {
        return this.flowerDbRepository.getFlower(id);
    }
}
