package com.xarieth.myapplication.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xarieth.myapplication.PersonDetailActivity;
import com.xarieth.myapplication.model.PersonDetails;
import java.util.List;
import com.xarieth.myapplication.R;


public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.ViewHolder> {

    Context mContext;
    private LayoutInflater mInflater;
    List<PersonDetails> list;

    public PersonListAdapter(Context ctx, List<PersonDetails> list) {
        this.mContext = ctx;
        this.list = list;
        mInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public PersonListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recycle_view_item, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        String person_id = list.get(holder.getAdapterPosition()).getId();
                        String person_first_name = list.get(holder.getAdapterPosition()).getFirstname();
                        String person_last_name = list.get(holder.getAdapterPosition()).getLastname();
                        String person_birthday = list.get(holder.getAdapterPosition()).getBirthday();
                        String person_email = list.get(holder.getAdapterPosition()).getEmail();
                        String person_mobilenumber= list.get(holder.getAdapterPosition()).getMobilenumber();
                        String person_address = list.get(holder.getAdapterPosition()).getAddress();
                        String person_contactperson = list.get(holder.getAdapterPosition()).getContactperson();
                        String person_contactpersonnumber = list.get(holder.getAdapterPosition()).getContactpersonnumber();

                        Intent intent = new Intent(mContext, PersonDetailActivity.class);
                        intent.putExtra("person_id", person_id);
                        intent.putExtra("person_first_name", person_first_name);
                        intent.putExtra("person_last_name", person_last_name);
                        intent.putExtra("person_birthday", person_birthday);
                        intent.putExtra("person_email", person_email);
                        intent.putExtra("person_mobilenumber", person_mobilenumber);
                        intent.putExtra("person_address", person_address);
                        intent.putExtra("person_contactperson", person_contactperson);
                        intent.putExtra("person_contactpersonnumber", person_contactpersonnumber);

                        mContext.startActivity(intent);

            }
        });


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {


        final PersonDetails personDetails = list.get(i);

        viewHolder.person_id.setText(personDetails.getId());
        viewHolder.person_first_name.setText(personDetails.getFirstname());
        viewHolder.person_last_name.setText(personDetails.getLastname());
        viewHolder.person_email.setText(personDetails.getEmail());
        viewHolder.person_address.setText(personDetails.getAddress());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView person_first_name, person_last_name, person_email, person_address, person_id;

        public ViewHolder(View itemView) {
            super(itemView);

            person_id = (TextView) itemView.findViewById(R.id.person_id);
            person_first_name = (TextView) itemView.findViewById(R.id.person_first_name);
            person_last_name = (TextView) itemView.findViewById(R.id.person_last_name);
            person_email = (TextView) itemView.findViewById(R.id.person_email);
            person_address = (TextView) itemView.findViewById(R.id.person_address);
        }
    }



}




