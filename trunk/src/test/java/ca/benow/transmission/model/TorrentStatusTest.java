package ca.benow.transmission.model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import ca.benow.transmission.model.TorrentStatus.TorrentField;

public class TorrentStatusTest {

    private static final String JSON="{\"id\":2,\"status\":0,\"name\":\"linuxmint-12-gnome-dvd-64bit.iso\",\"percentDone\":1,\"dateCreated\":1322313588}";

    // 11/26/2011 2:19:48 PM

    @Before
    public void setUp() throws JSONException {
        jsonObj = new JSONObject(JSON);
        status = new TorrentStatus(jsonObj);
    }

    TorrentStatus status;
    JSONObject jsonObj;

    @Test
    public void testGetJSONObject() {
        assertEquals(jsonObj,status.getJSONObject());
    }

    @Test
    public void testGetField() throws JSONException {
        assertEquals(status.getName(),status.getField(TorrentField.name));
    }

    @Test
    public void testGetId() throws JSONException {
        assertEquals(2,status.getId());
    }

    @Test
    public void testGetPercentDone() throws JSONException {
        assertEquals(1D,status.getPercentDone(),0.000D);
    }

    @Test
    public void testGetStatus() throws JSONException {
        assertEquals(0,status.getStatus());
    }

    @Test
    public void testGetName() throws JSONException {
        assertEquals("linuxmint-12-gnome-dvd-64bit.iso",status.getName());
    }

    @Test
    public void testGetDateField() throws JSONException {
        //11/26/2011 2:19:48 PM
        // 2 == 14Uhr
        DateTime must = new DateTime(2011,11,26,14,19,48);
        Object obj = status.getField(TorrentField.dateCreated);
        assertEquals(Integer.class,obj.getClass());
        int value = (Integer)obj;
        assertEquals(1322313588,value);

        Date shouldDate = new Date(must.getMillis());
        Date isDate = status.getDateField(TorrentField.dateCreated);

        long mustSecon = must.getMillis();
        long isSecon = isDate.getTime();
        System.out.println(mustSecon);
        System.out.println(isSecon);

        assertEquals(shouldDate.toString(),isDate.toString());



    }

    @Test
    public void testGetDateFieldOther() throws JSONException {
        TorrentStatus status0 = new TorrentStatus(new JSONObject("{\"id\":2,\"doneDate\":0,\"status\":0,\"name\":\"linuxmint-12-gnome-dvd-64bit.iso\",\"percentDone\":1}"));
        TorrentStatus statusDate = new TorrentStatus(new JSONObject("{\"id\":2,\"doneDate\":1331952203,\"status\":0,\"name\":\"linuxmint-12-gnome-dvd-64bit.iso\",\"percentDone\":1}"));

        Date dateZero = status0.getDateField(TorrentField.doneDate);
        Date dateIs = statusDate.getDateField(TorrentField.doneDate);

        DateTime timeZero = new DateTime(dateZero);
        DateTime timeIs = new DateTime(dateIs);

        //3/17/2012 3:43:23 AM
        DateTime must = new DateTime(2012,3,17,3,43,23);
        DateTime must0 = new DateTime(0);

        assertEquals(must0, timeZero);
        assertEquals(must,timeIs);
    }

    @Test
    public void testToString() {
        assertEquals("{\n"
                + "  \"dateCreated\": 1322313588,\n"
                + "  \"id\": 2,\n"
                + "  \"name\": \"linuxmint-12-gnome-dvd-64bit.iso\",\n"
                + "  \"percentDone\": 1,\n"
                + "  \"status\": 0\n"
                + "}",status.toString());
    }

}
