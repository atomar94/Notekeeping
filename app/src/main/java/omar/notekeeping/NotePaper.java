package omar.notekeeping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.GregorianCalendar;
import omar.notekeeping.SaveLoad;

public class NotePaper extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_paper);
    }
    public void saveButton(View view)
    {
        SaveLoad sl = new SaveLoad ();
        EditText titlet = (EditText)findViewById(R.id.Title);
        EditText NotePadet = (EditText)findViewById(R.id.NotePad);
        String titletext = titlet.getText().toString();
        String notepad = NotePadet.getText().toString();
        JSONObject jason = new JSONObject();

        GregorianCalendar cal = new GregorianCalendar();
        int year =      cal.get(Calendar.YEAR);
        int month =     cal.get(Calendar.MONTH);
        int day =       cal.get(Calendar.DAY_OF_MONTH);

        try
        {
            jason.put("title", titletext);
            jason.put("notepad", notepad);
            jason.put("year", year);
            jason.put("month", month);
            jason.put("day", day);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        sl.save(jason, this);
        JSONArray notearray = sl.load(this);
        int x = 3;
    }
}