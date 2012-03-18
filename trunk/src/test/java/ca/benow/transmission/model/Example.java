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
      TransmissionClient client = new TransmissionClient(new URL("http://hacker:linux@matrix.jens.org:9091/transmission/rpc"));
      List<TorrentStatus> torrents = client.getAllTorrents();
      for (TorrentStatus curr : torrents)
        System.out.println(curr);

      System.exit(0);
    } catch (Throwable e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

}
