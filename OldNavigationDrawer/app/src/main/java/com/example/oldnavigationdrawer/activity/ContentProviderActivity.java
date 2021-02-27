package com.example.oldnavigationdrawer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.oldnavigationdrawer.Contract;
import com.example.oldnavigationdrawer.R;

public class ContentProviderActivity extends AppCompatActivity {
    private static final String TAG = ContentProviderActivity.class.getSimpleName();
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        mTextView = (TextView) findViewById(R.id.textview_content_provider);
    }
    public void onClickDisplayEntries (View view){
        Log.d (TAG, "Yay, I was clicked!");
        String queryUri = Contract.CONTENT_URI.toString();
        String selectionClause;
        String[] projection = new String[] {Contract.CONTENT_PATH};
        String selectionArgs[];
        String sortOrder = null;
        switch(view.getId()){
            case R.id.button_display_all:
//                Log.d(TAG, "Yay, " + R.id.button_display_all + " was clicked!");
                selectionClause = null;
                selectionArgs = null;
                break;
            case R.id.button_display_first:
//                Log.d(TAG, "Yay, " + R.id.button_display_first + " was clicked!");
                selectionClause = Contract.WORD_ID + " = ?";
                selectionArgs = new String[] {"0"};
                break;
            default:
                selectionClause = null;
                selectionArgs = null;
        }
//        textView.append("Thus we go!\n");
        Cursor cursor = getContentResolver().query(Uri.parse(queryUri), projection, selectionClause, selectionArgs, sortOrder);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(projection[0]);
                do {
                    String word = cursor.getString(columnIndex);
                    mTextView.append(word + "\n");
                } while (cursor.moveToNext());
            } else {
                Log.d(TAG, "onClickDisplayEntries " + "No data returned.");
                mTextView.append("No data returned." + "\n");
            }
            cursor.close();
        } else {
            Log.d(TAG, "onClickDisplayEntries " + "Cursor is null.");
            mTextView.append("Cursor is null." + "\n");
        }
    }
}