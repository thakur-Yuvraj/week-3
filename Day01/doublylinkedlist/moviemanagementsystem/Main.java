package doublylinkedlist.moviemanagementsystem;

public class Main {
    public static void main(String[] args) {
        MovieManagementSystem system = new MovieManagementSystem();

        // Add some Hindi movies
        system.addMovieAtBeginning("Lagaan", "Ashutosh Gowariker", 2001, 8.1);
        system.addMovieAtEnd("Dilwale Dulhania Le Jayenge", "Aditya Chopra", 1995, 8.2);
        system.addMovieAtPosition(1, "Sholay", "Ramesh Sippy", 1975, 8.7);

        System.out.println("Movies in forward order:");
        system.displayMoviesForward();

        System.out.println("\nMovies in reverse order:");
        system.displayMoviesReverse();

        // Search movies by director
        System.out.println("\nMovies by Aditya Chopra:");
        system.searchMovie("Aditya Chopra", null);

        // Search movies by rating
        System.out.println("\nMovies with rating 8.2:");
        system.searchMovie(null, 8.2);

        // Update movie rating
        system.updateMovieRating("Lagaan", 8.3);
        System.out.println("\nUpdated Movies in forward order:");
        system.displayMoviesForward();

        // Remove a movie by title
        system.removeMovieByTitle("Sholay");
        System.out.println("\nMovies after removing 'Sholay':");
        system.displayMoviesForward();
    }
}
