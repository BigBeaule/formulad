package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.HotKey;

/**
 * 
 */
public class GlobalHotKey extends AbstractTrait {
    public GlobalHotKey(String description, String menuText, HotKey keyboardCommand, HotKey globalKey) {
        super("globalhotkey", menuText, keyboardCommand, globalKey, description);
    }
}
