package pcatance.flowerpicker.flower.control;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum FlowerType {
    SETOSA("Iris-setosa"),
    VERSICOLOR("Iris-versicolor"),
    VIRGINICA("Iris-setosa");

    private final String type;

    FlowerType(String type) {
        this.type = type;
    }
}
