package pl.edu.pjwstk.jaz.average;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;


@RestController
public class AverageController {

    @GetMapping("average")
    public AverageResult getAverage(@RequestParam(value = "numbers", required = false) String numbers) {

        if (numbers == null ) return new AverageResult("Please put parameters.");

        String[] num = numbers.split(",");

        double sum = 0;

        for(String i : num) sum += Integer.parseInt(i);

        BigDecimal round = new BigDecimal(sum / num.length);
        round = round.setScale(2,
                RoundingMode.HALF_UP).stripTrailingZeros();

       return new AverageResult ("Average equals: " + round);
    }
}

