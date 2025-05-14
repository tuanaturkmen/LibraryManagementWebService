/* package com.demo.is550.lms_web_service.repository;

import com.demo.is550.lms_web_service.CurrencyExistsException;
import com.demo.is550.lms_web_service.CurrencyNotFoundException;
import com.soap.is550.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CurrencyRepository {

    private static final ArrayList<Currency> currencies = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Currency usd = new Currency();
        usd.setName("US Dollar");
        usd.setShortName("USD");
        usd.setCurrentValue(30);
        usd.setAskValue(10);
        usd.setBidValue(15);

        Currency eur = new Currency();
        eur.setName("Euro");
        eur.setShortName("EUR");
        eur.setCurrentValue(35.56);
        eur.setAskValue(31.2);
        eur.setBidValue(12.56);

        Currency jpy = new Currency();
        jpy.setName("Japanese yen");
        jpy.setShortName("JPY");
        jpy.setCurrentValue(12);
        jpy.setAskValue(12);
        jpy.setBidValue(12);

        currencies.addAll(Arrays.asList(usd, eur, jpy));
    }

    public Currency findCurrency(String name) {
        return currencies.stream().filter(c -> c.getShortName().equals(name)).findFirst().orElse(null);
    }

    public List<Currency> findAll() {
        return currencies;
    }

    public Currency save(Currency currency) throws CurrencyExistsException {

        if (Objects.isNull(findCurrency(currency.getShortName()))){
            currencies.add(currency);
            return findCurrency(currency.getShortName());
        }
        throw new CurrencyExistsException("Currency cannot be added because it exists");
    }

    public Currency findCurrencyWithFault(String name) throws CurrencyNotFoundException {
        Currency currency = findCurrency(name);
        if (Objects.isNull(currency)) {
            throw  new CurrencyNotFoundException("Invalid currency name");
        }else{
            return currency;
        }
    }

}
 */