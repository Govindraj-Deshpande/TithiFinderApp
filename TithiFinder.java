package backend;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TithiFinder {
    public TithiResult findTithi(Date date) {
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
        SimpleDateFormat yearFormat  = new SimpleDateFormat("yyyy");
        String month = monthFormat.format(date);
        String year  = yearFormat.format(date);

        // Only allow December 2001
        if (!month.equalsIgnoreCase("December") || !year.equals("2001")) {
            return new TithiResult("We only have data for December 2001", null, null);
        }

        try (FileReader reader = new FileReader("backend/data/tithi-data-december-2001.json")) {
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray days = root.getAsJsonArray("days");

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int inputDate = cal.get(Calendar.DAY_OF_MONTH);

            for (int i = 0; i < days.size(); i++) {
                JsonObject dayObj = days.get(i).getAsJsonObject();
                int dateInData = dayObj.get("date").getAsInt();

                if (dateInData == inputDate) {
                    String tithi   = dayObj.get("tithi").getAsString();
                    String dayName = dayObj.get("day").getAsString();
                    return new TithiResult(tithi, null, dayName);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new TithiResult("Tithi data file not found.", null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return new TithiResult("Error reading tithi data.", null, null);
        }

        return new TithiResult("No tithi data found for selected date.", null, null);
    }
}
