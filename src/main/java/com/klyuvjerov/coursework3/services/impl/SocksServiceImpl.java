package com.klyuvjerov.coursework3.services.impl;

import com.klyuvjerov.coursework3.exception.ValidationException;
import com.klyuvjerov.coursework3.model.*;
import com.klyuvjerov.coursework3.repository.SocksRepository;
import com.klyuvjerov.coursework3.services.SocksService;
import com.klyuvjerov.coursework3.services.ValidationService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SocksServiceImpl implements SocksService {

    private final SocksRepository socksRepository;
    private final ValidationService validationService;


    @Override
    public void accept(SocksBatch socksBatch) {
        checkSocksBatch(socksBatch);

      socksRepository.save(socksBatch);
    }

    @Override
    public int vacation(SocksBatch socksBatch) {
        checkSocksBatch(socksBatch);
        return socksRepository.remove(socksBatch);
    }

    @Override
    public int getCalculate(SocksColor socksColor, SockSize sockSize, CottonContent cottonContent) {
        if (!validationService.validate(socksColor, sockSize, cottonContent)) {
            throw new ValidationException();
        }
        Map<Socks, Integer> socksMap = socksRepository.getAll();

        for (Map.Entry<Socks, Integer> socksIntegerEntry : socksMap.entrySet()) {
            Socks socks = socksIntegerEntry.getKey();

            if (socks.getSocksColor().equals(socksColor) &&
            socks.getSockSize().equals(sockSize) &&
            socks.getCottonContent().equals(cottonContent)) {
                return socksIntegerEntry.getValue();
            }
        }
        return 0;
    }

    @Override
    public int delete(SocksBatch socksBatch) {
        checkSocksBatch(socksBatch);
        return  socksRepository.remove(socksBatch);
    }

    private void checkSocksBatch(SocksBatch socksBatch) {
        if (!validationService.validate(socksBatch)) {
            throw new ValidationException();
        }
    }
}
