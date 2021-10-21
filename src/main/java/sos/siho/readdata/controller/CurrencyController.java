package sos.siho.readdata.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sos.siho.readdata.dto.SalesDTO;
import sos.siho.readdata.model.Currency;
import sos.siho.readdata.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/currency")
@AllArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping()
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        return new ResponseEntity<>(currencyService.getAllCurencies(), HttpStatus.OK);
    }

    @GetMapping("/sales")
    public ResponseEntity<List<SalesDTO>> getAllSales() {
        return new ResponseEntity<>(currencyService.getAllSales(), HttpStatus.OK);
    }

}
