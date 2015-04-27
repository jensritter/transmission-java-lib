package ca.benow.transmission;

import java.io.*;

/**
 * From http://www.wikihow.com/Encode-a-String-to-Base64-With-Java
 * <p/>
 * With modificiations.
 * <p/>
 * Prevents dependance on sun jdk's Base64Encoder
 *
 * @author andy
 *
 */
final class Base64 {

    private Base64() { }

    private static final String BASE64CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwxyz" + "0123456789" + "+/";

    private static final int SPLITLINESAT = 76;

    private static byte[] zeroPad(int length, byte[] bytes) {
        byte[] padded = new byte[length]; // initialized to zero by JVM
        System.arraycopy(bytes, 0, padded, 0, bytes.length);
        return padded;
    }

    public static String encode(String value) {

        byte[] stringArray;
        try {
            stringArray = value.getBytes("UTF-8"); // use appropriate encoding
            // string!
        } catch (UnsupportedEncodingException ignored) {
            stringArray = value.getBytes(); // use locale default rather than croak
        }
        return encode(stringArray);
    }

    public static String encode(final byte[] bytesValue) {
        String encoded = "";
        // determine how many padding bytes to add to the output
        int paddingCount = (3 - (bytesValue.length % 3)) % 3;
        // add any necessary padding to the input
        byte[] bytes = zeroPad(bytesValue.length + paddingCount, bytesValue);
        // process 3 bytes at a time, churning out 4 output bytes
        // worry about CRLF insertions later
        for (int i = 0; i < bytes.length; i += 3) {
            int j = ((bytes[i] & 0xff) << 16) + ((bytes[i + 1] & 0xff) << 8)
                    + (bytes[i + 2] & 0xff);
            encoded = encoded + BASE64CODE.charAt((j >> 18) & 0x3f)
                    + BASE64CODE.charAt((j >> 12) & 0x3f)
                    + BASE64CODE.charAt((j >> 6) & 0x3f) + BASE64CODE.charAt(j & 0x3f);
        }
        // replace encoded padding nulls with "="
        return splitLines(encoded.substring(0, encoded.length() - paddingCount)
                + "==".substring(0, paddingCount));
    }

    private static String splitLines(String string) {
        String lines = "";
        for (int i = 0; i < string.length(); i += SPLITLINESAT) {
            lines += string.substring(i, Math.min(string.length(), i + SPLITLINESAT));
        }
        return lines;
    }


    public static void encode(InputStream in, OutputStream out) throws IOException {
        ByteArrayOutputStream tout = new ByteArrayOutputStream();
        byte[] buff = new byte[512];
        int read = in.read(buff);
        while (read > 0) {
            tout.write(buff, 0, read);
            read = in.read(buff);
        }
        String result = encode(tout.toByteArray());
        out.write(result.getBytes());
    }

}
