package io.github.abachouch.wishlist.data;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.File;

public class WishService {

    Context context;


    public  WishService(Context context) {
        this.context = context;

        File file = new File(context.getFilesDir(), "myfile1990");
        try {
            context.openFileOutput("myfile1990" ,Context.MODE_APPEND);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Wish> getAllWichs() {
        ArrayList<Wish> myDataset = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myDataset.add(new Wish("item copfl ipe " + i, "To access the RecyclerView widget, you need to add the v7 Support Libraries .", i * 10.23f, i));
        }
        return myDataset;
    }




    void initFirst() {

    }


}
