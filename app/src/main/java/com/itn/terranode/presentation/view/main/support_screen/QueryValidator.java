package com.itn.terranode.presentation.view.main.support_screen;

import androidx.annotation.Nullable;

final class QueryValidator {

    private static final int MIN_QUERY_LENGTH = 3;

    private QueryValidator() {
        throw new RuntimeException("There is must be no instance!");
    }


    static boolean isValid(@Nullable String search) {
        return search != null && search.length() >= MIN_QUERY_LENGTH;
    }
}
