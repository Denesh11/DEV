package com.example.self;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class JournalRecyclerAdapter extends RecyclerView.Adapter<JournalRecyclerAdapter.ViewHolder> {
    private Context context;
    private ImageButton shareButton;
    private TextView title;
    private List<Journal> journal;
    private TextView thoughts;
    private List<Journal> journalList;


    public JournalRecyclerAdapter(Context context, List<Journal> journalList) {
        this.context = context;
        this.journalList = journalList;
    }

    @NonNull
    @Override
    public JournalRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.journal_row, viewGroup, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull JournalRecyclerAdapter.ViewHolder viewHolder, int position) {

        Journal journal = journalList.get(position);
        String imageUrl;

        viewHolder.title.setText(journal.getTitle());
        viewHolder.thoughts.setText(journal.getThought());
        viewHolder.name.setText(journal.getUserName());
        imageUrl = journal.getImageUrl();
        //1 hour ago....
        //Source: https://medium.com/@shaktisinh/time-a-go-in-android-8bad8b171f87

        String timeAgo = (String) DateUtils.getRelativeTimeSpanString
                (journal.getTimeAdded().getSeconds() * 1000);
        viewHolder.dateAdded.setText(timeAgo);


        /*
        Use Picasso library to download and show image
         */

        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.image_three)
                .fit()
                .into(viewHolder.image);

    }

    @Override
    public int getItemCount() {
        return journalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView
                title,
                thoughts,
                dateAdded,
                name;
        public ImageView image;
        public ImageButton shareButton;
        String userId;
        String username;



        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;

            title = itemView.findViewById(R.id.journal_title_list);
            thoughts = itemView.findViewById(R.id.journal_thought_list);
            dateAdded = itemView.findViewById(R.id.journal_timestamp_list);
            image = itemView.findViewById(R.id.journal_image_list);
            name = itemView.findViewById(R.id.journal_row_username);

            shareButton = itemView.findViewById(R.id.journal_row_share_button);
            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //context.startActivity();share button activity
                    int position = getAdapterPosition();
                    String imageUrl = journalList.get(position).getImageUrl();

                    shareImage(imageUrl, ctx,position,journalList);

                }
            });

        }


    }

    private void shareImage(String imageUrl, Context ctx, int position, List<Journal> journalList) {

        Picasso.get().load(imageUrl).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"From Self App");
                shareIntent.putExtra(Intent.EXTRA_TEXT, journalList.get(position).getTitle()
                +"\n\n" + journalList.get(position).getThought());

                shareIntent.setType("image/*");

                Uri imageUri = getLocalBitmapUri(bitmap, context);

                shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
                Log.d("TAG", "onBitmapLoaded: "+imageUri.toString());
                context.startActivity(Intent.createChooser(shareIntent,"Send Image"));

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) { }
        });

    }

    public static Uri getLocalBitmapUri(Bitmap bitmap, Context context) {

        Uri bmpUri = null;
        try{
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                    "share_image" + System.currentTimeMillis()+".png");
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = FileProvider.getUriForFile(context.getApplicationContext(),"com.codepath.fileprovider",file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;

    }


}
