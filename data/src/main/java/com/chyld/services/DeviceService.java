package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.repositories.IDeviceRepository;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DeviceService {
    private IDeviceRepository deviceRepository;
    private IRunRepository runRepository;

    @Autowired
    public void setDeviceRepository(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Autowired
    public void setRunRepository(IRunRepository runRepository) {
        this.runRepository = runRepository;
    }

    public Run startRun(String serial){
        Run r = this.deviceRepository.findActiveRunByDeviceSerialNumber(serial);

        if (r == null){
            Device d = this.deviceRepository.findBySerial(serial);
            r = new Run();
            r.setStart(new Date());
            r.setDevice(d);
            d.getRuns().add(r);
            this.deviceRepository.save(d);
        }

        return r;
    }

    public Run stopRun(String serial){
        Run r = this.deviceRepository.findActiveRunByDeviceSerialNumber(serial);
        r.setStop(new Date());
        return this.runRepository.save(r);
    }

    public Position addPosition(String serial, Position position){
        Run r = this.deviceRepository.findActiveRunByDeviceSerialNumber(serial);
        if (r == null){
            return null;
        }
        position.setRun(r);
        r.getPositions().add(position);
        this.runRepository.save(r);
        return position;
    }
}
