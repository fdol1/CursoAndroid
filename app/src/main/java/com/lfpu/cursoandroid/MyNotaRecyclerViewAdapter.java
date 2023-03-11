package com.lfpu.cursoandroid;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lfpu.cursoandroid.databinding.FragmentNotaBinding;

import java.util.List;

public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private final List<Nota> mValues;
    private final NotasInteractionListener mListener;

    public MyNotaRecyclerViewAdapter(List<Nota> items, NotasInteractionListener listener) {
        mListener = listener;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_nota, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.txtViewTitulo.setText(holder.mItem.getTitulo());
        holder.txtViewContenido.setText(holder.mItem.getContenido());

        if(holder.mItem.getFavorita()){
            holder.imgFavorita.setImageResource(R.drawable.ic_baseline_star_24);
        }

        holder.imgFavorita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(null != mListener){
                    mListener.favoritaNotaClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtViewTitulo;
        public final TextView txtViewContenido;
        public final ImageView imgFavorita;
        public Nota mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtViewTitulo = view.findViewById(R.id.txtTitulo);
            txtViewContenido = view.findViewById(R.id.txtContenido);
            imgFavorita = view.findViewById(R.id.imgFavorita);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtViewTitulo.getText() + "'";
        }
    }
}