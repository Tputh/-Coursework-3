package com.klyuvjerov.coursework3.services.impl;

import com.klyuvjerov.coursework3.model.CottonContent;
import com.klyuvjerov.coursework3.model.SockSize;
import com.klyuvjerov.coursework3.model.SocksBatch;
import com.klyuvjerov.coursework3.model.SocksColor;
import com.klyuvjerov.coursework3.services.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(SocksBatch socksBatch) {
        return socksBatch.getSocks() != null &&
                socksBatch.getSocks().getSocksColor() != null &&
                socksBatch.getSocks().getSockSize() != null &&
                socksBatch.getSocks().getCottonContent() != null &&
                socksBatch.getQuantity() > 0;
    }

    @Override
    public boolean validate(SocksColor socksColor, SockSize sockSize, CottonContent cottonContent) {
        return socksColor != null &&
                sockSize != null &&
                cottonContent != null;
    }


}
