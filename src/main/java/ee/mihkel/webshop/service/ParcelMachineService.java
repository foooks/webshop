package ee.mihkel.webshop.service;

import ee.mihkel.webshop.model.OmnivaParcelMachine;
import ee.mihkel.webshop.model.ParcelMachine;
import ee.mihkel.webshop.model.SmartPostParcelMachine;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ParcelMachineService {

    public ParcelMachine getParcelMachines2(String country) throws Exception {

    ParcelMachine parcelMachine = new ParcelMachine();
    RestTemplate restTemplate = new RestTemplate();
        log.info(restTemplate);
    parcelMachine.setOmnivaParcelMachines(fetchOmnivaParcelMachines(restTemplate, country));
    if (country.equals("EE")) {
        parcelMachine.setSmartPostParcelMachines(fetchSmartPostParcelMachines((restTemplate)));
    }else{
        parcelMachine.setSmartPostParcelMachines(new ArrayList<>());
    }

        fetchOmnivaParcelMachines(restTemplate, country);
        fetchSmartPostParcelMachines(restTemplate);
        return parcelMachine;
}


    private List<OmnivaParcelMachine>fetchOmnivaParcelMachines(RestTemplate restTemplate, String country) throws Exception {
        String omnivaParcelMachinesUrl = "https://www.omniva.ee/locations.json";
        ResponseEntity<OmnivaParcelMachine[]> omnivaResponse = restTemplate.exchange(omnivaParcelMachinesUrl, HttpMethod.GET, null, OmnivaParcelMachine[].class);

        if(omnivaResponse.getBody()!=null)

        {
            OmnivaParcelMachine[] omnivaParcelMachines = omnivaResponse.getBody();
            List<OmnivaParcelMachine> omnivaParcelMachineList = Arrays.asList(omnivaParcelMachines);
            omnivaParcelMachineList = omnivaParcelMachineList.stream().filter(e ->e.a0_NAME.equals(country)).collect(Collectors.toList());
            //return Arrays.asList(omnivaParcelMachines);
            //   parcelMachine.setOmnivaParcelMachines(Arrays.asList(omnivaParcelMachines));

            return omnivaParcelMachineList;
        }else

        {
            log.error("error omniva v6tmisel");
            throw new Exception();
        }
    }

    private List<SmartPostParcelMachine> fetchSmartPostParcelMachines(RestTemplate restTemplate) throws Exception {
        String smartPostParcelMachinesUrl = "https://pakiautomaadid-default-rtdb.europe-west1.firebasedatabase.app/smartpost.json";
        ResponseEntity<SmartPostParcelMachine[]> smartPostResponse = restTemplate.exchange(smartPostParcelMachinesUrl, HttpMethod.GET, null, SmartPostParcelMachine[].class);


        if(smartPostResponse.getBody()!=null)

    {
        SmartPostParcelMachine[] smartPostParcelMachines = smartPostResponse.getBody();
        return Arrays.asList(smartPostParcelMachines);
     //   parcelMachine.setSmartPostParcelMachines(Arrays.asList(smartPostParcelMachines));

    }else

    {
        throw new Exception();
    }
    }

}
