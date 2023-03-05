package com.klyuvjerov.coursework3.services;

import com.klyuvjerov.coursework3.model.CottonContent;
import com.klyuvjerov.coursework3.model.SockSize;
import com.klyuvjerov.coursework3.model.SocksBatch;
import com.klyuvjerov.coursework3.model.SocksColor;


public interface ValidationService {
    boolean validate(SocksBatch socksBatch);
    boolean validate(SocksColor socksColor, SockSize sockSize, CottonContent cottonContent);
}
