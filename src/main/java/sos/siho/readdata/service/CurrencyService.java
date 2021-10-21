package sos.siho.readdata.service;

import sos.siho.readdata.dto.SalesDTO;
import sos.siho.readdata.model.Currency;

import java.util.List;

public interface CurrencyService {

    public List<Currency> getAllCurencies();
    public List<SalesDTO> getAllSales();

}
