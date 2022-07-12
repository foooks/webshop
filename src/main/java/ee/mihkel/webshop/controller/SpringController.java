package ee.mihkel.webshop.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import static java.util.Arrays.*;

@RestController

public class SpringController {
    List<String> autod = new ArrayList<>(Arrays.asList("Audi", "Bmv"));


    @PostMapping("lisa-auto/{uusAuto}")
    public List<String> lisaAuto(@PathVariable String uusAuto) {
        autod.add(uusAuto);
        return autod;
    }
    @DeleteMapping ("kustuta-auto/{j2rjekorraNumber}")
    public List<String> lisaAuto(@PathVariable int j2rjekorraNumber) {
        autod.remove(j2rjekorraNumber);
        return autod;
    }



    @GetMapping ("tere")
    public  String ytleTere(){
        return "Tere";
    }


        @GetMapping ("nimi/{sissestatudNimi}") //localhist/nimi/Kaarel (N.t.)
        public  String ytleTereNimele(@PathVariable String sissestatudNimi){
            return "Tere"+ sissestatudNimi;
        }
    @GetMapping ("liisad/{nr1}/{nr2}") //localhist/nimi/Kaarel (N.t.)
    public int liida (@PathVariable int nr1, @PathVariable int nr2){
        return nr1 + nr2;
    }

}
