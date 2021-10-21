package sos.siho.readdata.service;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sos.siho.readdata.dto.SalesDTO;
import sos.siho.readdata.model.Currency;
import sos.siho.readdata.repository.CurrencyRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final RedisValueCache redisValueCache;

    @Override
    public List<Currency> getAllCurencies() {
        return currencyRepository.findAll();
    }

    @Override
    public List<SalesDTO> getAllSales() {
        List<SalesDTO> allSales = currencyRepository.findAllSales();
        Gson gson = new Gson();
        redisValueCache.cache("sales_dto",gson.toJson(allSales));
        return allSales;
    }
}
