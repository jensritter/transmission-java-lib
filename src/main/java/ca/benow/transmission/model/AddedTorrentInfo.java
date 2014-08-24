package ca.benow.transmission.model;

import org.json.*;
import org.slf4j.*;

public class AddedTorrentInfo extends JSONAccessor {

    private static Logger logger = LoggerFactory.getLogger(AddedTorrentInfo.class);

    public AddedTorrentInfo(JSONObject jsonObject) {
        super(jsonObject);
    }

    public int getId() throws JSONException {
        return obj.getInt("id");
    }

    public String getName() throws JSONException {
        return obj.getString("name");
    }

    public String getHashString() throws JSONException {
        return obj.getString("hashString");
    }

    @Override
    public String toString() {
        try {
            return obj.toString(2);
        } catch (JSONException e) {
            logger.error(e.getMessage(),e);
            return e.getMessage();
        }

    }
}
