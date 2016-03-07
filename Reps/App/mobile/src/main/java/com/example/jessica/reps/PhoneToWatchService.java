package com.example.jessica.reps;

/**
 * Created by Jessica on 3/1/16.
 */



import android.app.Service;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.IBinder;
        import android.util.Log;

        import com.google.android.gms.common.api.GoogleApiClient;
        import com.google.android.gms.common.api.ResultCallback;
        import com.google.android.gms.wearable.MessageApi;
        import com.google.android.gms.wearable.Node;
        import com.google.android.gms.wearable.NodeApi;
        import com.google.android.gms.wearable.Wearable;

        import java.util.ArrayList;
        import java.util.List;

public class PhoneToWatchService extends Service {

    private GoogleApiClient mApiClient;

    @Override
    public void onCreate() {
        super.onCreate();
        //initialize the googleAPIClient for message passing
        mApiClient = new GoogleApiClient.Builder( this )
                .addApi( Wearable.API )
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(Bundle connectionHint) {
                    }

                    @Override
                    public void onConnectionSuspended(int cause) {
                    }
                })
                .build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mApiClient.disconnect();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Which cat do we want to feed? Grab this info from INTENT
        // which was passed over when we called startService

        final Bundle extras = intent.getExtras();
        String repname = extras.getString("REP_NAME");
        String repvote = extras.getString("REP_VOTE");
        String repPer = extras.getString("REP_PER");
        String repId = extras.getString("REP_PIC");
        String reppart = extras.getString("REP_PART");
        String replace = extras.getString("REP_PLACE");

        final String send = repname + ";" + repvote + ";" + repPer + ";" + repId + ";" + reppart + ";" + replace;
        System.out.println("String " + send);

        // Send the message with the name
        new Thread(new Runnable() {
            @Override
            public void run() {
                //first, connect to the apiclient
                mApiClient.connect();

                //now that you're connected, send a message with the name
                sendMessage("/rep", send);


            }
        }).start();

        return START_STICKY;
    }

    @Override //remember, all services need to implement an IBiner
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void sendMessage( final String path, final String text ) {
        //one way to send message: start a new thread and call .await()
        //see watchtophoneservice for another way to send a message
        new Thread( new Runnable() {
            @Override
            public void run() {
                NodeApi.GetConnectedNodesResult nodes = Wearable.NodeApi.getConnectedNodes( mApiClient ).await();

                for(Node node : nodes.getNodes()) {

                    //we find 'nodes', which are nearby bluetooth devices (aka emulators)
                    //send a message for each of these nodes (just one, for an emulator)
                    MessageApi.SendMessageResult result = Wearable.MessageApi.sendMessage(
                            mApiClient, node.getId(), path, text.getBytes() ).await();
                    //4 arguments: api client, the node ID, the path (for the listener to parse),
                    //and the message itself (you need to convert it to bytes.)
                }
            }
        }).start();
    }

}


