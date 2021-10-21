package sos.siho.readdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sos.siho.readdata.dto.SalesDTO;
import sos.siho.readdata.model.Currency;

import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, String> {

    @Query(name = "findAllSos",nativeQuery = true)
    List<SalesDTO> findAllSales();
}
