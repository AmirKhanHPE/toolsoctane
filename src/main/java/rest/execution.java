package rest;

import com.hpe.adm.nga.sdk.Octane;

import java.io.IOException;

/**
 * Created by khanami on 24.04.2017.
 */
public class execution {
    public static void main(String[] args)  throws IOException
    {
       Octane.Builder octane= readSDK2writeDATA.Login2Octane("https://mqast001pngx.saas.hpe.com",
               "Amir_Khan_API_46zgykz6lq8v4sedn443oyevl",
               "+bf4c8fb48cc89394Q",
               2004);

       //octane.signOut();


        octane = readSDK2writeDATA.GetNodes2File(octane,2004,10001);
        octane = readSDK2writeDATA.GetPhases2File(octane,2004,10001);
        octane = readSDK2writeDATA.GetReleases2File(octane,2004,10001);
        octane = readSDK2writeDATA.GetEpics2File(octane,2004,10001);
        octane = readSDK2writeDATA.GetFeatures2File(octane,2004,10001);


    }

}
