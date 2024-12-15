package pcatance.flowerpicker.flower.control;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FlowerModel {
    private UUID id;
    private FlowerType type;
    private Long sepalLength;
    private Long sepalWidth;
    private Long petalLength;
    private Long petalWidth;
}
