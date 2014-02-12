package com.jtdev.breakdown.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.jtdev.breakdown.Constants;
import com.jtdev.breakdown.entities.World;

/**
 * Created with IntelliJ IDEA.
 * User: AeroX2
 * Date: 21/08/13
 * Time: 12:54 PM
 */
public class FileManager
{
    private Json json;
    private Logger logger;
    private Profile profile;
    private FileHandle file;
    private World world;

    public FileManager(World world)
    {
        logger = new Logger(this);

        this.world = world;

        json = new Json();
        //file = new FileHandle(Constants.FILE_PATH);
        profile = new Profile();

        getCurrentFile();
        if (file.exists()) read();
    }

    public void read()
    {
        logger.log("Reading profile");
        String jsonData = file.readString();

        logger.log("Profile Not Initialized");
        profile = json.fromJson(Profile.class, jsonData);

        logger.log("Done reading profile");
    }

    public void write()
    {
        logger.log("Saving profile");
        String profileString = json.prettyPrint(json.toJson(profile));
        file.writeString(profileString,false);
        logger.log("Done saving profile");
    }

    public void getNewFile()
    {
        /*int i = 1;
        String filePath = Constants.FILE_PATH + i;
        file = Gdx.files.absolute(filePath);

        while (file.exists())
        {
            i++;
            filePath = Constants.FILE_PATH + i;
            file = Gdx.files.absolute(filePath);
        }*/
        String filePath = Constants.FILE_PATH;
        file = Gdx.files.absolute(filePath);

        logger.log("New file location " + filePath);
    }

    public void getCurrentFile()
    {
        //TODO should be a better way to do this
        /*int i = 1;
        String filePath = Constants.FILE_PATH + i;
        file = Gdx.files.absolute(filePath);

        while (file.exists())
        {
            i++;
            filePath = Constants.FILE_PATH + i;
            file = Gdx.files.absolute(filePath);
        }
        i--;
        filePath = Constants.FILE_PATH + i;
        file = Gdx.files.absolute(filePath);*/
        String filePath = Constants.FILE_PATH;
        file = Gdx.files.absolute(filePath);

        logger.log("Current file location " + filePath);
    }

    public FileHandle getFile() { return file; }
    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }
}
