package com.sameesh.stockwatcher.strategy;

import com.sameesh.stockwatcher.exception.BusinessException;

public enum Strategy {
    PUTOPTION("putoption"),
    SHORTSELL("shortsell"),
    PASSIVE("passiveranking");

    private String text;

    Strategy(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static Strategy fromString(String text) throws BusinessException {
        for (Strategy b : Strategy.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new BusinessException("Specefied strategy is not defined...");
    }
}
