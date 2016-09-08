package com.chyld.repositories;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IDeviceRepository extends PagingAndSortingRepository<Device, Integer> {
    @Query("select r from Run r join r.device d where d.serial = :serial and r.stop is NULL")
    public Run findActiveRunByDeviceSerialNumber(@Param("serial") String serial);
    public Device findBySerial(String serial);
}
