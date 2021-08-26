package com.example.sehatjiwaku.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sehatjiwaku.databinding.ItemDoctorBinding;
import com.example.sehatjiwaku.model.DataDoctor;
import com.example.sehatjiwaku.ui.FormDokterActivity;

import java.util.List;

public class DokterAdapter extends RecyclerView.Adapter<DokterAdapter.ViewHolder> {
    public List<DataDoctor> dataDoctors;

    public DokterAdapter(List<DataDoctor> dataDoctors) {
        this.dataDoctors = dataDoctors;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(DataDoctor data);
    }

    @NonNull
    @Override
    public DokterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemDoctorBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DokterAdapter.ViewHolder holder, final int position) {
        DataDoctor data = dataDoctors.get(position);
        holder.itemDoctorBinding.tvDoctorName.setText(data.getNamaDokter());
        holder.itemDoctorBinding.btnEdit.setOnClickListener(view -> {
                Intent intent = new Intent(holder.itemView.getContext(), FormDokterActivity.class);
                intent.putExtra(FormDokterActivity.KEY_UPDATE_DOCTOR, dataDoctors.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);
            }
        );
    }

    @Override
    public int getItemCount() {
        return dataDoctors == null ? 0 :
                dataDoctors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemDoctorBinding itemDoctorBinding;

        public ViewHolder(ItemDoctorBinding itemDoctorBinding) {
            super(itemDoctorBinding.getRoot());
            this.itemDoctorBinding = itemDoctorBinding;
        }
    }
}
