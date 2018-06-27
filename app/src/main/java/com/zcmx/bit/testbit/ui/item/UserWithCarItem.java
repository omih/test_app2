package com.zcmx.bit.testbit.ui.item;

import com.xwray.groupie.Item;
import com.xwray.groupie.ViewHolder;
import com.zcmx.bit.model.model.UserWithCar;
import com.zcmx.bit.testbit.R;

import android.support.annotation.NonNull;
import android.widget.TextView;

public class UserWithCarItem extends Item<ViewHolder> {

    private UserWithCar userWithCar;

    public UserWithCarItem(final UserWithCar user) {
        this.userWithCar = user;
    }

    @Override
    public void bind(@NonNull final ViewHolder viewHolder, final int position) {
        TextView user = viewHolder.itemView.findViewById(R.id.user);
        TextView car = viewHolder.itemView.findViewById(R.id.car);

        user.setText(userWithCar.getName());
        car.setText(userWithCar.getNameCar());
    }

    @Override
    public int getLayout() {
        return R.layout.item_user_car;
    }
}
