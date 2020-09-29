package com.bigb.vassal.formuled.element.trait;

import com.bigb.vassal.formuled.element.Expression;
import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.Command;

/**
 * 
 */
public class GlobalKey extends AbstractTrait {
    public GlobalKey(String name, Command command, HotKey keyboardCommand, HotKey globalCommand,
            Expression matchingProperties) {

        this(name, command, keyboardCommand, globalCommand, matchingProperties, false);
    }

    public GlobalKey(String name, Command command, HotKey keyboardCommand, HotKey globalCommand,
            Expression matchingProperties, boolean suppresIndividualReports) {

        super("globalkey", command, keyboardCommand, globalCommand, matchingProperties, false, 1,
                suppresIndividualReports, true, null, name, -1);
    }
}
