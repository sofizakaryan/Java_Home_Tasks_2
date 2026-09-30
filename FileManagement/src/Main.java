import java.io.*;

void main() {
    String songLyrics = "In the town where I was born\n" +
            "Lived a man who sailed to sea\n" +
            "And he told us of his life\n" +
            "In the land of submarines\n" +
            "So we sailed on to the sun\n" +
            "'Til we found a sea of green\n" +
            "And we lived beneath the waves\n" +
            "In our yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "And our friends are all aboard\n" +
            "Many more of them live next door\n" +
            "And the band begins to play\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "Full steam ahead, Mister Boatswain, full steam ahead\n" +
            "Full steam ahead it is, Sergeant\n" +
            "(Cut the cable, drop the cable)\n" +
            "Aye-aye, sir, aye-aye\n" +
            "Captain, captain\n" +
            "As we live a life of ease (a life of ease)\n" +
            "Every one of us (every one of us)\n" +
            "Has all we need (has all we need)\n" +
            "Sky of blue (sky of blue)\n" +
            "And sea of green (sea of green)\n" +
            "In our yellow (in our yellow)\n" +
            "Submarine (submarine, aha)\n" +
            "We all live in a yellow submarine\n" +
            "A yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "A yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine\n" +
            "We all live in a yellow submarine\n" +
            "Yellow submarine, yellow submarine";

    String fileName = "song.txt";

    WriteSongToFile(fileName, songLyrics);

    String songFromFile = ReadSongFromFile(fileName);
//    System.out.println(songFromFile);

    if (songFromFile != null) {
        try {
            VerifyString(songFromFile, "(Cut the cable, drop the cable)");
        } catch (BeatlesException e) {
            System.out.println(e.getMessage());
        }
    }
}

void WriteSongToFile(String fileName, String song) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) { // to automaticly close
        writer.write(song);
    } catch (IOException e) {
        System.out.println("Writer error: " + e.getMessage());
    }
}

String ReadSongFromFile(String fileName) {
    StringBuilder song = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = reader.readLine()) != null) {
            song.append(line).append("\n");
        }
        return song.toString();
    } catch (IOException e) {
        System.out.println("Readline error: " + e.getMessage());
    }
    return null;
}

void VerifyString(String song, String text) throws BeatlesException {
    if (!song.contains(text)) {
        throw new BeatlesException("\"" + text + "\" was not found in the song");
    }
    System.out.println("\"" + text + "\" was found in the song.");
}

class BeatlesException extends Exception {
    public BeatlesException(String message) {
        super("Beatles: " + message);
    }
}