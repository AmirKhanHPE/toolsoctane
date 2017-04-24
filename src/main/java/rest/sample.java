package rest;
import com.hpe.adm.nga.sdk.Octane;
import com.hpe.adm.nga.sdk.authentication.Authentication;
import com.hpe.adm.nga.sdk.authentication.SimpleClientAuthentication;

import com.hpe.adm.nga.sdk.model.EntityModel;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by khanami on 21.04.2017.
 */
public class sample {

    private static final String ENTITY = "defects";

    public static void main(String[] args)  {
        Authentication clientAuthentication = new SimpleClientAuthentication("Amir_Khan_API_46zgykz6lq8v4sedn443oyevl", "+bf4c8fb48cc89394Q");

        // 2) User/pass
        //Authentication userPassAuthentication = new SimpleUserAuthentication("user", "password");

        // get instance of Octane Builder
        final Octane.Builder octaneBuilder = new Octane.Builder(clientAuthentication);

        // now we can add the server
        octaneBuilder.Server("https://mqast001pngx.saas.hpe.com");
        // the sharedspace
        octaneBuilder.sharedSpace(2004);

        Octane soctane = octaneBuilder.build();

        ArrayList<EntityModel> mSArrayList = (ArrayList<EntityModel>) soctane.entityList("workspaces").get().execute();

        for (int i = 0; i < mSArrayList.size(); i++) {
            System.out.println(mSArrayList.get(i).getValue("name").getValue()
                    + " " + mSArrayList.get(i).getValue("id").getValue()
                    + " " +mSArrayList.get(i).getValue("last_modified").getValue());

        }



        // the workspace
        octaneBuilder.workSpace(10001);

        // finally we build the context and get an Octane instance:

        Octane octane = octaneBuilder.build();

        // octane.entityList("defects").get().limit(2).execute();

        //octane.entityList("workspaces").get().execute();


        //JSONObject obj = new JSONObject(octane.entityList("defects").get().execute());
        //Defects
        ArrayList<EntityModel> mArrayList = (ArrayList<EntityModel>) octane.entityList("defects").get().execute();

        for (int i = 0; i < mArrayList.size(); i++) {
            System.out.println(mArrayList.get(i).getValue("name").getValue());

            System.out.println( mArrayList.get(i).getValue("priority").getValue());
           // if (prio != null) {
           //     System.out.println(mArrayList.get(i).getValue("priority").getValue().getValue("id").getValue());
            //}

            System.out.println(mArrayList.get(i).getValue("id").getValue());

        }

        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) octane.entityList("list_nodes").get().execute();

        for (int i = 0; i < mlArrayList.size(); i++) {
            System.out.println(mlArrayList.get(i).getValue("name").getValue());
            System.out.println(mlArrayList.get(i).getValue("logical_name").getValue());
            System.out.println(mlArrayList.get(i).getValue("id").getValue());
        }

        //System.out.print(test);
        //JSONArray arr = obj.getJSONArray("data");
        //for (int i = 0; i < arr.length(); i++)
        //{
         //   String post_id = arr.getJSONObject(i).getString("description");
          //  System.out.print(post_id);

        //}
     }
}