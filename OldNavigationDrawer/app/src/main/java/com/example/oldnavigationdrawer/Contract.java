package com.example.oldnavigationdrawer;

import android.net.Uri;

public final class Contract {
    public static final String AUTHORITY = "com.example.oldnavigationdrawer.provider";
    public static final String CONTENT_PATH = "words";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);
    public static final int ALL_ITEMS = -2;
    public static final String WORD_ID = "id";
    public static final String SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.com.example.provider.words";
    public static final String MULTIPLE_RECORD_MIME_TYPE = "vnd.android.cursor.dir/vnd.com.example.provider.words";


    private Contract(){}

}
