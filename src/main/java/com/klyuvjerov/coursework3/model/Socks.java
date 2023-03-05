package com.klyuvjerov.coursework3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socks {
    private SocksColor socksColor;
    private SockSize sockSize;
    private CottonContent cottonContent;
}
