package com.example.harshjain.musicearn;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Harsh Jain on 06-08-2018.
 */

public class CustomAdapter extends ArrayAdapter{


    private Context context;
    private List<AudioModel> ItemList;
    public CustomAdapter(Context context, int textViewResourceId) {
        super(context,textViewResourceId);
        this.context = context;

    }
    public CustomAdapter(Context context, int resource, List<AudioModel> items) {
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
            v = vi.inflate(R.layout.items, null);
        }

        AudioModel p = ItemList.get(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.name);
            TextView tt2 = (TextView) v.findViewById(R.id.artist);
            TextView tt3 = (TextView) v.findViewById(R.id.album);

            if (tt1 != null) {
                tt1.setText(p.getaName());
            }

            if (tt2 != null) {
                tt2.setText(p.getaArtist());
            }

            if (tt3 != null) {
                tt3.setText(p.getaAlbum());
            }
        }
        return v;
    }
}
