package rest;

import com.hpe.adm.nga.sdk.Octane;
import com.hpe.adm.nga.sdk.authentication.Authentication;
import com.hpe.adm.nga.sdk.authentication.SimpleClientAuthentication;

import java.io.IOException;
import java.util.*;
import com.hpe.adm.nga.sdk.model.EntityModel;

import javax.xml.ws.Endpoint;

/**
 * Created by khanami on 24.04.2017.
 */
public class readSDK2writeDATA {

    public static Octane.Builder Login2Octane (String vsURL, String vsClientID, String vsClientSecret, int vnSharedSpace) throws IOException
    {
        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\workspaces\\workspaces.txt";
        Authentication clientAuthentication = new SimpleClientAuthentication(vsClientID, vsClientSecret);

        final Octane.Builder octaneBuilder = new Octane.Builder(clientAuthentication);
        // now we can add the server
        octaneBuilder.Server(vsURL);
        // the sharedspace
        octaneBuilder.sharedSpace(vnSharedSpace);

        Octane soctane = octaneBuilder.build();

        ArrayList<EntityModel> mSArrayList = (ArrayList<EntityModel>) soctane.entityList("workspaces").get().execute();
        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID;Name;Last_Modified");

        for (int i = 0; i < mSArrayList.size(); i++) {
            ctextfiles.writeTextFile(PATH,
                    "APPEND",
                    (String) mSArrayList.get(i).getValue("id").getValue()
                            + ";" + mSArrayList.get(i).getValue("name").getValue()
                            + ";" +mSArrayList.get(i).getValue("last_modified").getValue());
        }


        // the workspace
        //octaneBuilder.workSpace(vnWorkspace);

        // finally we build the context and get an Octane instance:

        //Octane octane = octaneBuilder.build();

        return octaneBuilder;

    }

    public static Octane.Builder GetNodes2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        // finally we build the context and get an Octane instance:

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\list_nodes\\"
                + vnWorkspace + "_" + vnSharedSpace + "_list_nodes.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("list_nodes").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID; Name; Logical_Name");
        for (int i = 0; i < mlArrayList.size(); i++) {

            ctextfiles.writeTextFile(PATH,
                    "APPEND",
                    (String) mlArrayList.get(i).getValue("id").getValue()
                            + ";" + mlArrayList.get(i).getValue("name").getValue()
                            + ";" +mlArrayList.get(i).getValue("logical_name").getValue());
        }

        voConn.signOut();

        return voOctane;
    }

    public static Octane.Builder GetPhases2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\phases\\"
                + vnWorkspace + "_" + vnSharedSpace + "_phases.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("phases").get().execute();

         ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID; Name; Logical_Name");

        for (int i = 0; i < mlArrayList.size(); i++) {

            ctextfiles.writeTextFile(PATH,
                    "APPEND",
                    (String) mlArrayList.get(i).getValue("id").getValue()
                            + ";" + mlArrayList.get(i).getValue("name").getValue()
                            + ";" + mlArrayList.get(i).getValue("logical_name").getValue());
          }

        voConn.signOut();

        return voOctane;
    }

     public static Octane.Builder GetReleases2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\releases\\"
                + vnWorkspace + "_" + vnSharedSpace + "_releases.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("releases").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID; Name; Start_date; End_date");

        for (int i = 0; i < mlArrayList.size(); i++) {

            ctextfiles.writeTextFile(PATH,
                    "APPEND",
                    (String) mlArrayList.get(i).getValue("id").getValue()
                            + ";" + mlArrayList.get(i).getValue("name").getValue()
                            + ";" + mlArrayList.get(i).getValue("start_date").getValue()
                            + ";" + mlArrayList.get(i).getValue("end_date").getValue());
        }

        voConn.signOut();

        return voOctane;
    }



    public static Octane.Builder GetEpics2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\epics\\"
                + vnWorkspace + "_" + vnSharedSpace + "_epics.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("epics").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,Name;Epic_type;Features;Phase;Author");

        for (int i = 1; i < mlArrayList.size(); i++) {
            EntityModel voEpicType = (EntityModel) mlArrayList.get(i).getValue("epic_type").getValue();
            EntityModel voPhase = (EntityModel) mlArrayList.get(i).getValue("phase").getValue();
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();

            if (voEpicType.getValue("id")!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + voEpicType.getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("features").getValue()
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + voAuthor.getValue("id").getValue());
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";;"
                                + ";" + mlArrayList.get(i).getValue("features").getValue()
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + voAuthor.getValue("id").getValue());

            }

        }

        voConn.signOut();

        return voOctane;
    }

    public static Octane.Builder GetFeatures2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\features\\"
                + vnWorkspace + "_" + vnSharedSpace + "_features.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("features").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,Name;Feature_type;Phase;Author;Stories;Epic;Priority;Defects");

        for (int i = 0; i < mlArrayList.size(); i++) {
            EntityModel voFeatureType = (EntityModel) mlArrayList.get(i).getValue("feature_type").getValue();
            EntityModel voPhase = (EntityModel) mlArrayList.get(i).getValue("phase").getValue();
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();
            EntityModel voParent = (EntityModel) mlArrayList.get(i).getValue("parent").getValue();
            EntityModel voPriority = (EntityModel) mlArrayList.get(i).getValue("priority").getValue();
            String vsPriority="";
            if (voPriority ==null)
            {
                vsPriority= "";

            } else {
                vsPriority=(String) voPriority.getValue("id").getValue();
            }
            //ArrayList<EntityModel> voAppModules = (ArrayList<EntityModel>) mlArrayList.get(i).getValue("product_areas").getValue();

            if (voFeatureType!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + IfNULL((String) voFeatureType.getValue("id").getValue())
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("user_stories").getValue()
                                + ";" + IfNULL((String)voParent.getValue("id").getValue())
                                + ";" + vsPriority
                                + ";" + mlArrayList.get(i).getValue("defects").getValue());
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";;"
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("user_stories").getValue()
                                + ";" + IfNULL((String)voParent.getValue("id").getValue())
                                + ";" + vsPriority
                                + ";" + mlArrayList.get(i).getValue("defects").getValue());

            }

        }

        voConn.signOut();

        return voOctane;
    }




    public static Octane.Builder GetStories2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\stories\\"
                + vnWorkspace + "_" + vnSharedSpace + "_stories.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("stories").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,Name;Story_type;Phase;Author;Last_modified;Feature;Priority");

        for (int i = 0; i < mlArrayList.size(); i++) {
            EntityModel voStoryType = (EntityModel) mlArrayList.get(i).getValue("feature_type").getValue();
            EntityModel voPhase = (EntityModel) mlArrayList.get(i).getValue("phase").getValue();
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();
            EntityModel voParent = (EntityModel) mlArrayList.get(i).getValue("parent").getValue();
            EntityModel voPriority = (EntityModel) mlArrayList.get(i).getValue("priority").getValue();
            String vsPriority="";
            if (voPriority ==null)
            {
                vsPriority= "";

            } else {
                vsPriority=(String) voPriority.getValue("id").getValue();
            }
            //ArrayList<EntityModel> voAppModules = (ArrayList<EntityModel>) mlArrayList.get(i).getValue("product_areas").getValue();

            if (voStoryType!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + IfNULL((String) voStoryType.getValue("id").getValue())
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + IfNULL((String)voParent.getValue("id").getValue())
                                + ";" + vsPriority);
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";;"
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + IfNULL((String)voParent.getValue("id").getValue())
                                + ";" + vsPriority);

            }

        }

        voConn.signOut();

        return voOctane;
    }


    public static String IfNULL(String vsInput)
    {
        String vsReturn;

        if (vsInput==null)
        {vsReturn="";}
        else
        {vsReturn=vsInput;}

        return "";
    }

}
