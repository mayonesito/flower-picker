package pcatance.flowerpicker.flower.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pcatance.flowerpicker.flower.control.FlowerType;

import java.util.UUID;

@Table(name = "FLOWER")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FlowerEntity {
    @Id
    @Column( name = "ID")
    private UUID id;

    @Column( name = "TYPE")
    @Enumerated(EnumType.STRING)
    private FlowerType type;

    @Column( name = "SEPAL_LENGTH")
    private Long sepalLength;

    @Column( name = "SEPAL_WIDTH")
    private Long sepalWidth;

    @Column( name = "PETAL_LENGTH")
    private Long petalLength;

    @Column( name = "PETAL_WIDTH")
    private Long petalWidth;
}
