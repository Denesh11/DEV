package com.bawp.testlocation;

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import static android.support.constraint.Constraints.TAG;

public class FetchAddressTask extends AsyncTask<Location, Void, String> {
    private Context context;
    private OnTaskCompleted listner;

    public FetchAddressTask(Context context, OnTaskCompleted listner) {
        this.context = context;
        this.listner = listner;
    }

    @Override
    protected String doInBackground(Location... locations) {
        //Setting our Geocoder
        Location location = locations[0];
        String resultString = "";

        resultString = String.valueOf(location.getLatitude());
        Log.e(TAG, "res" + ". " +
                "Latitude = " + location.getLatitude() +
                ", Longitude = " +
                location.getLongitude());

        return resultString;
    }

     interface OnTaskCompleted {
        void onTaskCompleted(String result);
    }

    @Override
    protected void onPostExecute(String message) {
        listner.onTaskCompleted(message);
        super.onPostExecute(message);
    }
}
