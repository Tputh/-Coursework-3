package com.klyuvjerov.coursework3.model;

public enum CottonContent {
    A(" содержание хлопка хлопка более 90% "),
    B(" содержание хлопка хлопка 40% "),
    S(" содержание хлопка хлопка менее 10% ");
    private final String text;

    CottonContent(String text) {
        this.text = text;
    }

}
