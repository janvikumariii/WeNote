package com.example.wenote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wenote.databinding.ListBinding;

public class Adapter extends ListAdapter<Note,Adapter.ViewHolder> {

    public Adapter(MainActivity mainActivity){
        super(CALLBACK);
    }
    private static final DiffUtil.ItemCallback<Note>CALLBACK=new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
                    &&oldItem.getDesc().equals(newItem.getDesc());
        }
    };
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note=getItem(position);
        holder.binding.title.setText(note.getTitle());
        holder.binding.desc.setText(note.getDesc());
    }
    public Note getNote(int position){
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ListBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ListBinding.bind(itemView);
        }
    }
}
