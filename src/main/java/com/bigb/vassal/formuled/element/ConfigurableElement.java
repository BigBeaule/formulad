package com.bigb.vassal.formuled.element;

import com.bigb.vassal.formuled.configuration.Settings;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ConfigurableElement extends BaseElement {
    protected final Settings settings;
}
