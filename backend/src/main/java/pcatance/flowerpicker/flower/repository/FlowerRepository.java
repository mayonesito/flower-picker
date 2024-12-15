package pcatance.flowerpicker.flower.repository;

import pcatance.flowerpicker.errorhandling.checked.FlowerException;
import pcatance.flowerpicker.flower.control.FlowerModel;

import java.util.List;
import java.util.UUID;

public interface FlowerRepository {

    List<FlowerModel> getFlowers() throws FlowerException;

    FlowerModel getFlower(final UUID id) throws FlowerException ;
}
