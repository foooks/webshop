package ee.mihkel.webshop.model;

import lombok.Data;

import java.util.List;

@Data
public class ParcelMachine {
    List<OmnivaParcelMachine> omnivaParcelMachines;
    List<SmartPostParcelMachine> smartPostParcelMachines;
}
