package currencyExchangeRootMicroservice.currency_exchange_service.currency_exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        if(currencyExchange == null){
            throw new RuntimeException("Unable to find the Data for " + from + " to " + to);
        }

        System.out.println("Retrieved CurrencyExchange: " + currencyExchange);
        System.out.println("Multiple is" + currencyExchange.getConversion());



        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        currencyExchangeRepository.findAll();

        return currencyExchange;

    }
}
