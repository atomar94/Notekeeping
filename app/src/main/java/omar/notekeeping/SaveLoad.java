package omar.notekeeping;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;

public class SaveLoad
{
    String filename = "data.txt";
    public void save(JSONObject j, Context c)
    {
        try
        {
            JSONArray notearray = load(c);
            FileOutputStream fos = c.openFileOutput(filename, Context.MODE_PRIVATE);
            notearray.put(j);
            fos.write(notearray.toString().getBytes());
        }
        catch (FileNotFoundException e )
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public JSONArray load(Context c)
    {
        try
        {
            FileInputStream fis = c.openFileInput(filename);
            InputStreamReader nip = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(nip);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                sb.append(line);
            }
            if (sb.toString() == "")
            {
                return new JSONArray();
            }
            return new JSONArray(sb.toString());
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
