package com.branter.jiadongyan.branter;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EventDetail extends AppCompatActivity {
    ListView lv;
    ArrayList<String> arrayList = arrayList = new ArrayList<>();

    @SuppressWarnings("deprecation")
    Gallery Imagegallery;
    Integer[] GalleryImagesList =
            {
                    R.drawable.one,
                    R.drawable.two,
                    R.drawable.three,
                    R.drawable.four,
                    R.drawable.five,
                    R.drawable.six,
                    R.drawable.seven
            };
    ImageView imgGalleryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);;

        imgGalleryImage = (ImageView)findViewById(R.id.imgGalleryImage);
        imgGalleryImage.setImageResource(R.drawable.one);

        Imagegallery = (Gallery)findViewById(R.id.gallery);
        Imagegallery.setAdapter(new ImageAdapter(this));
        Imagegallery.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                imgGalleryImage.setImageResource(GalleryImagesList[position]);
            }
        });

        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, getData()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.EventDetail_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventDetail.this, NewPost.class));
            }
        });
    }

    private List<String> getData(){

        List<String> data = new ArrayList<String>();
        data.add("test1");
        data.add("test2");
        data.add("test3");
        data.add("test4");

        return data;
    }

    private class ImageAdapter extends BaseAdapter
    {
        Context context;
        public ImageAdapter(Context context)
        {
            this.context = context;
        }
        @Override
        public int getCount()
        {
            return GalleryImagesList.length;
        }

        @Override
        public Object getItem(int position)
        {
            return GalleryImagesList[position];
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView imageView = new ImageView(this.context);
            imageView.setImageResource(GalleryImagesList[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(150, 200));
            imageView.setScaleType(ScaleType.FIT_XY);

            return imageView;
        }

    }
}
