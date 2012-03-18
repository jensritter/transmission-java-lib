package ca.benow.transmission.model;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import ca.benow.transmission.model.TorrentStatus.TorrentField;

public class TorrentStatusTest {

    private static final String JSON="{\"id\":2,\"status\":0,\"name\":\"linuxmint-12-gnome-dvd-64bit.iso\",\"percentDone\":1}";

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
/*
    @Test
    public void testGetDateField() {
        // no method is using this
    }
*/
    @Test
    public void testToString() {
        assertEquals("{\n"
                + "  \"id\": 2,\n"
                + "  \"name\": \"linuxmint-12-gnome-dvd-64bit.iso\",\n"
                + "  \"percentDone\": 1,\n"
                + "  \"status\": 0\n"
                + "}",status.toString());
    }

}
