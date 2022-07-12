package ee.mihkel.webshop.controller;

import ee.mihkel.webshop.model.ParcelMachine;
import ee.mihkel.webshop.service.ParcelMachineService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("http://localhost:3000")
@RestController
@Log4j2
public class ParceMachineController {
    @Autowired
    ParcelMachineService parcelMachineService;

 //   @Operation(description = "Saa Ommniva ja SmartPost pakiautomaadid")
///    @Operation(summary = "aaaasssdddd")
    @GetMapping("parcel-machines/{country}")
    public ParcelMachine getParcelMachines(@PathVariable String country) throws Exception {
        log.info("tehti pakiautomaadi p2ringut");
        return parcelMachineService.getParcelMachines2(country.toUpperCase());
     }
}
