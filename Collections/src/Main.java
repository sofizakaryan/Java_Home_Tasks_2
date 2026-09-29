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

    String cleaned = CleanLowerString(songLyrics);

//    System.out.println("Cleaned Text\n");
//    System.out.println(cleaned);
//    System.out.println();


    String[] wordsArray = ToArrayOfWords(cleaned);

//    System.out.println("Array of words\n");
//    for (String word : wordsArray)
//        System.out.println(word);
//    System.out.println();

    PrintWordCounts(wordsArray);

}

String CleanLowerString(String songLyrics)
{
    return songLyrics.replaceAll("\n", " ")
            .replaceAll(",", "")
            .replaceAll("\\(", "")
            .replaceAll("\\)", "")
            .toLowerCase();
}

String[] ToArrayOfWords(String songLyrics)
{
    return songLyrics.split(" ");
}

void PrintWordCounts(String[] arr)
{
    Map<String, Integer> counts = new HashMap<>();
    for (String word : arr)
        counts.put(word, counts.getOrDefault(word, 0) + 1);

    counts.forEach((word, count) -> System.out.println(word + " " + count));
}