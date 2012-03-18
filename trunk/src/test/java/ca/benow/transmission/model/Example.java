package ca.benow.transmission.model;

import java.net.URL;
import java.util.List;

import ca.benow.transmission.TransmissionClient;

public class Example {

  /**
   * @param args
   */
  public static void main(
      String[] args) {
    try {
      TransmissionClient client = new TransmissionClient(new URL("http://hacker:linux@192.168.100.1:9091/transmission/rpc"));
      List<TorrentStatus> torrents = client.getAllTorrents();
      for (TorrentStatus curr : torrents) {
          if (curr.getId() == 2) {
              System.out.println(curr.getJSONObject());
          }
      }

      System.exit(0);
    } catch (Throwable e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

}
