package mx.rincon.damian.crudroom.nodos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "contacts")
public class Contact  implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "phone")
    private String phone;

    public Contact(int id, String name, String email, String phone){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    protected Contact(Parcel in) {
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        phone = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(phone);
    }
}
