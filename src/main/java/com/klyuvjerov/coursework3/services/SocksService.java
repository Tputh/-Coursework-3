package com.klyuvjerov.coursework3.services;

import com.klyuvjerov.coursework3.model.CottonContent;
import com.klyuvjerov.coursework3.model.SockSize;
import com.klyuvjerov.coursework3.model.SocksBatch;
import com.klyuvjerov.coursework3.model.SocksColor;
import org.springframework.stereotype.Service;

@Service
public interface SocksService {
    void accept(SocksBatch socksBatch);
    int vacation(SocksBatch socksBatch);
    int getCalculate(SocksColor socksColor, SockSize sockSize, CottonContent cottonContent);
    int delete(SocksBatch socksBatch);
}
