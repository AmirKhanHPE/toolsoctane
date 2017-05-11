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
               "Amir_Khan_API_46zgyv4sedn443oyevl",
               "+bf48cc89394Q",
               2004);

       //octane.signOut();


        octane = readSDK2writeDATA.GetNodes2File(octane,2004,10001);
        octane = readSDK2writeDATA.GetPhases2File(octane,2004,11001);
        //octane = readSDK2writeDATA.GetReleases2File(octane,2004,10001);
        octane = readSDK2writeDATA.GetNodes2File(octane,2004,11001);
        //octane = readSDK2writeDATA.GetEpics2File(octane,2004,10001);
        //octane = readSDK2writeDATA.GetFeatures2File(octane,2004,10001);
        //octane = readSDK2writeDATA.GetStories2File(octane,2004,10001);
        octane =readSDK2writeDATA.GetDefects2File(octane,2004,11001);
        //octane =readSDK2writeDATA.GetManualTests2File(octane,2004,10001);
        //octane =readSDK2writeDATA.GetGherkinTests2File(octane,2004,10001);
        //octane =readSDK2writeDATA.GetTestSuites2File(octane,2004,10001);
        //octane =readSDK2writeDATA.GetTestsInSuites2File(octane,2004,10001);
        //octane = readSDK2writeDATA.GetTasks2File(octane,2004,10001);
        //octane = readSDK2writeDATA.GetManualRuns2File(octane,2004,10001);

        //Forbidden and in Beta
        //octane = readSDK2writeDATA.GetAutomatedRuns2File(octane,2004,10001);


    }

}
