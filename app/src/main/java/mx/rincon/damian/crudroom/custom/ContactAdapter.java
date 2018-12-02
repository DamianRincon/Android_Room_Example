package mx.rincon.damian.crudroom.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mx.rincon.damian.crudroom.R;
import mx.rincon.damian.crudroom.nodos.Contact;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private List<Contact> contactList; // Cached
    private LayoutInflater inflater;

    public ContactAdapter(Context context){ this.inflater = LayoutInflater.from(context); }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(inflater.inflate(R.layout.item_list,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (contactList != null) {
            Contact item = contactList.get(i);
            viewHolder.name.setText(item.getName());
            viewHolder.email.setText(item.getEmail());
            viewHolder.phone.setText(item.getPhone());
        }
    }

    public void setContacts(List<Contact> contacts){
        contactList = contacts;
        notifyDataSetChanged();
    }

    public void addContact(Contact contacts){
        contactList.add(contacts);
        notifyDataSetChanged();
    }

    Contact getContact(int position){
        return contactList.get(position);
    }

    @Override
    public int getItemCount() {
        if (contactList!=null)
            return contactList.size();
        else return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, email, phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
        }
    }
}
