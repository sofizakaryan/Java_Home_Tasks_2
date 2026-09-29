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

    // 111111111111
    String cleaned = CleanLowerString(songLyrics);
    String[] wordsArray = cleaned.split(" ");

    System.out.println("1) Count words (using array)");
    PrintWordCountsArrayVersion(wordsArray);


    // 222222222222
    List<String> wordsList = new ArrayList<>(Arrays.asList(wordsArray));

    System.out.println("\n2) Count words using collections");
    PrintWordCountsMapVersion(wordsList);


    // 222222222222.2
    Set<String> uniqueWords = new HashSet<String>(wordsList);

    System.out.println("\n2.2) No duplicates:");
    System.out.println(String.join(" ", uniqueWords));


    // 222222222222.3
    List<String> sortedWords = new ArrayList<>(wordsList);
    sortedWords.sort(Comparator.comparingInt(String::length));

    System.out.println("\n2.3) Words sorted by length:");
    System.out.println(String.join(" ", sortedWords));


    // 3333333333333
//    wordsList.removeIf(word ->
//            word.equals("yellow") || word.equals("submarine"));

    Iterator<String> itr = wordsList.iterator();
    while (itr.hasNext()) {
        String word = itr.next();

        if (word.equals("yellow") || word.equals("submarine")) {
            itr.remove();
        }
    }

    System.out.println("\n3) No yellow and submarine");
    System.out.println(String.join(" ", wordsList));
}

String CleanLowerString(String songLyrics) {
    return new String(songLyrics.replaceAll("\n", " ")
            .replaceAll(",", "")
            .replaceAll("\\(", "")
            .replaceAll("\\)", "")
            .toLowerCase());
}

void PrintWordCountsArrayVersion(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
        boolean Counted = false;

        for (int j = 0; j < i; j++) {
            if (arr[i].equals(arr[j])) {
                Counted = true;
                break;
            }
        }

        if (Counted) {
            continue;
        }

        int count = 0;

        for (int j = i; j < arr.length; j++) {
            if (arr[i].equals(arr[j])) {
                count++;
            }
        }

        System.out.println(arr[i] + " " + count);
    }
}

void PrintWordCountsMapVersion(List<String> arg) {
    Map<String, Integer> counts = new HashMap<>();
    for (String word : arg)
        counts.put(word, counts.getOrDefault(word, 0) + 1);

    counts.forEach((word, count) -> System.out.println(word + " " + count));
}