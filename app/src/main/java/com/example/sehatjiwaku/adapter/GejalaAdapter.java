package com.example.sehatjiwaku.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sehatjiwaku.databinding.ItemGejalaBinding;
import com.example.sehatjiwaku.model.DataGejala;
import com.example.sehatjiwaku.ui.FormGejala;

import java.util.List;

public class GejalaAdapter extends RecyclerView.Adapter<GejalaAdapter.ViewHolder> {
    public List<DataGejala> DataGejalas;

    public GejalaAdapter(List<DataGejala> DataGejalas) {
        this.DataGejalas = DataGejalas;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(DataGejala data);
    }

    @NonNull
    @Override
    public GejalaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemGejalaBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GejalaAdapter.ViewHolder holder, final int position) {
        DataGejala data = DataGejalas.get(position);
        int no = position + 1;
        holder.itemGejalaBinding.tvNomorUrut.setText(no + ")");
        holder.itemGejalaBinding.tvNamaGejala.setText(data.getNamaGejala());
        String idPenyakit = data.getIdPenyakit();
        switch (idPenyakit){
            case "201" : holder.itemGejalaBinding.tvNamaPenyakit.setText("Halusinasi Pendengaran"); break;
            case "202" : holder.itemGejalaBinding.tvNamaPenyakit.setText("Halusinasi Penglihatan"); break;
            case "203" : holder.itemGejalaBinding.tvNamaPenyakit.setText("Halusinasi Penciuman"); break;
            case "204" : holder.itemGejalaBinding.tvNamaPenyakit.setText("Halusinasi Pengecapan"); break;
            case "205" : holder.itemGejalaBinding.tvNamaPenyakit.setText("Halusinasi Perabaan"); break;
        }
        holder.itemGejalaBinding.getRoot().setOnClickListener(view -> {
                Intent intent = new Intent(holder.itemView.getContext(), FormGejala.class);
                intent.putExtra(FormGejala.KEY_UPDATE_GEJALA, DataGejalas.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);
            }
        );
    }

    @Override
    public int getItemCount() {
        return DataGejalas == null ? 0 :
                DataGejalas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemGejalaBinding itemGejalaBinding;

        public ViewHolder(ItemGejalaBinding itemGejalaBinding) {
            super(itemGejalaBinding.getRoot());
            this.itemGejalaBinding = itemGejalaBinding;
        }
    }
}
