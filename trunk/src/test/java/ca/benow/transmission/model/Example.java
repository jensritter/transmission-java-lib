package ca.benow.transmission.model;

import java.net.URL;
import java.util.List;

import ca.benow.transmission.TransmissionClient;
import ca.benow.transmission.model.TorrentStatus.TorrentField;

public class Example {

  /**
   * @param args
   */
  public static void main(
      String[] args) {
    try {
      TransmissionClient client = new TransmissionClient(new URL("http://hacker:linux@192.168.100.1:9091/transmission/rpc"));
      List<TorrentStatus> torrents = client.getAllTorrents(new TorrentField[] { TorrentField.doneDate,TorrentField.id, TorrentField.dateCreated, TorrentField.name});
      for (TorrentStatus curr : torrents) {
          if (curr.getId() == 28 || curr.getId() == 2) {
              //System.out.println(curr.getField(TorrentField.doneDate));
              System.out.println(curr.getField(TorrentField.name));
              Object wert = curr.getField(TorrentField.dateCreated);
              System.out.println(wert);

              //System.out.println(curr.getDateField(TorrentField.dateCreated));
              // 1/28/2012 3:20:16 PM
          }
      }

      System.exit(0);
    } catch (Throwable e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

}
