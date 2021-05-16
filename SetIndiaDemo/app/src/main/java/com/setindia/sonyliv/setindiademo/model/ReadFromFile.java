package com.setindia.sonyliv.setindiademo.model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    author: ritesh
    date: 16 May 2021

    when you try to read from asset folder then this can be used.
    But in my this application, we are fetching data from cloud
 */
public class ReadFromFile {
    public static String readFromAssets(Context context, String filename) throws IOException {
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(context.getAssets().open(filename)));

        // do reading, usually loop until end of file reading
        StringBuilder sb = new StringBuilder();
        String mLine = reader.readLine();
        while (mLine != null) {
            sb.append(mLine); // process line
            mLine = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }
}
