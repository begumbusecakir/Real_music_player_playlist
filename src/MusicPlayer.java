class MusicPlayer {
    private Song head;
    private Song tail;
    private Song current;

public void addSong(String title) {
    Song newSong = new Song(title);
    if (head == null) {
        head = newSong;
        tail = newSong;
        current = head;
    } else {
        tail.next = newSong;
        newSong.prev = tail;
        tail = newSong;
    }
    System.out.println(title + " added to the list.");
}

public void removeSong(String title) {
    Song temp = head;
    while (temp != null) {
        if (temp.title.equals(title)) {
            if (temp.prev != null)
                temp.prev.next = temp.next;
            else
                head = temp.next;
            if (temp.next != null)
                temp.next.prev = temp.prev;
            else
                tail = temp.prev;
            System.out.println(title + " removed from the list.");
            if (current == temp)
                current = temp.next != null ? temp.next : head;
            return;
        }
        temp = temp.next;
    }
    System.out.println("not founded song:" + title);
}

public void nextSong() {
    if (current != null && current.next != null) {
        current = current.next;
        System.out.println("current song: " + current.title);
    } else {
        System.out.println("last song.");
    }
}

public void previousSong() {
    if (current != null && current.prev != null) {
        current = current.prev;
        System.out.println("current song: " + current.title);
    } else {
        System.out.println("first song");
    }
}

public void showCurrent() {
    if (current != null)
        System.out.println("current song: " + current.title);
    else
        System.out.println("The list is empty of songs.");
}

public void showPlaylist() {
    Song temp = head;
    System.out.println(" Song list");
    while (temp != null) {
        System.out.println("- " + temp.title);
        temp = temp.next;
    }
}
}