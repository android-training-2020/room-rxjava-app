package us.erlang.room_rxjava_app;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private TextView name, age, gender;
    public ItemViewHolder(View view) {
        super(view);
        name = view.findViewById(R.id.item_user_name);
        age = view.findViewById(R.id.item_age);
        gender = view.findViewById(R.id.item_gender);
    }

    public void setData(Person person) {
        name.setText(person.name);
        age.setText(String.valueOf(person.age));
        gender.setText(person.gender == 0 ? "female" : "male");
    }
}
