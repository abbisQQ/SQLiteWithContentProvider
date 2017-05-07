package com.abbisqq.timemanager.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by chart on 2/5/2017.
 */

public class ContractTimeManager{


    public static final String CONTENT_AUTHORITY = "com.abbisqq.timemanager";


    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    public static final String TASK_PATH = "tasks";


    public static final class TasksEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(TASK_PATH)
                .build();


        public static final String TABLE_NAME = "tasks";

        public static final String TITLE = "title";

        public static final String INFO = "info";


    }
}
