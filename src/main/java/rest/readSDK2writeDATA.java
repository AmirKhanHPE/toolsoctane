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
                (String) "ID,Name;Story_type;Phase;Author;Last_modified;Feature");

        for (int i = 0; i < mlArrayList.size(); i++) {
            String voStoryType = (String) mlArrayList.get(i).getValue("type").getValue();
            EntityModel voPhase = (EntityModel) mlArrayList.get(i).getValue("phase").getValue();
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();
            EntityModel voParent = (EntityModel) mlArrayList.get(i).getValue("parent").getValue();
            //EntityModel voPriority = (EntityModel) mlArrayList.get(i).getValue("priority").getValue();
            //ArrayList<EntityModel> voAppModules = (ArrayList<EntityModel>) mlArrayList.get(i).getValue("product_areas").getValue();

            if (voStoryType!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + voStoryType
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + IfNULL((String)voParent.getValue("id").getValue()));
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";;"
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + IfNULL((String)voParent.getValue("id").getValue()));

            }

        }

        voConn.signOut();

        return voOctane;
    }



    public static Octane.Builder GetDefects2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\defects\\"
                + vnWorkspace + "_" + vnSharedSpace + "_defects.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("defects").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,Name;Story_type;Phase;Author;Last_modified;Feature");

        for (int i = 0; i < mlArrayList.size(); i++) {
            String voBugType = (String) mlArrayList.get(i).getValue("type").getValue();
            EntityModel voPhase = (EntityModel) mlArrayList.get(i).getValue("phase").getValue();
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();
            EntityModel voParent = (EntityModel) mlArrayList.get(i).getValue("parent").getValue();
            EntityModel voSeverity = (EntityModel) mlArrayList.get(i).getValue("severity").getValue();
            //ArrayList<EntityModel> voAppModules = (ArrayList<EntityModel>) mlArrayList.get(i).getValue("product_areas").getValue();
            String vsSeverity = "";
            if (voSeverity!=null) {
                vsSeverity= (String) voSeverity.getValue("id").getValue();

            }

            if (voBugType!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + voBugType
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + IfNULL((String)voParent.getValue("id").getValue())
                                + ":" + vsSeverity);
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
                                + ":" + vsSeverity);

            }

        }

        voConn.signOut();

        return voOctane;
    }



    public static Octane.Builder GetManualTests2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\tests\\manual_tests\\"
                + vnWorkspace + "_" + vnSharedSpace + "_manual_tests.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("manual_tests").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,Name;Phase;Author;Last_modified;steps_num");

        for (int i = 0; i < mlArrayList.size(); i++) {
            EntityModel voPhase = (EntityModel) mlArrayList.get(i).getValue("phase").getValue();
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();
            //ArrayList<EntityModel> voAppModules = (ArrayList<EntityModel>) mlArrayList.get(i).getValue("product_areas").getValue();

            if (voAuthor!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + mlArrayList.get(i).getValue("steps_num").getValue());
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + voPhase.getValue("id").getValue()
                                + ";;"
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + mlArrayList.get(i).getValue("steps_num").getValue());

            }

        }

        voConn.signOut();

        return voOctane;
    }


    public static Octane.Builder GetGherkinTests2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\tests\\gherkin_tests\\"
                + vnWorkspace + "_" + vnSharedSpace + "_gherkin_tests.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("gherkin_tests").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,Name;Phase;Author;Last_modified;steps_num;automation_status");

        for (int i = 0; i < mlArrayList.size(); i++) {
            EntityModel voPhase = (EntityModel) mlArrayList.get(i).getValue("phase").getValue();
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();
            EntityModel voAutomationStatus = (EntityModel) mlArrayList.get(i).getValue("automation_status").getValue();
            //ArrayList<EntityModel> voAppModules = (ArrayList<EntityModel>) mlArrayList.get(i).getValue("product_areas").getValue();

            if (voAuthor!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + voPhase.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + mlArrayList.get(i).getValue("steps_num").getValue()
                                + ";" + voAutomationStatus.getValue("id").getValue());
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + voPhase.getValue("id").getValue()
                                + ";;"
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + mlArrayList.get(i).getValue("steps_num").getValue()
                                + ";" + voAutomationStatus.getValue("id").getValue());

            }

        }

        voConn.signOut();

        return voOctane;
    }


    public static Octane.Builder GetTestSuites2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\tests\\test_suites\\"
                + vnWorkspace + "_" + vnSharedSpace + "_test_suites.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("test_suites").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,Name;Author;Last_modified");

        for (int i = 0; i < mlArrayList.size(); i++) {
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();
            //ArrayList<EntityModel> voAppModules = (ArrayList<EntityModel>) mlArrayList.get(i).getValue("product_areas").getValue();

            if (voAuthor!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue());
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";;"
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue());

            }

        }

        voConn.signOut();

        return voOctane;
    }

    public static Octane.Builder GetTestsInSuites2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\tests\\test_suite_link_to_tests\\"
                + vnWorkspace + "_" + vnSharedSpace + "_test_suite_link_to_tests.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("test_suite_link_to_tests").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,testsuite_id;test_id;author;Last_modified");

        for (int i = 0; i < mlArrayList.size(); i++) {
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();
            EntityModel voTestSuite = (EntityModel) mlArrayList.get(i).getValue("test_suite").getValue();
            EntityModel voTest = (EntityModel) mlArrayList.get(i).getValue("test").getValue();
            //ArrayList<EntityModel> voAppModules = (ArrayList<EntityModel>) mlArrayList.get(i).getValue("product_areas").getValue();

            if (voAuthor!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + voTestSuite.getValue("id").getValue()
                                + ";" + voTest.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue());
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + voTestSuite.getValue("id").getValue()
                                + ";" + voTest.getValue("id").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue());
            }

        }

        voConn.signOut();

        return voOctane;
    }


    public static Octane.Builder GetTasks2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\tasks\\"
                + vnWorkspace + "_" + vnSharedSpace + "_tasks.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("tasks").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,Name;author;story;last_modified;progress");

        for (int i = 0; i < mlArrayList.size(); i++) {
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();
            EntityModel voStory = (EntityModel) mlArrayList.get(i).getValue("story").getValue();
            String vsProgess = "";
            //ArrayList<EntityModel> voAppModules = (ArrayList<EntityModel>) mlArrayList.get(i).getValue("product_areas").getValue();
            if (mlArrayList.get(i).getValue("progress")!=null)
            {
                vsProgess= (String) mlArrayList.get(i).getValue("progress").getValue();
            }
            if (voAuthor!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + voStory.getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + vsProgess);
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";;"
                                + ";" + voStory.getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + vsProgess);
            }

        }

        voConn.signOut();

        return voOctane;
    }

    public static Octane.Builder GetManualRuns2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\runs\\manual_runs\\"
                + vnWorkspace + "_" + vnSharedSpace + "_manual_runs.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("manual_runs").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,Name;author;run_by;status;test;test_name;last_modified");

        for (int i = 0; i < mlArrayList.size(); i++) {
            EntityModel voAuthor = (EntityModel) mlArrayList.get(i).getValue("author").getValue();
            EntityModel voTester = (EntityModel) mlArrayList.get(i).getValue("run_by").getValue();
            EntityModel voTest = (EntityModel) mlArrayList.get(i).getValue("test").getValue();
            EntityModel voStatus = (EntityModel) mlArrayList.get(i).getValue("native_status").getValue();
            if (voAuthor!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + IfNULL((String)voAuthor.getValue("id").getValue())
                                + ";" + IfNULL((String)voTester.getValue("id").getValue())
                                + ";" + voStatus.getValue("id").getValue()
                                + ";" + voTest.getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("test_name").getValue()
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue());
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";;"
                                + ";" + IfNULL((String)voTester.getValue("id").getValue())
                                + ";" + voStatus.getValue("id").getValue()
                                + ";" + voTest.getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("test_name").getValue()
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue());
            }

        }

        voConn.signOut();

        return voOctane;
    }

    public static Octane.Builder GetAutomatedRuns2File (Octane.Builder voOctane, int vnSharedSpace, int vnWorkspace) throws IOException

    {
        voOctane.workSpace(vnWorkspace);

        Octane voConn = voOctane.build();

        String PATH = "C:\\Users\\khanami\\IdeaProjects\\toolsoctane\\webapp\\data\\runs\\automated_runs\\"
                + vnWorkspace + "_" + vnSharedSpace + "_automated_runs.txt";
        //List nodes
        ArrayList<EntityModel> mlArrayList = (ArrayList<EntityModel>) voConn.entityList("automated_runs").get().execute();

        ctextfiles.writeTextFile(PATH,
                "NEW",
                (String) "ID,Name;status;test;test_name;last_modified;past_status");

        for (int i = 0; i < mlArrayList.size(); i++) {
            EntityModel voTest = (EntityModel) mlArrayList.get(i).getValue("test").getValue();
            EntityModel voStatus = (EntityModel) mlArrayList.get(i).getValue("native_status").getValue();
            if (voTest!=null) {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + voStatus.getValue("id").getValue()
                                + ";" + voTest.getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("test_name").getValue()
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + mlArrayList.get(i).getValue("past_status").getValue());
            } else {
                ctextfiles.writeTextFile(PATH,
                        "APPEND",
                        (String) mlArrayList.get(i).getValue("id").getValue()
                                + ";" + mlArrayList.get(i).getValue("name").getValue()
                                + ";" + voStatus.getValue("id").getValue()
                                + ";;"
                                + ";" + mlArrayList.get(i).getValue("test_name").getValue()
                                + ";" + mlArrayList.get(i).getValue("last_modified").getValue()
                                + ";" + mlArrayList.get(i).getValue("past_status").getValue());
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

        return vsReturn;
    }

}
