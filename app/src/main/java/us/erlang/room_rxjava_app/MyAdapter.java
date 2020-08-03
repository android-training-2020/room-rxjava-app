package us.erlang.room_rxjava_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private List<Person> personList;
    private TextView name, age, gender;

    public MyAdapter(List<Person> peoples) {
        this.personList = peoples;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Person person = this.personList.get(position);
        if(person != null) {
            ((ItemViewHolder)holder).setData(person);
        }
    }

    @Override
    public int getItemCount() {
        return this.personList.size();
    }
}
