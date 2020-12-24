package shop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.o7planning.btap4.R;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.shopViewHolder> {
    List<Shop> mShops;
    public void setData(List<Shop> list){
        this.mShops = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public shopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop,parent,false);
        return new shopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull shopViewHolder holder, int position) {
        Shop shop = mShops.get(position);
        if(shop == null){
            return;
        }
        holder.imgShop.setImageResource(shop.getResourceId());
        holder.tvTitle.setText(shop.getTitle());
    }
    @Override
    public int getItemCount() {
        if (mShops !=null){
            return mShops.size();
        }
        return 0;
    }
    public class shopViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgShop;
        private TextView tvTitle;
        public shopViewHolder(@NonNull View itemView) {
            super(itemView);
            imgShop = itemView.findViewById(R.id.img_shop);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
