package com.example.harshjain.musicearn;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Harsh Jain on 06-08-2018.
 */

public class CustomVideoAdapter extends ArrayAdapter {
    private Context context;
    private List<VideoModel> ItemList;
    public CustomVideoAdapter(Context context, int textViewResourceId) {
        super(context,textViewResourceId);
        this.context = context;

    }
    public CustomVideoAdapter(Context context, int resource, List<VideoModel> items) {
        super(context, resource, items);
        this.context = context;
        this.ItemList = items;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.video_items, null);
        }

        VideoModel p = ItemList.get(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.name);
//            TextView tt2 = (TextView) v.findViewById(R.id.artist);
//            TextView tt3 = (TextView) v.findViewById(R.id.album);

            if (tt1 != null) {
                tt1.setText(p.getName());
            }
        }
        return v;
    }
}

