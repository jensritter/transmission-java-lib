package ca.benow.transmission.model;

import java.util.List;

import ca.benow.transmission.TransmissionClient;
import ca.benow.transmission.model.TorrentStatus.TorrentField;

public class Example {

  /**
   * @param args
   */
  public static void main(String[] args) {
    try {
        
      TransmissionClient client = new TransmissionClient("192.168.100.1", "hacker", "linux");
      List<TorrentStatus> torrents = client.getAllTorrents(new TorrentField[] { TorrentField.doneDate,TorrentField.id, TorrentField.dateCreated, TorrentField.name});

      //client.addTorrent("magnet:?xt=urn:btih:06af168404029a8ca21a06c43fcb7dd49c288c4f&dn=debian-6.0.7-amd64-CD-1.iso&tr=http%3A%2F%2Fbttracker.debian.org%3A6969%2Fannounce");
      
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
