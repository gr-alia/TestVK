package com.alia.testvk.screen.feed;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alia.testvk.R;
import com.alia.testvk.model.VideoItem;
import com.alia.testvk.screen.player.PlayerActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alyona on 10.11.2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    private Context mContext;
    private List<VideoItem> mVideos;

    private final OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(@NonNull View view, @NonNull VideoItem video);

    }

    public VideoAdapter(Context context, @NonNull OnItemClickListener onItemClickListener) {
        mContext = context;
        mVideos = new ArrayList<>();
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_video, parent, false);
        return new VideoHolder(v);
    }

    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        VideoItem video = mVideos.get(position);
        holder.bind(video);

        holder.itemView.setOnClickListener(mInternalListener);
        holder.itemView.setTag(video);

    }

    @Override
    public int getItemCount() {
        return mVideos.size();
    }

    public void changeDataSet(List<VideoItem> videos) {
        mVideos.clear();
        mVideos.addAll(videos);
        notifyDataSetChanged();
    }

    private final View.OnClickListener mInternalListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            VideoItem video = (VideoItem) view.getTag();
            mOnItemClickListener.onItemClick(view, video);
        }
    };

    class VideoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnail)
        ImageView mThumbnailView;
        @BindView(R.id.tittle)
        TextView mTittleView;
        @BindView(R.id.duration)
        TextView mDurationView;

        public VideoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void bind(VideoItem video) {
            Picasso.with(mContext)
                    .load(video.getPhoto320())
                    .into(mThumbnailView);
            mTittleView.setText(video.getTitle());

            Integer duration = video.getDuration();
            int seconds = duration % 60;
            int minutes = (duration / 60) % 60;
            int hours = ((duration / (60 * 60)) % 60);
            mDurationView.setText(String.format("%d:%02d:%02d", hours, minutes, seconds));

        }

    }
}
