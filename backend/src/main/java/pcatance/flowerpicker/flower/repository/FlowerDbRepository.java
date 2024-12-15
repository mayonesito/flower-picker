package pcatance.flowerpicker.flower.repository;

import jakarta.enterprise.context.RequestScoped;
import lombok.extern.slf4j.Slf4j;
import pcatance.flowerpicker.errorhandling.checked.FlowerException;
import pcatance.flowerpicker.flower.control.FlowerModel;
import pcatance.flowerpicker.flower.control.FlowerType;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;
import static pcatance.flowerpicker.errorhandling.exceptioninfo.ExceptionInfo.CANNOT_FETCH_FLOWERS;
import static pcatance.flowerpicker.util.CollectionUtils.isNullOrEmpty;

@RequestScoped
@Slf4j
public class FlowerDbRepository implements FlowerRepository {

    @Override
    public List<FlowerModel> getFlowers() throws FlowerException {

        final var flowers = List.of(getMeAFlower());

        if (isNullOrEmpty(flowers)) {
            throw new FlowerException(
                    CANNOT_FETCH_FLOWERS,
                    "Could not retrieve flowers from database");
        }

        return flowers
                .stream()
                .map(FlowerDbRepository::mapFlowerEntityToModel)
                .toList();
    }

    @Override
    public FlowerModel getFlower(final UUID id) throws FlowerException {
        final var flower = getMeAFlower();

        if (isNull(flower)) {
            throw new FlowerException(CANNOT_FETCH_FLOWERS,
                    "Could not retrieve flower from database");
        }

        return mapFlowerEntityToModel(getMeAFlower());
    }

    // TODO [pcatance, 15.12.2024]: Remove hardcoded flower and add database support
    @Deprecated(since = "0.0.1")
    private static FlowerEntity getMeAFlower() {
        return FlowerEntity
                .builder()
                .id(UUID.randomUUID())
                .type(FlowerType.SETOSA)
                .sepalLength(51L)
                .sepalWidth(35L)
                .petalLength(14L)
                .petalWidth(2L)
                .build();

    }

    private static FlowerModel mapFlowerEntityToModel(final FlowerEntity flowerEntity) {
        return FlowerModel
                .builder()
                .id(flowerEntity.getId())
                .type(flowerEntity.getType())
                .sepalLength(flowerEntity.getSepalLength())
                .sepalWidth(flowerEntity.getSepalWidth())
                .petalLength(flowerEntity.getPetalLength())
                .petalWidth(flowerEntity.getPetalWidth())
                .build();
    }

    private static FlowerEntity mapFlowerModelToEntity(final FlowerModel flowerModel) {
        return FlowerEntity
                .builder()
                .id(flowerModel.getId())
                .type(flowerModel.getType())
                .sepalLength(flowerModel.getSepalLength())
                .sepalWidth(flowerModel.getSepalWidth())
                .petalLength(flowerModel.getPetalLength())
                .petalWidth(flowerModel.getPetalWidth())
                .build();
    }
}
