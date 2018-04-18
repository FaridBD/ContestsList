package com.example.farid.contestslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.recyclerViewHolder> {

    Context mContest;
    List< ContestActivity >list;

    public RecyclerAdapter(Context mContest, List<ContestActivity> list) {
        this.mContest = mContest;
        this.list = list;
    }

    @Override
    public recyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContest);
        View view = inflater.inflate(R.layout.card_view_contest, parent, false);

        return new recyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(recyclerViewHolder holder, int position) {

        holder.tv_contest_name.setText(list.get(position).getContest_name());
        holder.tv_start_date.setText(list.get(position).getStart_date());
        holder.tv_start_information.setText(list.get(position).getStart_information());
        holder.tv_end_date.setText(list.get(position).getEnd_date());
        holder.tv_end_information.setText(list.get(position).getEnd_information());
        holder.img_contest.setImageResource(list.get(position).getContest_image());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class recyclerViewHolder extends RecyclerView.ViewHolder {

        TextView tv_start_date;
        TextView tv_start_information;
        TextView tv_end_date;
        TextView tv_end_information;
        TextView tv_contest_name;
        ImageView img_contest;

        public recyclerViewHolder(View itemView) {
            super(itemView);

            tv_start_date = itemView.findViewById(R.id.start_date);
            tv_start_information = itemView.findViewById(R.id.start_information);
            tv_end_date = itemView.findViewById(R.id.end_date);
            tv_end_information = itemView.findViewById(R.id.end_information);
            tv_contest_name = itemView.findViewById(R.id.contest_name);
            img_contest = itemView.findViewById(R.id.img_contest);
        }
    }

}
