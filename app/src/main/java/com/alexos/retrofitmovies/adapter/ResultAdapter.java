package com.alexos.retrofitmovies.adapter;

import static com.alexos.retrofitmovies.model.Result.CALLBACK;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.alexos.retrofitmovies.R;
import com.alexos.retrofitmovies.databinding.ResultListItemBinding;
import com.alexos.retrofitmovies.model.Result;
import com.alexos.retrofitmovies.view.MovieDetailsActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ResultAdapter
        extends PagedListAdapter<Result, ResultAdapter.ResultViewHolder> {

    private Context context;
//    private ArrayList<Result> results;

    public ResultAdapter(Context context) {
        super(Result.CALLBACK);
        this.context = context;
//        this.results = results;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ResultListItemBinding resultListItemBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.result_list_item, parent, false);

        return new ResultViewHolder(resultListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {

        Result result = getItem(position);

        holder.resultListItemBinding.setResult(result);

    }

//    @Override
//    public int getItemCount() {
//        return results.size();
//    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {

        private ResultListItemBinding resultListItemBinding;

        public ResultViewHolder(@NonNull ResultListItemBinding resultListItemBinding) {
            super(resultListItemBinding.getRoot());
            this.resultListItemBinding = resultListItemBinding;

            resultListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {

                        Result result = getItem(position);
                        Intent intent = new Intent(context, MovieDetailsActivity.class);
                        intent.putExtra("movieData", result);
                        context.startActivity(intent);

                    }

                }
            });
        }
    }
}
