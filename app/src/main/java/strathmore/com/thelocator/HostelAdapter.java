package strathmore.com.thelocator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cece on 04/11/2017.
 */

public class HostelAdapter extends RecyclerView.Adapter<HostelAdapter.MyViewHolder>{

    //Used to store the list of objects
    private List<HostelList> hostelList;
    private Context context;

    //The constructor
    public HostelAdapter(List<HostelList> hostelList, Context context){
        this.hostelList = hostelList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView hostel_name, hostel_price;
        public ImageView hostel_image,favouritesimg;

        //Constructor
        public MyViewHolder(View itemView) {
            super(itemView);
            hostel_image = (ImageView) itemView.findViewById(R.id.hostel_image);
            hostel_name = (TextView) itemView.findViewById(R.id.hostel_name);
            hostel_price = (TextView) itemView.findViewById(R.id.hostel_price);
            favouritesimg = (ImageView) itemView.findViewById(R.id.hostel_fav);
        }
    }



    @Override
    public HostelAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hostellist, parent, false);

        return new MyViewHolder(itemView);
    }

    //Binds the data to the view objects.
    @Override
    public void onBindViewHolder(HostelAdapter.MyViewHolder holder, int position) {
        HostelList hostel = hostelList.get(position);//Gives specific position of list item object
        holder.hostel_name.setText(hostel.getHostelname());
        holder.hostel_price.setText(hostel.getHostelprice());




        //Not so sure
        holder.hostel_image.setImageDrawable(Drawable.createFromPath(hostel.getImage()));
        holder.favouritesimg.setImageDrawable(Drawable.createFromPath(hostel.getFavouritesimg()));



    }

    //To return the size of the list items.
    //Size of the recycler view
    @Override
    public int getItemCount() {
        return hostelList.size();
    }
}
