package com.abbisqq.timemanager;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abbisqq.timemanager.data.ContractTimeManager;

/**
 * Created by chart on 2/5/2017.
 */

public class CustomCursorAdapter extends RecyclerView.Adapter<CustomCursorAdapter.MyViewHolder>{


    Context mContext;
    Cursor mCursor;

    public CustomCursorAdapter(Context mContext) {
         this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the task_layout to a view
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        int idIndex = mCursor.getColumnIndex(ContractTimeManager.TasksEntry._ID);
        int titleIndex = mCursor.getColumnIndex(ContractTimeManager.TasksEntry.TITLE);
        int descriptionIndex = mCursor.getColumnIndex(ContractTimeManager.TasksEntry.INFO);


        mCursor.moveToPosition(position); // get to the right location in the cursor


        final int id = mCursor.getInt(idIndex);
        String description = mCursor.getString(descriptionIndex);
        String title = mCursor.getString(titleIndex);
        holder.itemView.setTag(id);
        holder.titleView.setText(title);
        holder.infoView.setText(description);






    }

    @Override
    public int getItemCount() {
        if (mCursor == null) {
            return 0;
        }
        return mCursor.getCount();
    }



    public Cursor swapCursor(Cursor c) {
        // check if this cursor is the same as the previous cursor (mCursor)
        if (mCursor == c) {
            return null; // bc nothing has changed
        }
        Cursor temp = mCursor;
        this.mCursor = c; // new cursor value assigned

        //check if this is a valid cursor, then update the cursor
        if (c != null) {
            this.notifyDataSetChanged();
        }
        return temp;
    }





    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleView;
        TextView infoView;


        public MyViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView)itemView.findViewById(R.id.title_text_view);
            infoView = (TextView)itemView.findViewById(R.id.info_text_view);

        }
    }


}
