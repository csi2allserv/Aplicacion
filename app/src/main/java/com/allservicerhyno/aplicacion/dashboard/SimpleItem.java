package com.allservicerhyno.aplicacion.dashboard;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.allservicerhyno.aplicacion.R;

public class SimpleItem extends DrawerItem<SimpleItem.ViewHolder>{

    private int selectedItemIconTint;
    private int selectedItemTextTint;


    private int normalItemIconTint;
    private int normalItemTextTint;


    private Drawable icon;
    private  String tittle;

   public SimpleItem(Drawable icon, String tittle){
       this.icon = icon;
       this.tittle = tittle;

   }

    @Override
    public ViewHolder createVIewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_option, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void bindVIewHolder(ViewHolder holder) {

       holder.tittle.setText(tittle);
       holder.icon.setImageDrawable(icon);

       holder.tittle.setText(isChecked ? selectedItemTextTint : normalItemTextTint);
       holder.icon.setColorFilter(isChecked ? selectedItemIconTint : normalItemIconTint);

    }

    public SimpleItem withSelectedIconTint(int SelectedItemIconTint){
       this.selectedItemIconTint = selectedItemIconTint;
       return this;
    }

    public SimpleItem withSelectedTextTint(int selectedItemTextTint){
       this.selectedItemTextTint = selectedItemTextTint;
       return  this;
    }

    public SimpleItem withIconTint(int normalItemIconTint){
       this.normalItemIconTint = normalItemIconTint;
       return this;
    }

    public SimpleItem withTextTint(int normalItemTextTint){
       this.normalItemTextTint = normalItemTextTint;
       return this;
    }

    static class ViewHolder extends DrawerAdapter.ViewHolder{

        private final ImageView icon;
        private final TextView tittle;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            tittle = itemView.findViewById(R.id.tittle);
        }
    }
}
