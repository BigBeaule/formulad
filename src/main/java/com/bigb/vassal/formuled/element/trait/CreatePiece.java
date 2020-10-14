package com.bigb.vassal.formuled.element.trait;

import org.apache.commons.lang3.StringUtils;

import com.bigb.vassal.formuled.element.HotKey;
import com.bigb.vassal.formuled.element.enums.Stack;

import lombok.NonNull;

public class CreatePiece extends AbstractTrait {
    public CreatePiece(@NonNull String description, int nextPieceId, HotKey menu, HotKey command, boolean matchRotation,
            Stack stack, String... pieceLocation) {

        super("placemark", menu, command, StringUtils.join(pieceLocation, ':'), "null", 0, 0, matchRotation, null, description, nextPieceId,
                stack.getValue(), false);
    }
}
