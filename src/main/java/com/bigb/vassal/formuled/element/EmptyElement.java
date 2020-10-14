package com.bigb.vassal.formuled.element;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 */
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmptyElement extends BaseElement {
    public static final EmptyElement ELEMENT = new EmptyElement();
}
