package doublylinkedlist.moviemanagementsystem;

class MovieManagementSystem {
    MovieNode head;
    MovieNode tail;

    // Constructor to initialize the doubly linked list
    public MovieManagementSystem() {
        head = null;
        tail = null;
    }

    // Add a movie at the beginning of the list
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a movie at the end of the list
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Add a movie at a specific position
    public void addMovieAtPosition(int position, String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (position == 0) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode current = head;
        int count = 0;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }
        if (current != null) {
            newNode.prev = current.prev;
            newNode.next = current;
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
            if (current == head) {
                head = newNode;
            }
        } else {
            addMovieAtEnd(title, director, year, rating);
        }
    }

    // Remove a movie by title
    public boolean removeMovieByTitle(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == head) {
                    head = current.next;
                }
                if (current == tail) {
                    tail = current.prev;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Search for a movie by director or rating
    public void searchMovie(String director, Double rating) {
        MovieNode current = head;
        while (current != null) {
            if ((director != null && current.director.equals(director)) || (rating != null && current.rating == rating)) {
                System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            }
            current = current.next;
        }
    }

    // Display all movies in forward order
    public void displayMoviesForward() {
        MovieNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayMoviesReverse() {
        MovieNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's rating based on the Movie Title
    public boolean updateMovieRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
