package ca.benow.transmission;

import java.io.InputStream;

public class AddTorrentParameter {
    String downloadDir;
    String torrentFileNameOrURL;
    InputStream metaInfo;
    boolean paused;
    int peerLimit;
    int bandwidthPriority;
    int[] filesWanteds;
    int[] filesUnwanteds;
    int[] priorityHighs;
    int[] priorityLows;
    int[] priorityNormals;

    public AddTorrentParameter(String downloadDir, String torrentFileNameOrURL, InputStream metaInfo, boolean paused, int peerLimit, int bandwidthPriority, int[] filesWanteds, int[] filesUnwanteds, int[] priorityHighs, int[] priorityLows, int[] priorityNormals) {
        this.downloadDir = downloadDir;
        this.torrentFileNameOrURL = torrentFileNameOrURL;
        this.metaInfo = metaInfo;
        this.paused = paused;
        this.peerLimit = peerLimit;
        this.bandwidthPriority = bandwidthPriority;
        this.filesWanteds = filesWanteds;
        this.filesUnwanteds = filesUnwanteds;
        this.priorityHighs = priorityHighs;
        this.priorityLows = priorityLows;
        this.priorityNormals = priorityNormals;
    }

    public AddTorrentParameter() {

    }

    public static AddTorrentParameter builder() {
        return new AddTorrentParameter();
    }

    public AddTorrentParameter downloadDir(String value) {
        downloadDir = value;
        return this;
    }

    public AddTorrentParameter torrentFileNameOrURL(String value) {
        torrentFileNameOrURL = value;
        return this;
    }

    public AddTorrentParameter metaInfo(InputStream value) {
        metaInfo = value;
        return this;
    }

    public AddTorrentParameter paused(Boolean value) {
        paused = value;
        return this;
    }

    public AddTorrentParameter peerLimit(int value) {
        peerLimit = value;
        return this;
    }

    public AddTorrentParameter bandwidthPriority(int value) {
        bandwidthPriority = value;
        return this;
    }

    public AddTorrentParameter filesWanteds(int[] value) {
        filesWanteds = value;
        return this;
    }

    public AddTorrentParameter filesUnwanteds(int[] value) {
        filesUnwanteds = value;
        return this;
    }

    public AddTorrentParameter priorityHighs(int[] value) {
        priorityHighs = value;
        return this;
    }

    public AddTorrentParameter priorityLows(int[] value) {
        priorityLows = value;
        return this;
    }

    public AddTorrentParameter priorityNormals(int[] value) {
        priorityNormals = value;
        return this;
    }
}